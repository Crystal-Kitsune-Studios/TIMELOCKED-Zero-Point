package com.timelocked;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
/** Short offshore glimpse of Pantheris. No terrain edits or permanent entities. */
public final class IntroDeparture {
    record Cameo(Boat boat,Pantheris actor){}
    // Keep direct handles until cleanup: a newly loaded chunk may not yet expose
    // entities through ServerLevel.getEntity while its tracking status advances.
    static final java.util.Map<java.util.UUID,Cameo> live=new java.util.HashMap<>();
    static void spawn(ServerPlayer p,CompoundTag t){
        cleanup(p,t);t.putString("DepartureStatus","checking_water");var l=p.server.overworld();BlockPos q=BlockPos.of(t.getLong("Anchor"));BlockPos water=q.offset(38,-2,8);
        IntroLanding.preload(l,water);
        // Never replace a player-built pier, drain water or spawn the boat on land.
        for(int x=-2;x<=10;x++)for(int z=-2;z<=2;z++){
            BlockPos a=water.offset(x,0,z);if(!l.getFluidState(a).is(Fluids.WATER)||!l.getBlockState(a.above()).getCollisionShape(l,a.above()).isEmpty()||!l.getBlockState(a.above(2)).getCollisionShape(l,a.above(2)).isEmpty()||!l.getBlockState(a.above(3)).getCollisionShape(l,a.above(3)).isEmpty()){t.putString("DepartureStatus","blocked_"+a+"_"+l.getBlockState(a)+"_above_"+l.getBlockState(a.above()));return;}
        }
        Boat b=Content.INTRO_BOAT.get().create(l);if(b==null)return;b.setPos(water.getX()+.5,63.9,water.getZ()+.5);b.setVariant(Boat.Type.DARK_OAK);b.setYRot(-90);b.setNoGravity(true);b.setInvulnerable(true);b.setSilent(true);b.addTag("timelocked_intro_boat");
        Pantheris a=Content.PANTHERIS.get().create(l);if(a==null){t.putString("DepartureStatus","null_actor");return;}
        a.moveTo(b.getX(),b.getY()+.4,b.getZ(),-90,0);a.setNoGravity(true);a.addTag("timelocked_intro_pantheris");
        if(!l.addFreshEntity(b)){t.putString("DepartureStatus","boat_rejected");return;}if(!l.addFreshEntity(a)){t.putString("DepartureStatus","actor_rejected");b.discard();return;}
        if(!a.startRiding(b,true)){t.putString("DepartureStatus","mount_rejected");a.discard();b.discard();return;}
        live.put(p.getUUID(),new Cameo(b,a));t.putString("DepartureStatus","spawned");t.putUUID("DepartureBoat",b.getUUID());t.putUUID("DepartureActor",a.getUUID());
    }
    static void tick(ServerPlayer p,CompoundTag t,int age){
        if(!t.hasUUID("DepartureBoat"))return;var l=p.server.overworld();Cameo cameo=live.get(p.getUUID());Entity b=cameo==null?null:cameo.boat();Entity a=cameo==null?null:cameo.actor();
        if(b==null||a==null||b.isRemoved()||a.isRemoved()){cleanup(p,t);return;}
        BlockPos q=BlockPos.of(t.getLong("Anchor"));double x=q.getX()+38.5+Math.max(0,age-35)*.06,z=q.getZ()+8.5;
        if(!l.getFluidState(BlockPos.containing(x,63,z)).is(Fluids.WATER)){cleanup(p,t);return;}
        if(b instanceof Boat rowing)rowing.setPaddleState(age>=35,age>=35);b.setDeltaMovement(Vec3.ZERO);b.setPos(x,63.9,z);b.setYRot(-90);b.hasImpulse=true;
        // A restrained look back toward the beach, then turns away and leaves.
        a.setYRot(-90);if(a instanceof Pantheris actor){actor.setYBodyRot(-90);actor.setYHeadRot(age<75?-150:-90);}
    }
    static void cleanup(ServerPlayer p,CompoundTag t){Cameo c=live.remove(p.getUUID());if(c!=null){c.actor().discard();c.boat().discard();}for(String key:new String[]{"DepartureActor","DepartureBoat"}){if(t.hasUUID(key)){Entity a=p.server.overworld().getEntity(t.getUUID(key));if(a!=null)a.discard();t.remove(key);}}}
    private IntroDeparture(){}
}
