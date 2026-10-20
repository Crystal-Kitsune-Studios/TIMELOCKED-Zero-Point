package com.timelocked.client;

import com.timelocked.IntroSequence;
import com.timelocked.IntroLanding;
import com.timelocked.IntroNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.neoforged.neoforge.network.PacketDistributor;
import net.minecraft.Util;
import net.minecraft.client.*;
import net.minecraft.world.entity.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.*;

/** Local blackout and low-to-standing wake camera; no forced camera during playable home. */
@EventBusSubscriber(modid="timelocked",value=Dist.CLIENT)
public final class IntroClient {
    private static int stage,age,token,stable,ackTicks;private static BlockPos anchor=BlockPos.ZERO;private static long lastCue;private static Entity rig;private static CameraType previous;
    public static void cue(int s,int t,long a,int nonce){
        if(token!=nonce||stage!=s){stable=0;ackTicks=0;}anchor=BlockPos.of(a);token=nonce;
        if(s==IntroSequence.DONE){reset();return;}
        stage=s;age=t;lastCue=Util.getMillis();
        Minecraft mc=Minecraft.getInstance();
        if((s==IntroSequence.BLACKOUT||s==IntroSequence.WAKE||s==IntroSequence.LANDING)&&previous==null){previous=mc.options.getCameraType();mc.options.setCameraType(CameraType.FIRST_PERSON);}
    }
    static void reset(){Minecraft mc=Minecraft.getInstance();if(rig!=null){if(mc.getCameraEntity()==rig)mc.setCameraEntity(mc.player);rig.discard();rig=null;}if(previous!=null){mc.options.setCameraType(previous);previous=null;}stage=0;age=0;stable=0;ackTicks=0;token=0;}
    static boolean locked(){return stage==IntroSequence.BLACKOUT||stage==IntroSequence.WAKE||stage==IntroSequence.LANDING;}
    @SubscribeEvent public static void logout(ClientPlayerNetworkEvent.LoggingOut e){reset();}
    @SubscribeEvent public static void tick(ClientTickEvent.Post e){
        if(stage==0)return;Minecraft mc=Minecraft.getInstance();
        if(mc.player==null||mc.level==null||!mc.player.isAlive()||Util.getMillis()-lastCue>6000){reset();return;}
        age++;
        if(!locked())return;
        mc.options.setCameraType(CameraType.FIRST_PERSON);
        if((stage==IntroSequence.LANDING||stage==IntroSequence.WAKE)&&mc.level.dimension().equals(Level.OVERWORLD)){
            mc.player.setPos(anchor.getX()+.5,anchor.getY(),anchor.getZ()+.5);mc.player.setDeltaMovement(net.minecraft.world.phys.Vec3.ZERO);mc.player.fallDistance=0;
            if(stage==IntroSequence.LANDING){
                boolean loaded=true;
                for(int x=-1;x<=1;x++)for(int z=-1;z<=1;z++){var chunk=mc.level.getChunkSource().getChunk((anchor.getX()>>4)+x,(anchor.getZ()>>4)+z,ChunkStatus.FULL,false);if(chunk==null||chunk instanceof net.minecraft.world.level.chunk.EmptyLevelChunk)loaded=false;}
                stable=loaded&&IntroLanding.supported(mc.level,anchor)?stable+1:0;
                if(stable>=8&&ackTicks++%20==0)PacketDistributor.sendToServer(new IntroNetworking.Ready(token));
            }
        }
        if(rig==null||rig.level()!=mc.level){if(rig!=null)rig.discard();rig=EntityType.MARKER.create(mc.level);}
        if(rig==null)return;
        float f=Math.clamp((age-20)/100f,0,1);f=f*f*(3-2*f);
        double eye=stage==IntroSequence.WAKE?.6+1.02*f:mc.player.getEyeHeight();
        float pitch=stage==IntroSequence.WAKE?48*(1-f):mc.player.getXRot();
        boolean beach=stage==IntroSequence.WAKE||stage==IntroSequence.LANDING;
        rig.moveTo(beach?anchor.getX()+.5:mc.player.getX(),(beach?anchor.getY():mc.player.getY())+eye,beach?anchor.getZ()+.5:mc.player.getZ(),beach?-78:mc.player.getYRot(),pitch);
        rig.xo=rig.xOld=rig.getX();rig.yo=rig.yOld=rig.getY();rig.zo=rig.zOld=rig.getZ();rig.yRotO=rig.getYRot();rig.xRotO=rig.getXRot();mc.setCameraEntity(rig);
    }
    // A detached camera makes vanilla treat the local player as another entity.
    // At the low wake eye height that renders the torso around the lens. Cull only
    // this client's body/hands during locked shots; never modify player invisibility.
    @SubscribeEvent public static void frame(RenderFrameEvent.Pre e){
        if(!locked())return;
        Minecraft mc=Minecraft.getInstance();mc.options.setCameraType(CameraType.FIRST_PERSON);
        if(rig!=null&&mc.player!=null&&rig.level()==mc.level&&mc.getCameraEntity()!=rig)mc.setCameraEntity(rig);
    }
    @SubscribeEvent public static void body(RenderPlayerEvent.Pre e){
        if(locked() && e.getEntity()==Minecraft.getInstance().player)e.setCanceled(true);
    }
    @SubscribeEvent public static void hands(RenderHandEvent e){if(locked())e.setCanceled(true);}
    @SubscribeEvent public static void input(MovementInputUpdateEvent e){if(!locked())return;var i=e.getInput();i.forwardImpulse=0;i.leftImpulse=0;i.jumping=false;i.shiftKeyDown=false;i.up=i.down=i.left=i.right=false;}
    @SubscribeEvent public static void interaction(InputEvent.InteractionKeyMappingTriggered e){if(locked()){e.setCanceled(true);e.setSwingHand(false);}}
    @SubscribeEvent public static void overlay(RenderGuiEvent.Post e){
        if(!locked())return;var g=e.getGuiGraphics();int w=g.guiWidth(),h=g.guiHeight();
        float f=stage==IntroSequence.LANDING?1:stage==IntroSequence.BLACKOUT?Math.clamp(age/10f,0,1):1-Math.clamp((age-20)/55f,0,1);
        int alpha=Math.round(255*f);g.fill(0,0,w,h,alpha<<24);
        if(stage==IntroSequence.WAKE&&age>28&&age<90){int a=(int)(80*(1-Math.clamp((age-28)/62f,0,1)));g.fillGradient(0,0,w,h/4,(a<<24)|0x080b13,0);g.fillGradient(0,h*3/4,w,h,0,(a<<24)|0x080b13);}
    }
    private IntroClient(){}
}
