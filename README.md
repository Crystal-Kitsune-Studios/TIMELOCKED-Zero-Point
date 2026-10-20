# TIMELOCKED: Zero Point — 0.8.9.18 FULL SOURCE

This is the complete, buildable source project for the 0.8.9.18 Story / Coastal Access development release. It compiles the mod's Java source and includes its assets and data. **No prior TIMELOCKED JAR is needed to build it.** The source ZIP is not an installable mod.

## Start here (club contributors)

Clone the repository and work on a branch. **Do not extract a full-source ZIP over an
existing checkout.** It can overwrite other members' work. The ZIP is a standalone
snapshot, not an update installer. Apply reviewed Git commits/patches instead.

| Location                                         | Purpose                                                             | Needed for a normal build?           |
| ------------------------------------------------ | ------------------------------------------------------------------- | ------------------------------------ |
| `src/main/java/com/cs_club/minecraft_alien_mod/` | Original club examples: start here to learn item/block registration | Yes; preserved and compiled          |
| `src/main/resources/assets/minecraftalienmod/`   | Original example textures, models and translations                  | Yes                                  |
| `src/main/java/com/timelocked/`                  | TIMELOCKED gameplay; `client/` contains rendering/UI only           | Yes                                  |
| `src/main/resources/`                            | Shipped models, textures, sounds and world data                     | Yes; already included                |
| `tools/`                                         | Optional asset-authoring, preview, lint and test helpers            | No Python needed just to build/play  |
| `validation/`                                    | Test-only Java harnesses and historical reports/previews            | No; never shipped as production Java |
| `docs/CONTRIBUTING.md`                           | Small-change workflow, helper commands, checks and known debt       | Read before changing code            |
| `build/`, `.audit/`                              | Generated builds/reports/previews and disposable audit servers      | No; ignored by Git                   |

The club's original Java examples and item assets have been restored from upstream
commit `c7685595ffe33562fb47b54ae861733d98550b4c`. They keep their own
`minecraftalienmod` namespace and run alongside `timelocked`; no example class was
renamed into TIMELOCKED. Their translation JSON had one invalid trailing comma,
which is the only syntax repair to the restored example resources. The original
commented metadata template is retained for reference; the combined runtime
metadata is `src/main/resources/META-INF/neoforge.mods.toml`.

## Build

Requires a **JDK 21**, plus internet access for the Gradle and NeoForge dependencies on the first build. Minecraft 1.21.1 / NeoForge 21.1.252.

Linux/macOS:

```sh
./gradlew clean build --console=plain
```

Windows:

```bat
gradlew.bat clean build --console=plain
```

Install only `build/libs/timelocked-0.8.9.18-story-dev.jar`. Replace older TIMELOCKED mod JARs rather than installing both. Usual NeoForge development runs are configured in `build.gradle`.

For Windows PowerShell use `.\gradlew.bat clean build --console=plain`.
No Bash, Python, FFmpeg or asset regeneration is required for this build.

## Source provenance

The provided project snapshot was older than the last release. With permission, 16 missing/outdated Java files were reconstructed from the user-provided 0.8.9.8 release and repaired for compilation. These files are marked in their headers and listed in `validation/reconstructed-source-files.json`. This is a buildable reconstruction, not the exact original author text or comments. The retained source files are included, with dimension generation and Celestial resident behavior updated for this release. The TIMELOCKED namespace contains 267 Java source files; the restored club examples are additional.

All 230 unrelated structure templates and every unrelated prior resource are preserved byte-for-byte from the 0.8.9.8 JAR. Two hub templates are intentionally edited only to center the hanging logo and its suspension frame. This prevents the source snapshot's older facility geometry from reverting the lab and hallway changes. The intentionally refreshed shared foliage models/textures are the only older visual assets replaced, alongside translations, an axe tag, release metadata the dimension definition and the new PA sound definition.

## 0.8.9.18 — Story, coastal access and wake camera

- **Story** is a new main-menu entry. It opens world creation with a saved, server-owned `timelockedStory` game rule, Survival progression and the normal Overworld preset. Story is the campaign world category, not a replacement for Minecraft's GameType enum. Other world options such as the world name, seed and difficulty remain configurable.
- Ordinary Survival and Creative world creation keep their original menu actions and do **not** automatically abduct new players. The rule defaults to false, persists with the world and is not toggled by a client join packet. Completed intros do not replay. Existing active intros can finish after upgrading; `/timelockedintro start` remains an explicit operator replay outside Story worlds.
- The home TV is now **one seamless six-by-three monitor**, with a continuous late-night test-card broadcast, metal housing, one power button and a fully dark standby state. Clicking the actual screen/button advances the scene; nearby empty space does not.
- Beach wayfinding uses new native **two-block-tall modeled metal signs**, with paired posts, base feet, framed enamel panels and readable authored textures. Both halves are physical/selectable. Placing the item creates both halves; breaking either removes the other. The boardwalk-direction sign points inland toward SARC, and neither sign blocks the walking route.
- A marked parking area has paired parking bays, two blue reserved bays, a clear central aisle, corner lights and a separate smooth-stone pedestrian route onto the boardwalk. A graded seven-block-wide vehicle spur connects the lot to the existing approach road. These are generated-world blocks, not a menu illustration.
- **Beach body-clipping fix:** the detached wake camera previously caused vanilla to render the local player's body around the low camera position. During blackout/loading/wake only, the client now cancels its own player-model and hand rendering and enforces first person before each rendered frame. Other players are not hidden and no server/player invisibility flag is changed. Previous camera mode is restored when the shot ends or the client resets. The safe chunk-ready landing barrier and Pantheris departure are retained.
- **Use a fresh Story world to see the new coast and parking lot.** World generation never bulldozes already-generated chunks or player builds. Replaying an older save may reuse its older coastline. Existing started Story progress is not reset by the update. Back up saves and replace the old JAR on both client and server.
- Editable sign assets: `tools/generate_coast_signs.py` (Python + Pillow), native block models and textures. `validation/*sign-*.png` are source-model previews, not in-game screenshots.

