# Agent: Conjunction / Collision Risk Module

## Description
Detect close approaches between orbital objects and produce risk metrics using propagated states or catalogs.

## Dependencies
- Data Models & Common Types
- Propagation Engine

## Inputs
- Target spacecraft ephemeris
- Catalog of other objects (TLE or states)

## Deliverables
- Conjunction search over time ranges
- Metrics: miss distance, time of closest approach, relative velocity
- Catalog ingest utilities

## Public APIs
- `findConjunctions(subjectId: string, catalogId: string, start: string, end: string, thresholdKm: number) -> Array<{tca: string, miss_km: number, rel_speed_kms: number, otherId: string}>`

## Tests
- Known example with a small catalog yields expected TCA within tolerance

## Notes
- Start with deterministic screening (cube or distance threshold); later add covariance when available.