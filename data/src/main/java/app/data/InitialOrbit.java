package app.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InitialOrbit {
	public final String tleLine1;
	public final String tleLine2;

	@JsonCreator
	public InitialOrbit(
			@JsonProperty("tleLine1") String tleLine1,
			@JsonProperty("tleLine2") String tleLine2) {
		this.tleLine1 = tleLine1;
		this.tleLine2 = tleLine2;
	}
}