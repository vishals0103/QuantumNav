package app.core;

import app.data.Ephemeris;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PropagationService {
	public Ephemeris propagateDummy() {
		List<Ephemeris.SpacecraftStateLite> states = new ArrayList<>();
		Instant now = Instant.now();
		for (int i = 0; i < 360; i += 10) {
			double angle = Math.toRadians(i);
			double r = 7000_000.0; // 7000 km in meters
			double x = r * Math.cos(angle);
			double y = r * Math.sin(angle);
			double z = 0.0;
			states.add(new Ephemeris.SpacecraftStateLite(now.plusSeconds(i), x, y, z));
		}
		return new Ephemeris(states);
	}
}