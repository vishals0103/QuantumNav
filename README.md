# Mission Design App (Demo)

Multi-module Java 17 project with a minimal GUI showing a WorldWind globe and a Run button.

## Modules
- `data`: basic data classes (InitialOrbit, Ephemeris)
- `core`: services (PropagationService dummy)
- `io`: IO utilities (TleService stub)
- `visual`: Swing WorldWind globe panel
- `ui`: runnable app (Swing)

## Prerequisites
- JDK 17+
- Internet access to download dependencies from Maven Central

## Build
```bash
./gradlew build
```

## Run GUI
```bash
./gradlew :ui:run
```

If you run into OpenGL issues with WorldWind on some systems, you can add JVM flags:
```bash
./gradlew :ui:run --args ""
```

## Notes
- Propagation is a dummy circular orbit for now; integrate Orekit states next.
- WorldWind Java dependency: `gov.nasa.worldwind:worldwind:2.2.1`.