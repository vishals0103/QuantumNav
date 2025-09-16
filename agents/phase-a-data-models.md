# Agent: Data Models & Common Types

## Description
Define core domain types for the app, including serialization. Ensure all downstream modules import from this package for consistency.

## Dependencies
- Project Scaffold

## Inputs
- None

## Deliverables
- Package `data` with types: `InitialOrbit`, `SpacecraftState`, `Ephemeris`, `Sensor`, `GroundStation`, `MissionScenario`, `TimeInterval`, `AttitudeMode`, `FrameId`
- JSON serialization (e.g., Jackson) with versioned schemas
- Parsers stubs for TLE and OEM/OPM types (no IO yet)
- Module docs and type diagrams

## Public APIs
- `serializeScenario(scenario: MissionScenario) -> String`
- `deserializeScenario(json: String) -> MissionScenario`
- Validation helpers (units, ranges)

## Tests
- JSON round-trip for all types
- Sample TLE parsed into `InitialOrbit` shell
- Unit consistency checks (e.g., meters vs kilometers)

## Notes
- Use immutable data where practical; include UTC ISO-8601 everywhere; store frames explicitly.