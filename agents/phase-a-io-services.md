# Agent: IO Services

## Description
Implement import/export for orbital formats and scenarios. Provide user-facing and programmatic entry points.

## Dependencies
- Data Models & Common Types

## Inputs
- Sample files: TLE, OEM, OPM

## Deliverables
- Parsers/writers: TLE, OEM/OPM, scenario JSON
- Public services callable from UI or CLI
- Error model for malformed files
- Example files in `samples/`

## Public APIs
- `readTLE(path: String) -> InitialOrbit`
- `writeScenario(scenario: MissionScenario, path: String) -> String`
- `exportOEM(ephemeris: Ephemeris, path: String) -> String`

## Tests
- Import sample files
- Export then re-import yields equivalent data (within tolerances)

## Notes
- Preserve original metadata; support gzip transparently if extension is `.gz`.