package app.data;

import java.time.Instant;
import java.util.List;

public class Ephemeris {
	public final List<SpacecraftStateLite> states;

	public Ephemeris(List<SpacecraftStateLite> states) {
		this.states = states;
	}

	public static class SpacecraftStateLite {
		public final Instant epoch;
		public final double x;
		public final double y;
		public final double z;

		public SpacecraftStateLite(Instant epoch, double x, double y, double z) {
			this.epoch = epoch;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}