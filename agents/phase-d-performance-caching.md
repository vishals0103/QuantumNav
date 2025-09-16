# Agent: Performance & Caching

## Description
Improve scalability for large scenarios via caching, batching, and concurrency controls while preserving correctness.

## Dependencies
- Propagation Engine
- IO Services

## Inputs
- Large scenarios; repeated queries over similar ranges

## Deliverables
- Ephemeris cache with invalidation
- Parallel propagation options and thread pool controls
- Sampling/resampling utilities with error bounds

## Public APIs
- `getCachedEphemeris(key: string, compute: () -> Ephemeris) -> Ephemeris`
- `setMaxWorkers(n: number) -> void`

## Tests
- Many-satellite benchmark shows improved runtime
- Cached results identical to fresh computation within tolerance

## Notes
- Make determinism configurable; document trade-offs for sampling intervals vs accuracy.