## Retained from 0.8.9.17 — safe landing and Pantheris glimpse

- Landing now has a dedicated black-screen barrier. The server loads the surrounding 3×3 chunks, validates dry support/headroom, saves an exact anchor and holds gravity/position. The client must have real full chunks and supported floor for eight consecutive ticks before acknowledging its current landing nonce. The wake timer starts only after that acknowledgment; skipped intros use the same barrier.
- The wake camera follows the saved beach anchor, not the player's predicted falling position. Normal gravity and the previous mode return only on supported release. A 30-second loading timeout returns the player to the saved pre-intro location rather than dropping them into an unready beach. Active older wake saves are migrated on login; stale ready packets cannot release a new landing.
- During the brief wake reveal, Pantheris Dawnbringer sits in a real dark-oak boat roughly 39 blocks offshore, glances back, then moves farther out. The seated voxel model adapts the supplied character reference: panther ears/muzzle, red eyes, forehead mark, deep red clothes, grey vest, gold chest emblem, dark purple-edged feathered wings and tail. It is a native Minecraft adaptation, not a reused armor-stand silhouette or an exact reproduction of the original artwork. No voice or new lore dialogue is added.
- The boat scene declines to spawn if its short water route/headroom is obstructed. It does not overwrite player builds. Both cinematic entities are non-persistent and are removed on completion, skip, disconnect or recovery. These are scene-only entities, not a recruitable NPC or a survival boat reward.
- If your completed 0.8.9.16 intro left you falling below the beach, `/timelockedintro rescue` places you behind the same safe-loading barrier. It only works below your own recorded beach, within 64 horizontal blocks, and preserves current mode/inventory. It is not a general teleport command.
- Existing coasts need no regeneration for this fix. Both client and server must use 0.8.9.17 because the cinematic network protocol changed. Back up your save before updating.
- Character mesh is editable in `tools/pantheris-model.json`; `tools/generate_pantheris_model.py` regenerates the Java mesh and palette texture with Python + Pillow. Reference source: TIMELOCKED — Character Refs (Images), Pantheris design section, supplied by the user. The original artwork is not redistributed in this archive.

## Playable opening — home to Earth beach

- A new Survival player's first join **in a Story world** starts a private playable home set: switch off the TV, walk to the bedroom, hear a break-in, glimpse a silhouette, black out, and wake up on a sandy Earth coast. The Overworld's normal sky is used on the beach; this is **not** Voidspace.
- The home is an isolated staging dimension representing the player's Earth home. Every player receives a separate 64-block slot. This does not replace their normal Overworld house, change global time/weather, or move other players.
- The TV is a seamless native monitor wall. Right-click the actual screen or power button, then approach the bed. The break-in uses a broken window, an opened entrance, a black-clad scene silhouette, and individually targeted sound cues. There is no spoken narration or licensed voice work.
- Only the blackout, loading barrier and wake section lock movement. The client fades to black, transitions to the coast, then raises the camera from sand level over six seconds. Gentle tinnitus/surf ambience is original procedural audio at restrained volume; there are no flashing white frames.
- An authored coast is generated **only in new Overworld chunks**, near the outer end of a planned SARC approach road. A three-block-wide graded service boardwalk leads from the beach to that road. Signs identify Sapphire Advanced Research Corporation and the access direction. The coast is an authored opening set, not a guarantee of a naturally selected ocean biome.
- Per-player stage, elapsed ticks, allocated room, original mode and return location are saved in `data/timelocked_intro.dat`. Offline players do not advance. Completed intros never automatically replay. Established players (over one second of recorded play time) and non-Survival first joins are not automatically relocated when upgrading.
- `/timelockedintro skip` is available without operator permission **during an active intro**. It skips to the Earth beach, waits for safe client loading, then restores the previous game mode. Inventory is never cleared. New players receive a beach respawn checkpoint; manual replays by established players retain their existing bed checkpoint.
- `/timelockedintro start` requires operator permission (cheats in single-player), affects only the command's player, and lets existing players test/replay the opening. `/timelockedintro disable` and `enable` toggle automatic first-join starts. They do not rewind completed players. Keep both client and server on this version.
- Use a new **standard Overworld** test world for the complete opening. Three regional SARC coastal positions are tried; if none contains the new coast marker (for example, old chunks or a worldgen pack that disables the campaign feature), the intro declines to start rather than overwriting terrain or clearing inventory. Already-generated coast areas are never carved at runtime.
- Private home sets are retained in the staging dimension for save compatibility. The silhouette is discarded at the transition or recovery. An unexpected dimension change aborts to the saved location and restores the player's mode.

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

