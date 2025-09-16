# Agent: AI Assistant (Mistral)

## Description
In-app copilot that explains results, proposes next actions, drafts maneuver plans, pass schedules, checklists, and reports. Uses function calling to orchestrate internal services (propagation, passes, maneuvers, exports) and optional retrieval over local docs via embeddings.

## Dependencies
- UI / User Interaction
- Visualization Module
- Propagation Engine
- Visibility & Coverage Analysis
- IO Services

## Inputs
- User prompts, selected artifacts (plots, maps, tables) with metadata
- Local documents for retrieval (Orekit DSST guide, WorldWind layer docs, app README, module docs)
- `MISTRAL_API_KEY` environment variable

## Deliverables
- Module `assistant/` with:
  - `assistant-core`: Mistral HTTP client, tool/Function registry, short-term conversation memory, optional embeddings-based retriever with a simple local vector store
  - `assistant-ui`: Side panel chat, suggestions bar that reacts to app state, "Explain this" hooks on visual artifacts
  - `assistant/prompts/`: system instructions, safety rails, role prompts (Designer / Analyst / Operator), and tool JSON Schemas
  - `assistant-store/`: file-backed vector DB built from local docs

## Public APIs (Tool Schemas)
- `run_propagation(scenario_id: string, settings: PropagationSettings) -> { ephemeris_id: string }`
- `get_passes(spacecraft_id: string, station_id: string, start: string, end: string, mask_deg: number) -> Array<{ start: string, end: string, max_el: number }>`
- `plan_hohmann(spacecraft_id: string, target_alt_km: number) -> { dv_total: number, burns: Array<{ epoch: string, dv_mps_vec: [number, number, number] }> }`
- `insert_impulse(spacecraft_id: string, epoch_iso: string, dv_mps_vec: [number, number, number]) -> { ok: true }`
- `export_oem(ephemeris_id: string, path: string) -> { path: string }`
- `generate_report(scenario_id: string, template: string) -> { pdf_path: string }`

### Error Model
- All tool results return `{ ok: boolean, error?: { code: string, message: string } }` on failure

## Tests / Acceptance
- Query: "Design a sun-sync LEO @ 600 km for max morning passes over Paris and produce a 7-day pass table + ΔV budget."
  - Assistant calls `run_propagation` → `get_passes` → `plan_hohmann`
  - Returns a table of passes and ΔV summary; provides rationale via explanation mode
- Query: "Create a maneuver plan to circularize at apogee tomorrow 10:00 UTC."
  - Assistant proposes impulses and calls `insert_impulse` to update the scenario
- Retrieval: "How do I switch to DSST?"
  - Assistant cites a local doc chunk from `assistant-store/` and outlines steps

## Notes
- Default model: `mistral-medium-2508` (or latest Medium 3.x). Endpoint: `POST /v1/chat/completions` with streaming support if available.
- Keep tool descriptions concise with strict JSON Schema; guard-rail with role prompts.