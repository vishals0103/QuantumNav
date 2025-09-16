# Agent: Scripting / Plugin Interface

## Description
Allow users to automate workflows and extend the app with new sensors or force models via scripts or plugins.

## Dependencies
- Data Models & Common Types
- Propagation Engine
- IO Services

## Inputs
- Scripts or plugin modules

## Deliverables
- Script runner (embedded Python or DSL)
- Plugin hooks and lifecycle
- Sample script and sample plugin
- Documentation

## Public APIs
- `runScript(path: string, args: Record<string, any>) -> ScriptResult`
- `registerPlugin(plugin: Plugin) -> void`

## Tests
- Sample script defines mission, runs propagation, outputs data
- Sample plugin adds a sensor and is discovered/used by the app

## Notes
- Sandboxing and resource limits for scripts; clear versioning for plugin APIs.