**Install the 0.8.9.18 JAR on both client and server, then fully restart. Back up your save first.** Bed interactions and the new sky do not require clearing chunks or moving buildings. Existing custom datapacks that override the Voidspace dimension type must also enable `bed_works` and use `effects: "timelocked:voidspace"`. Click the chosen bed after upgrading to set your checkpoint; previously exploded beds are not recreated.
**0.8.9.14 placement applies to newly generated facilities. Your already placed 0.8.9.13 room will not move automatically.**
**Back up your world first. Use a new test world to see the complete redesign.** Existing chunks are not rewritten. Older saved dimension settings retain the original biome palette, with safe fallbacks for the four new optional biome fields. Do not delete existing dimension directories without a separate backup and an explicit reset plan.

## Workstation operation guide

Right-click a station with the required item in your main hand. Use an empty hand while sneaking for a hint. Residents offer occupation-specific trades; sneak-interact with an empty hand to hear their role and lore. Work hours use the overworld day cycle even though the dimension sky is fixed.

| Station                   | Direct action                                                                                |
| ------------------------- | -------------------------------------------------------------------------------------------- |
| Herbalist’s bench         | 2 star blooms → 2 bandages                                                                   |
| Crystal-shaping bench     | 9 void crystal clusters → 1 void crystal block; a block → 9 clusters                         |
| Cultivation table         | 1 bone meal + a supported plant held in the offhand → 1 extra plant; original plant retained |
| Celestial hearth          | 4 glow berries → 2 baked potatoes                                                            |
| Attunement altar          | 3 clusters → 120 seconds of night vision and 60 seconds of Resistance I; 60-second cooldown  |
| Warden’s desk             | Directions to the sanctuary, east gate and return gate                                       |
| Celestial medical station | 1 bandage → up to 3 hearts; 10-second cooldown shared with facility treatment                |

Supported nursery plants: moon fern, lantern bloom, prism reed, dusk lotus, star bloom and celestial frond. All seven stations are available in the creative tab and through crafting. Output is placed in the player’s inventory or dropped if it is full. Resident jobs do not add custom GUI screens, autonomous factories, quests or a sleeping schedule. Existing residents can claim player-placed job blocks in loaded chunks, but previously generated buildings are not automatically refurnished.

## Verification and limitations

The 0.8.9.18 release build passed and compiles both server and client sources. **7,943 native-server checks passed with zero failures.** The native dedicated-server audit covers Story gating and persistence, the continuous 6×3 TV and full-screen power-off, physical sign placement and removal, every parking deck column, driveway and pedestrian access, plus the retained beach landing/boat/bed/hub/welcome regressions. See `validation/native-story-audit.json` for the exact current result. Older audit files are retained historical reports and identify their own release versions.

**Graphical client QA is still required.** Native fake-player tests do not render a Minecraft client. The camera render guards and menu compile; they are not a substitute for an actual in-game wake-up test with your shaders, first-person-body mods or other camera mods. The authored sign geometry/textures have been rendered and visually inspected separately. No source-model preview is an in-game screenshot.

Manual client checklist:

1. Confirm the Story button is reachable at your GUI scale; cancel Story creation and make an ordinary Survival world — it must not start the intro. Repeat Creative.
2. Create a fresh Story world. Walk around the house; confirm one continuous TV faces the couch, click it off, then approach the bed.
3. Test the wake-up starting from both first- and third-person views. The beach reveal should show sand, ocean and Pantheris, never your own torso, armor or hands. On release the previous perspective and movement return. Repeat with your usual shader/body-mod setup.
4. Walk the entire boardwalk, pedestrian connection, lot aisle and driveway. Confirm signs face beach arrivals without obstructing the route. Check both halves can be targeted and removed in a test Creative world.
5. Quit/rejoin during blackout and wake; check safe loading, restored controls and no leftover boat actors. Test `/timelockedintro skip` if appropriate.

## Reproduce native regression checks

With JDK 21 selected, run `python tools/run_story_audit.py --accept-eula` after reviewing the Minecraft EULA. The runner starts an isolated, loopback-only temporary server with a fresh world and an ephemeral port, compiles only the single audit entry point into a temporary build, and writes `build/reports/story/native-story-audit.json`. It does not modify your real saves or insert audit classes in the release JAR. Failure details remain in `build/reports/story/story-audit-run.log`. Python 3 and the normal Gradle dependencies are required; asset preview generators additionally use Pillow and NumPy. Fonts are selected portably; set `TIMELOCKED_FONT` for reproducible artwork. See the contributor guide for Windows commands and exact tool inputs/outputs.
