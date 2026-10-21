# SCC glass and window correction — 0.8.9.31

## Corrected in 0.8.9.31

- SCC 101 / Game Design Lab now has its complete glass frontage on the south corridor toward SCC 123.
- SCC 103 glazing and entrance face the corridor instead of opening into SCC 101.
- SCC 123 has the missing hallway observation window.
- The home reading-bay headers are sealed at both inner corners.

## Implemented

- Preserves the supplied PDF-derived room footprints and existing SCC exterior, parking lot,
  street approach, club in 121, satellite sequence, and original drivable coastal truck.
- Entrance 1 now has two vestibule banks, each with **four usable silver glass door leaves**
  (two independent pairs), sidelights, transoms and exit labels.
- Orange upper lobby elevations, light wood lower panels, suspended cylindrical fixtures,
  the existing acoustic baffles and curtain glazing, plants, chairs and an entrance mat.
- Lower white acoustic-tile ceilings, slim emitting linear lights, gray streaked flooring,
  mustard/cream corridor finishes, short metal rail sections and room/wayfinding labels.
- Glass-front SCC 102 / 124 network rooms with two-block rack models: metal rails, switch
  faces, visible yellow patch leads, status indicators and blue overhead cable trays.
- SCC 123 is identified as the **Artificial Intelligence Lab**, with a long whiteboard,
  computer benches and a clear central aisle, rather than the old generic green-board classroom.
  Its lesson interaction remains at the same location.
- SCC 121 / 123 have functioning brown two-panel glazed doors, sidelights and transoms.
  119/120 and 101/102/103/124 have differentiated labels and doors/frontages.
- Home: complete bedroom-door lintel, reading-bay ceiling raised to meet the living ceiling,
  exterior bay roof moved above it, obsolete dangling chain removed, and additional ceiling
  fixtures at the dark doorway/bay. The same fixes are applied to new-scene night homes.

## Reference accuracy

The user's photographs guide materials, room identities and fixture details; the existing
PDF raster controls the shell. Minecraft block scale, some circulation and the furnishings
remain adaptations. This is **not a measured reconstruction**. The club room's interior
is still an adaptation: no interior photograph of 121 was supplied. Interior signs use
Minecraft's compact lettering; braille, institutional logos and fine poster text are not
claimed to be reproduced. Rail segments are not a surveyed reproduction of every indoor ramp.
No personal photographs, faces or reflections are bundled as textures.

## Saves and trying it

This is a new/replayed-intro revision, not a destructive rewrite of the occupied world.
The v31 private bank remains compatible with active v30 scenes; those scenes are retained rather
than rebuilt in place. Older v25–v29 layouts keep their earlier banks. **Installing the JAR alone
does not rebuild an active intro.**
Back up the world first. To replay, finish the intro, or deliberately skip it with
`/timelockedintro skip`, then use `/timelockedintro start` (operator permission required).
Skipping advances to the beach checkpoint; it is not an in-place building repair.
The original truck still appears in the coastal lot, not as a newly invented SCC vehicle.

## Testing / honest limitations

The update includes native dedicated-server checks of generated geometry, real door events,
player-width routes to mapped rooms, model registrations, vanilla block light, daytime/night
home fixes, scene-bank compatibility and the existing full story/vehicle/facility regressions.
The generated geometry export is test-only. Test entry points are not packaged in the JAR.
Block-light measurements do not certify shader exposure. No graphical Minecraft client or
user shader pack was available here; visual QA uses generated block/model geometry, not
screenshots falsely presented as in-game captures.
