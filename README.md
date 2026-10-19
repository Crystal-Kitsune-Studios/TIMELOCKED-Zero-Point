# TIMELOCKED: Zero Point — 0.8.9.12 FULL SOURCE

This is the complete, buildable source project for the 0.8.9.12 PA Welcome development release. It compiles the mod's Java source and includes its assets and data. **No prior TIMELOCKED JAR is needed to build it.** The source ZIP is not an installable mod.

## Build
Requires a **JDK 21**, plus internet access for the Gradle and NeoForge dependencies on the first build. Minecraft 1.21.1 / NeoForge 21.1.252.

Linux/macOS:
```sh
bash gradlew clean build --console=plain
```
Windows:
```bat
gradlew.bat clean build --console=plain
```
Install only `build/libs/timelocked-0.8.9.12-pa-welcome-dev.jar`. Replace older TIMELOCKED mod JARs rather than installing both. Usual NeoForge development runs are configured in `build.gradle`.

## Source provenance
The provided project snapshot was older than the last release. With permission, 16 missing/outdated Java files were reconstructed from the user-provided 0.8.9.8 release and repaired for compilation. These files are marked in their headers and listed in `validation/reconstructed-source-files.json`. This is a buildable reconstruction, not the exact original author text or comments. The retained source files are included, with dimension generation and Celestial resident behavior updated for this release. The full project contains 250 Java source files.

All 230 unrelated structure templates and every unrelated prior resource are preserved byte-for-byte from the 0.8.9.8 JAR. Two hub templates are intentionally edited only to center the hanging logo and its suspension frame. This prevents the source snapshot's older facility geometry from reverting the lab and hallway changes. The intentionally refreshed shared foliage models/textures are the only older visual assets replaced, alongside translations, an axe tag, release metadata the dimension definition and the new PA sound definition.

## What changed
- The suspended SARC emblem and its support frame are moved five blocks along Z to the room center (within half a block, the nearest native grid placement). The 588-part silhouette, room walls and circulation routes are retained. The arrival index follows the new placement; unfinished older off-center logos remain supported but existing saves are not automatically relocated.
- The user-provided NAU anthem has a mono PA-speaker mix: band limiting, compression, light saturation and short room echoes. During the first 3.2 seconds, muffling, low gain, flutter and light circuit hiss settle into the normal PA sound. Tempo and the complete anthem are retained.
- The anthem starts on the actual logo off-to-on transition and streams from disk in the Blocks audio category at volume 0.85. A persisted per-facility flag prevents multipart duplicates and replays on reload. Already completed legacy arrivals are not replayed. Listeners must be inside the hub when the logo powers on; it is not a global music track or a looping sound.
- At the same moment, a natural-language pre-recorded welcome appears as in-game chat, signed Dr. Everleigh Alexi Darkfang and welcoming players to “the Sapphire Advanced Research Corporation.” There is no synthesized or cloned spoken voice. See the locale entry message.timelocked.arrival_welcome to edit the text.
- Seven independent Celestial occupations: herbalist, crystal shaper, gardener, cook, attuner, warden and medic. These are not vanilla villager professions, and preserve Celestial kind/house identities and the Moon’s existing roles.
- Workstations have exclusive UUID claims stored in block entities. Residents save their role and station, navigate to a neighboring work position during day ticks 1,000–11,000, and restock used trades at work up to twice per day with a 2,400-tick interval. Unloaded stations are not treated as destroyed. An absent owner’s claim can expire after 2,400 game ticks; an active owner retains it. Breaking a station allows a resident to find another job. No passive item production is simulated.
- Four inner houses become an apothecary, crystal workshop, nursery and kitchen. The central sanctuary has an altar; the east gate has a warden’s desk. Eight outer homes receive usable beds. The medic tent contains independent medical workstations (no facility reactor required).
- Seven distinct modeled, craftable job blocks have survival loot drops and direct right-click functions. See the operation guide below.
- Entrance correction: arrival path turns onto a reserved apron and passes through the east gatehouse into the central plaza. A three-block-wide elbow path connects the medic tent’s actual front door to the north promenade without intersecting homes.
- Main Celestial Sanctuary at X=-240, Z=180: 300-block refuge radius; expanded garden district with twelve homes, fourteen persistent residents, reflecting pools and footbridges, radial paths and a crystal-lit outer promenade.
- Silverleaf groves, taller moonveil trees with hanging starleaf, lantern-acacia variants and branching dead snags; new bark and canopy materials.
- Modeled moon ferns, lantern blooms, prism reeds and dusk lotuses. Star blooms, spore sprouts, ashen tufts and celestial fronds have refreshed 3D models/textures.
- Four additional biomes: Moonveil Forest, Prismatic Meadows, Twilight Wetlands and Obsidian Dunes. Ten registered biomes in total, with distinct surfaces, terrain influences, vegetation and fog colors. Wetlands have shallow water and mud islands; dunes have dark ridges and obsidian patches.
- Neighboring world-cell anchors reconstruct tree crowns across chunk borders instead of clipping them.
- Return gate and approach retained; older lab fluids, hallway furnishings, alarms and entrance-lighting behavior retained.

