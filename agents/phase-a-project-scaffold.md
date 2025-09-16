# Agent: Project Scaffold

## Description
Create the initial project with modules, build system, and minimal demos. Integrate Orekit and WorldWind. Provide a runnable app with a globe and a simple propagation log.

## Dependencies
- None

## Inputs
- None at generation time

## Deliverables
- Project structure: `core/`, `data/`, `analysis/`, `io/`, `visual/`, `ui/`
- Build: Maven or Gradle configuration with dependencies (Orekit, WorldWind, JSON/serialization lib)
- Starter app: WorldWind globe view and a minimal propagation example (one step)
- Docs: `README.md` with run instructions

## Public APIs
- N/A (scaffold only); provide module-level entry points and example main class.

## Tests
- Build compiles
- App boots and renders Earth globe
- Minimal propagation prints one state line with epoch and position

## Notes
- Prefer Gradle Kotlin DSL; pin library versions; include CI workflow stub.