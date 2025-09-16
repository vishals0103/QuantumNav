# Agent: Propagation Engine

## Description
Provide high-level propagation services using Orekit. Configure force models and event detection. Output ephemeris time series consumable by visualization and analysis.

## Dependencies
- Data Models & Common Types

## Inputs
- `InitialOrbit`, propagation settings, time span

## Deliverables
- Service `propagate(initialState, settings, timeSpan) -> Ephemeris`
- Event hooks (eclipse, ground station visibility hooks stub)
- Force model configuration utilities (J2, drag, SRP stubs)
- Example usage in docs

## Public APIs
- `propagate(initialState: InitialOrbit, settings: PropagationSettings, timeSpan: TimeInterval) -> Ephemeris`
- `withEvent(eventType: EventType, handler: EventHandler) -> PropagationSettings`

## Tests
- Propagate a simple orbit; compare orbital parameters at checkpoints to Orekit examples (tolerance-based)
- Eclipse detection sanity example

## Notes
- Make time step and integrator configurable; ensure frames are explicit and consistent.