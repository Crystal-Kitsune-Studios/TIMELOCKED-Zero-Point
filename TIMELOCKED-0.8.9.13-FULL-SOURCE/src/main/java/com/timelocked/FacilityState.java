package com.timelocked;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedData.Factory;

public final class FacilityState extends SavedData {
   public static final Factory<FacilityState> FACTORY = new Factory<>(FacilityState::new, FacilityState::load);
   public final Map<Long, Integer> sites = new HashMap<>();
   public final Map<Long, SiteProgress> progress = new HashMap<>();
   public boolean pending;
   public boolean platformBuilt;
   public BlockPos origin = BlockPos.ZERO;
   public UUID operator;
   public int placementGeometry;
   public int nextPiece;
   public int site;

   public static FacilityState get(MinecraftServer server) {
      return (FacilityState)server.overworld().getDataStorage().computeIfAbsent(FACTORY, "timelocked_facilities");
   }

   public int allocate(BlockPos pos) {
      Integer known = this.sites.get(pos.asLong());
      if (known != null) {
         return known;
      }

      Set<Integer> used = new HashSet<>(this.sites.values());
      if (used.size() >= 1000) {
         throw new IllegalStateException("All 1000 site designations are allocated.");
      }

      int id = new Random().nextInt(1000);

      while (used.contains(id)) {
         id = (id + 1) % 1000;
      }

      this.sites.put(pos.asLong(), id);
      this.setDirty();
      return id;
   }

   public CompoundTag save(CompoundTag t, Provider p) {
      ListTag list = new ListTag();
      this.sites.forEach((pos, id) -> {
         CompoundTag n = new CompoundTag();
         n.putLong("Origin", pos);
         n.putInt("Site", id);
         list.add(n);
      });
      t.put("Sites", list);
      ListTag progression = new ListTag();
      this.progress.forEach((origin, value) -> {
         CompoundTag v = value.save();
         v.putLong("Origin", origin);
         progression.add(v);
      });
      t.put("Progression", progression);
      t.putBoolean("Pending", this.pending);
      t.putBoolean("PlatformBuilt", this.platformBuilt);
      t.putLong("JobOrigin", this.origin.asLong());
      t.putInt("NextPiece", this.nextPiece);
      t.putInt("PlacementGeometry", this.placementGeometry);
      t.putInt("JobSite", this.site);
      if (this.operator != null) {
         t.putUUID("Operator", this.operator);
      }

      return t;
   }

   public static FacilityState load(CompoundTag t, Provider p) {
      FacilityState data = new FacilityState();

      for (Tag entry : t.getList("Sites", 10)) {
         CompoundTag n = (CompoundTag)entry;
         data.sites.put(n.getLong("Origin"), Math.clamp(n.getInt("Site"), 0, 999));
      }

      for (Tag entry : t.getList("Progression", 10)) {
         CompoundTag v = (CompoundTag)entry;
         data.progress.put(v.getLong("Origin"), SiteProgress.load(v));
      }

      data.pending = t.getBoolean("Pending");
      data.platformBuilt = t.getBoolean("PlatformBuilt");
      data.origin = BlockPos.of(t.getLong("JobOrigin"));
      data.nextPiece = Math.max(0, t.getInt("NextPiece"));
      data.placementGeometry = t.getInt("PlacementGeometry");
      data.site = Math.clamp(t.getInt("JobSite"), 0, 999);
      data.operator = t.hasUUID("Operator") ? t.getUUID("Operator") : null;
      return data;
   }
}
