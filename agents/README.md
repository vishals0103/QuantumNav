## Cursor Agents Specs

This folder contains modular agent specifications used by Cursor to generate, test, and integrate features for the Mission Design App.

### Structure
- `_template.md`: Copy this to create a new agent spec.
- Phase A: Core foundation (scaffold, types, IO, propagation)
- Phase B: Visualization and basic UI loop
- Phase C: Analysis (visibility, maneuvers)
- Phase D: Advanced (conjunction, scripting, performance)
- `assistant.md`: In-app AI assistant that orchestrates tool calls

### Conventions
- One agent per file; keep scope tight and include tests and sample data.
- Shared types live in `data` and are imported by other agents.
- All public APIs declare inputs, outputs, error shapes, and example usage.

