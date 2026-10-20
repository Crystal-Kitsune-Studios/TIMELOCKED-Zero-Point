# TIMELOCKED: Zero Point — 0.8.9.15 FULL SOURCE

This is the complete, buildable source project for the 0.8.9.15 Celestial Sky & Safe Beds development release. It compiles the mod's Java source and includes its assets and data. **No prior TIMELOCKED JAR is needed to build it.** The source ZIP is not an installable mod.

## Archive layout
The ZIP contains the project files directly at its root. Extract into your existing repository root, not into a nested FULL-SOURCE folder. Keep the downloaded ZIP outside the repository.

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
Install only `build/libs/timelocked-0.8.9.15-celestial-sky-dev.jar`. Replace older TIMELOCKED mod JARs rather than installing both. Usual NeoForge development runs are configured in `build.gradle`.

## Source provenance
The provided project snapshot was older than the last release. With permission, 16 missing/outdated Java files were reconstructed from the user-provided 0.8.9.8 release and repaired for compilation. These files are marked in their headers and listed in `validation/reconstructed-source-files.json`. This is a buildable reconstruction, not the exact original author text or comments. The retained source files are included, with dimension generation and Celestial resident behavior updated for this release. The full project contains 252 Java source files.

All 230 unrelated structure templates and every unrelated prior resource are preserved byte-for-byte from the 0.8.9.8 JAR. Two hub templates are intentionally edited only to center the hanging logo and its suspension frame. This prevents the source snapshot's older facility geometry from reverting the lab and hallway changes. The intentionally refreshed shared foliage models/textures are the only older visual assets replaced, alongside translations, an axe tag, release metadata the dimension definition and the new PA sound definition.

## What changed
- Beds in Voidspace no longer explode. Right-click either half of any complete, unoccupied bed to save a personal respawn checkpoint in this dimension. All 16 bed colors and all four facings are supported. Spawn points use vanilla intact-bed and safe-exit checks, not forced coordinates; a removed bed falls back to the normal missing-bed behavior. Occupied beds and denied block interactions do not overwrite the checkpoint. Sneaking with an item retains block-placement behavior. Other dimensions are untouched.
- The dimension stays fixed at midnight. Bed use here is a checkpoint/rest interaction, not a sleeping animation or a night-skip; it does not fast-forward other players or worlds. The action bar explains this. Existing respawn anchors remain enabled.
- A dedicated client-side Voidspace sky replaces the End backdrop: indigo/violet atmosphere and horizon, stable stars with a galactic band, gently moving teal/lilac aurora curtains, and two moons using shipped celestial textures. No overworld sun, vanilla clouds or rain overlays are drawn. Underwater/lava/obscured views do not receive a sky overlay. Biome fog colors, terrain lighting, fixed time and existing generation are preserved.
- The suspended SARC logo, crossbeam, four suspension bars and three uplights now sit above the main walkway intersection, not the midpoint of the room bounds. The circular floor medallion moves to the same intersection; its former location is restored to the normal walkway. Relative to 0.8.9.13, the logo assembly moves +12 Z and the medallion +16 Z. The medallion center is local X=79.5, Z=273.5, within half a block of the crossing center X=79.5, Z=273.0. The native 588-part silhouette is preserved and its arrival index follows the new location. Existing placed facilities are not relocated; unfinished older arrivals can still light their logos in place.
- The user-provided NAU anthem has a mono PA-speaker mix: band limiting, compression, light saturation and short room echoes. During the first 3.2 seconds, muffling, low gain, flutter and light circuit hiss settle into the normal PA sound. Tempo and the complete anthem are retained.
- The anthem starts on the actual logo off-to-on transition and streams from disk in the Blocks audio category at volume 0.85. A persisted per-facility flag prevents multipart duplicates and replays on reload. Already completed legacy arrivals are not replayed. Listeners must be inside the hub when the logo powers on; it is not a global music track or a looping sound.
- The revised pre-recorded welcome is seven separate chat messages from Dr. Everleigh Alexi Darkfang. The first appears with the logo/anthem; following messages arrive after 7, 9, 8, 10, 9 and 7 seconds (0, 7, 16, 24, 34, 43 and 50 seconds total at 20 TPS). Timing and the next line persist across saves. The queue pauses while no non-spectator players are in the hub and never dumps catch-up lines. Existing completed welcomes do not replay. There is no synthesized or cloned voice. Edit locale keys message.timelocked.arrival_welcome.1 through .7 for the script.
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
**Install the 0.8.9.15 JAR on both client and server, then fully restart. Back up your save first.** Bed interactions and the new sky do not require clearing chunks or moving buildings. Existing custom datapacks that override the Voidspace dimension type must also enable `bed_works` and use `effects: "timelocked:voidspace"`. Click the chosen bed after upgrading to set your checkpoint; previously exploded beds are not recreated.
**0.8.9.14 placement applies to newly generated facilities. Your already placed 0.8.9.13 room will not move automatically.**
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
For 0.8.9.15, the release build and 4,805 native-server checks passed. Bed checks cover the loaded dimension flags, all 16 colors, both bed halves, four facings, intact bed blocks, per-player spawn dimension/head position, non-forced spawn, actual native respawn transition and safe exit, saved player NBT, occupied/protected beds, fixed-time preservation, removed-bed fallback and unchanged overworld interactions. The prior intersection geometry and seven-message welcome regression checks were also rerun. See `validation/native-bed-sky-audit.json` and test-only `validation/BedSkyAudit.java`. The client sky sources compile; assets and 40,960 sampled aurora vertices passed static checks. **No graphical Minecraft client was available, so sky appearance, shader-pack compatibility and player-driven death/relogin remain in-game checks.**

For prior releases, source builds and native dedicated-server audits passed; those historical reports remain in `validation/`. For 0.8.9.14, the release build passed and 3,582 native-server checks passed, including template placement, all 588 dark logo parts, the moved arrival index, 140 crossbeam blocks, four hangers, 173 medallion interior tiles at the intersection, old-floor restoration, walkway headroom and the timed-welcome regression suite. See `validation/intersection-audit.json` and `validation/native-intersection-audit.json`. These are native-server checks, not an in-game visual sign-off. PA tests cover centered-template placement, 588 dark logo segments, matching arrival indexes, route headroom, sound registration, one-shot chat/anthem dispatch and saved-state/legacy compatibility. Job tests cover exclusive claims, role/owner save-load persistence, work navigation, replacement jobs, daytime gating, restock cooldowns, all seven direct station interactions and actual service-entrance pathfinding. Tests also cover all ten biome identities, home floors/interiors/domes and sampled sanctuary levels, tree emission across chunks, old biome-codec compatibility, return-field placement, restored hallway models, both lab fluids and buckets, and arrival-state/UUID persistence. The audit Java file is test-only and is not included in the mod JAR.

Preview PNGs, when supplied, use exported native block positions and shipped models/textures. They are not Minecraft screenshots. Client shader appearance, a player-controlled portal round-trip, subjective in-game speaker listening and a long survival playthrough were not certified. Audio codec, mono channel layout and full duration are checked; the processing script can reproduce the mix from the original user-provided MP3.
