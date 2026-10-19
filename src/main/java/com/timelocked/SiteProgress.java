/* Reconstructed from the user-provided 0.8.9.8 release with permission. */
package com.timelocked;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

public final class SiteProgress {
    public int arrivalStep;
    public int arrivalTicks;
    public boolean arrivalStarted;
    public boolean arrivalLogoAnnounced;
    public int geometryVersion;
    public boolean powered;
    public boolean cleared;
    public boolean fighting;
    public boolean manualAlarm;
    public int wave;
    public int layoutVersion;
    public long nextWaveTick;
    public final Set<UUID> living = new HashSet<UUID>();

    public CompoundTag save() {
        CompoundTag t = new CompoundTag();
        t.putInt("ArrivalStep", this.arrivalStep);
        t.putInt("ArrivalTicks", this.arrivalTicks);
        t.putBoolean("ArrivalStarted", this.arrivalStarted);
        t.putBoolean("ArrivalLogoAnnounced", this.arrivalLogoAnnounced);
        t.putInt("LayoutVersion", this.layoutVersion);
        t.putInt("GeometryVersion", this.geometryVersion);
        t.putBoolean("Powered", this.powered);
        t.putBoolean("Cleared", this.cleared);
        t.putBoolean("Fighting", this.fighting);
        t.putBoolean("ManualAlarm", this.manualAlarm);
        t.putInt("Wave", this.wave);
        t.putLong("NextWave", this.nextWaveTick);
        ListTag ids = new ListTag();
        this.living.forEach(id -> {
            CompoundTag v = new CompoundTag();
            v.putUUID("ID", id);
            ids.add(v);
        });
        t.put("Living", (Tag)ids);
        return t;
    }

    public static SiteProgress load(CompoundTag t) {
        SiteProgress s = new SiteProgress();
        s.arrivalStep = Math.clamp((long)t.getInt("ArrivalStep"), 0, 5);
        s.arrivalTicks = Math.max(0, t.getInt("ArrivalTicks"));
        s.arrivalStarted = t.getBoolean("ArrivalStarted");
        s.arrivalLogoAnnounced = t.contains("ArrivalLogoAnnounced") ? t.getBoolean("ArrivalLogoAnnounced") : s.arrivalStep >= 5;
        s.layoutVersion = t.getInt("LayoutVersion");
        s.geometryVersion = t.getInt("GeometryVersion");
        s.powered = t.getBoolean("Powered");
        s.cleared = t.getBoolean("Cleared");
        s.fighting = t.getBoolean("Fighting");
        s.manualAlarm = t.getBoolean("ManualAlarm");
        s.wave = Math.clamp((long)t.getInt("Wave"), 0, 3);
        s.nextWaveTick = t.getLong("NextWave");
        for (Tag tag : t.getList("Living", 10)) {
            CompoundTag c = (CompoundTag)tag;
            if (!c.hasUUID("ID")) continue;
            s.living.add(c.getUUID("ID"));
        }
        return s;
    }
}

