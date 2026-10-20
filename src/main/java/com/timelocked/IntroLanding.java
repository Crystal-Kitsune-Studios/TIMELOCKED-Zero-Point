package com.timelocked;

import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/** Chunk-ready barrier: the server owns gravity, the saved anchor and release. */
public final class IntroLanding {
    static void preload(ServerLevel l,BlockPos p){for(int x=-1;x<=1;x++)for(int z=-1;z<=1;z++)l.getChunk((p.getX()>>4)+x,(p.getZ()>>4)+z);}
    public static boolean supported(Level l,BlockPos p){return l.getWorldBorder().isWithinBounds(p)
        &&l.getBlockState(p).getCollisionShape(l,p).isEmpty()&&l.getFluidState(p).isEmpty()
        &&l.getBlockState(p.above()).getCollisionShape(l,p.above()).isEmpty()&&l.getFluidState(p.above()).isEmpty()
        &&l.getBlockState(p.below()).isFaceSturdy(l,p.below(),Direction.UP);}
    static boolean hold(ServerPlayer p,CompoundTag t){
        BlockPos q=BlockPos.of(t.getLong("Anchor"));if(!supported(p.serverLevel(),q))return false;
        p.setNoGravity(true);p.setDeltaMovement(Vec3.ZERO);p.fallDistance=0;
        double x=q.getX()+.5,y=q.getY(),z=q.getZ()+.5;
        if(p.position().distanceToSqr(new Vec3(x,y,z))>.0001)p.teleportTo(p.serverLevel(),x,y,z,p.getYRot(),p.getXRot());
        p.setOnGround(true);return true;
    }
    private IntroLanding(){}
}
