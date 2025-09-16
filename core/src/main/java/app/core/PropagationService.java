package app.core;

import app.data.Ephemeris;
import org.orekit.frames.FramesFactory;
import org.orekit.propagation.analytical.tle.TLE;
import org.orekit.propagation.analytical.tle.TLEPropagator;
import org.orekit.time.AbsoluteDate;

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

	public Ephemeris propagateTle(String tleLine1, String tleLine2, int durationMinutes, int stepSeconds) {
		List<Ephemeris.SpacecraftStateLite> states = new ArrayList<>();
		try {
			TLE tle = new TLE(tleLine1, tleLine2);
			TLEPropagator propagator = TLEPropagator.selectExtrapolator(tle);
			AbsoluteDate startDate = tle.getDate();
			for (int t = 0; t <= durationMinutes * 60; t += Math.max(1, stepSeconds)) {
				AbsoluteDate date = startDate.shiftedBy(t);
				var pv = propagator.getPVCoordinates(date, FramesFactory.getTEME());
				Instant epoch = Instant.ofEpochSecond((long) date.toDate(AbsoluteDate.JAVA_EPOCH).getTime() / 1000L);
				states.add(new Ephemeris.SpacecraftStateLite(
						epoch,
						pv.getPosition().getX(),
						pv.getPosition().getY(),
						pv.getPosition().getZ()
				));
			}
		} catch (Exception ex) {
			return propagateDummy();
		}
		return new Ephemeris(states);
	}
}