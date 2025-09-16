# Agent: Visibility & Coverage Analysis

## Description
Compute visibility windows, ground station passes, sensor coverage, ground tracks, and illumination masks using propagated states.

## Dependencies
- Data Models & Common Types
- Propagation Engine

## Inputs
- Spacecraft ephemeris or propagation settings
- Ground station definitions; sensor definitions

## Deliverables
- Services: `getGroundStationPasses`, `sensorFootprintAt`, `dayNightMask`, `groundTrack`
- Geometry utilities for elevation masks and Earth models
- Docs and examples

## Public APIs
- `getGroundStationPasses(spacecraftId: string, stationId: string, start: string, end: string, maskDeg: number) -> Array<{start: string, end: string, maxElDeg: number}>`
- `sensorFootprintAt(sensor: Sensor, state: SpacecraftState) -> Polygon`
- `dayNightMask(range: TimeInterval) -> Mask`
- `groundTrack(ephemeris: Ephemeris, range: TimeInterval) -> Array<LatLon>`

## Tests
- Validate pass times against a known example within tolerance
- Footprint geometry sanity checks (area/shape)
- Terminator line aligns with sun position model

## Notes
- Consider WGS84 ellipsoid; configurable elevation mask; efficient interval merging.