## World compatibility
**Back up your world first. Use a new test world to see the complete redesign.** Existing chunks are not rewritten. Older saved dimension settings retain the original biome palette, with safe fallbacks for the four new optional biome fields. Do not delete existing dimension directories without a separate backup and an explicit reset plan.

## Workstation operation guide
Right-click a station with the required item in your main hand. Use an empty hand while sneaking for a hint. Residents offer occupation-specific trades; sneak-interact with an empty hand to hear their role and lore. Work hours use the overworld day cycle even though the dimension sky is fixed.

| Station | Direct action |
| --- | --- |
| Herbalist’s bench | 2 star blooms → 2 bandages |
| Crystal-shaping bench | 9 void crystal clusters → 1 void crystal block; a block → 9 clusters |
| Cultivation table | 1 bone meal + a supported plant held in the offhand → 1 extra plant; original plant retained |
| Celestial hearth | 4 glow berries → 2 baked potatoes |
| Attunement altar | 3 clusters → 120 seconds of night vision and 60 seconds of Resistance I; 60-second cooldown |
| Warden’s desk | Directions to the sanctuary, east gate and return gate |
| Celestial medical station | 1 bandage → up to 3 hearts; 10-second cooldown shared with facility treatment |

Supported nursery plants: moon fern, lantern bloom, prism reed, dusk lotus, star bloom and celestial frond. All seven stations are available in the creative tab and through crafting. Output is placed in the player’s inventory or dropped if it is full. Resident jobs do not add custom GUI screens, autonomous factories, quests or a sleeping schedule. Existing residents can claim player-placed job blocks in loaded chunks, but previously generated buildings are not automatically refurnished.

## Verification and limitations
A standalone full-source build and native dedicated-server tests were run. See the JSON reports in `validation/`. PA tests cover centered-template placement, 588 dark logo segments, matching arrival indexes, route headroom, sound registration, one-shot chat/anthem dispatch and saved-state/legacy compatibility. Job tests cover exclusive claims, role/owner save-load persistence, work navigation, replacement jobs, daytime gating, restock cooldowns, all seven direct station interactions and actual service-entrance pathfinding. Tests also cover all ten biome identities, home floors/interiors/domes and sampled sanctuary levels, tree emission across chunks, old biome-codec compatibility, return-field placement, restored hallway models, both lab fluids and buckets, and arrival-state/UUID persistence. The audit Java file is test-only and is not included in the mod JAR.

Preview PNGs, when supplied, use exported native block positions and shipped models/textures. They are not Minecraft screenshots. Client shader appearance, a player-controlled portal round-trip, subjective in-game speaker listening and a long survival playthrough were not certified. Audio codec, mono channel layout and full duration are checked; the processing script can reproduce the mix from the original user-provided MP3.
