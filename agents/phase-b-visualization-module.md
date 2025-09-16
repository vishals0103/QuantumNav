# Agent: Visualization Module

## Description
Render orbits, ground tracks, and sensor footprints using WorldWind. Provide interactive globe with timeline control and overlays aligned to computed ephemerides.

## Dependencies
- Data Models & Common Types
- Propagation Engine
- IO Services (for layer toggle via imported datasets)

## Inputs
- `Ephemeris`, sensor definitions, ground stations

## Deliverables
- WorldWind layers: orbit path, current spacecraft marker, ground track, sensor footprints, day/night terminator
- Timeline control to scrub epoch
- Layer management utilities
- Docs with screenshots and example wiring

## Public APIs
- `addEphemerisLayer(ephemeris: Ephemeris) -> LayerId`
- `addGroundTrack(ephemeris: Ephemeris, interval: TimeInterval) -> LayerId`
- `addSensorFootprint(sensor: Sensor, state: SpacecraftState) -> LayerId`
- `setTimeCursor(epochIso: String) -> void`

## Tests
- Visual smoke tests: layers render without exceptions
- Alignment test: projected ground track matches propagated sub-satellite points within tolerance

## Notes
- Keep rendering decoupled from data model via adapters; ensure frame conversions handled before rendering.