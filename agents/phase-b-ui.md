# Agent: UI / User Interaction

## Description
Provide screens and controls to define scenarios, run propagation, and view results. Include basic error handling and status feedback.

## Dependencies
- Data Models & Common Types
- IO Services
- Propagation Engine
- Visualization Module

## Inputs
- User inputs for initial orbit (TLE or elements), duration, step size

## Deliverables
- Scenario editor form
- Actions: Run propagation, save/load scenario, export OEM
- Map view with visualization pane and timeline
- Notifications and validation messages

## Public APIs
- UI events to call services: `onRunPropagation(scenarioId, settings)`, `onExportOEM(ephemerisId, path)`
- State selectors for current scenario and results

## Tests
- E2E flow: create scenario → run propagation → visualize results
- Input validation: invalid TLE shows error; duration limits enforced

## Notes
- Keep UI state minimal, derive where possible; ensure accessibility in forms and controls.