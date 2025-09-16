# Agent: Maneuvers & Optimization

## Description
Plan and simulate impulsive and finite-burn maneuvers, compute ΔV budgets, and provide simple transfer optimizations (e.g., Hohmann, plane change).

## Dependencies
- Data Models & Common Types
- Propagation Engine

## Inputs
- Current orbit/state, target conditions, maneuver constraints

## Deliverables
- Maneuver definitions (impulsive, continuous)
- ΔV calculators and budget summaries
- Planners: `planHohmann`, `planPlaneChange`, chaining support
- API to insert maneuvers into scenarios

## Public APIs
- `planHohmann(spacecraftId: string, targetAltKm: number) -> { dv_total: number, burns: Array<{epoch: string, dv_mps_vec: [number, number, number]}> }`
- `insertImpulse(spacecraftId: string, epochIso: string, dv_mps_vec: [number, number, number]) -> { ok: true }`
- `estimatePlaneChange(dv: number, nodeEpoch: string) -> { dv_total: number }`

## Tests
- Hohmann ΔV matches analytic within tolerance
- Inserting burns changes orbit as expected
- Chained maneuvers produce cumulative ΔV correctly

## Notes
- Provide both analytic estimates and propagated verification; expose reference frames for ΔV vectors.