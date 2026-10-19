/* Reconstructed from the user-provided 0.8.9.8 release with permission. */
package com.timelocked;

import com.timelocked.AlarmSounds;
import com.timelocked.AtlasContent;
import com.timelocked.BattleMusicNetworking;
import com.timelocked.Content;
import com.timelocked.EncounterManager;
import com.timelocked.FacilityArchitecture;
import com.timelocked.FacilityDetails;
import com.timelocked.FieldShelter;
import com.timelocked.Greed;
import com.timelocked.JumpSequence;
import com.timelocked.LabContent;
import com.timelocked.LabFluids;
import com.timelocked.Makglo;
import com.timelocked.MetalContent;
import com.timelocked.MonitorContent;
import com.timelocked.PortalTransitNetworking;
import com.timelocked.SarcContent;
import com.timelocked.SarcSitePlacement;
import com.timelocked.SatelliteCrash;
import com.timelocked.ShipInteriorContent;
import com.timelocked.SpaceContent;
import com.timelocked.UndergroundContent;
import com.timelocked.UndergroundSystems;
import com.timelocked.Unnamed;
import com.timelocked.VehicleEvents;
import com.timelocked.VehicleNetworking;
import com.timelocked.VoidspaceContent;
import com.timelocked.WeaponEvents;
import com.timelocked.WeaponNetworking;
import com.timelocked.WorkshopContent;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value="timelocked")
public final class Timelocked {
    public static final String ID = "timelocked";

    public Timelocked(IEventBus bus) {
        Content.initialize();
        FacilityArchitecture.initialize();
        AlarmSounds.SOUNDS.register(bus);
        UndergroundContent.initialize((IEventBus)bus);
        FacilityDetails.initialize();
        LabContent.initialize();
        LabFluids.initialize(bus);
        MetalContent.initialize();
        FacilityDetails.initialize();
        AtlasContent.initialize();
        FacilityDetails.initialize();
        WorkshopContent.initialize((IEventBus)bus);
        VoidspaceContent.initialize((IEventBus)bus);
        SarcContent.initialize((IEventBus)bus);
        SpaceContent.initialize((IEventBus)bus);
        ShipInteriorContent.initialize();
        MonitorContent.initialize();
        FieldShelter.initialize();
        MetalContent.ARMOR_MATERIALS.register(bus);
        bus.addListener(MetalContent::capabilities);
        Content.CHUNK_GENERATORS.register(bus);
        Content.BIOME_SOURCES.register(bus);
        Content.BLOCKS.register(bus);
        Content.ITEMS.register(bus);
        Content.BLOCK_ENTITIES.register(bus);
        Content.TABS.register(bus);
        Content.ENTITIES.register(bus);
        Content.FEATURES.register(bus);
        EncounterManager.register();
        JumpSequence.register();
        bus.addListener(PortalTransitNetworking::register);
        bus.addListener(BattleMusicNetworking::register);
        bus.addListener((net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent e) -> {
            e.put((EntityType)Content.MAKGLO.get(), Makglo.attributes().build());
            e.put((EntityType)Content.UNNAMED.get(), Unnamed.attributes().build());
            e.put((EntityType)Content.GREED.get(), Greed.attributes().build());
        });
        bus.addListener(Content::capabilities);
        SarcSitePlacement.register();
        SatelliteCrash.register();
        UndergroundSystems.register();
        VehicleEvents.register();
        bus.addListener(VehicleNetworking::register);
        WeaponEvents.register();
        bus.addListener(WeaponNetworking::register);
    }
}

