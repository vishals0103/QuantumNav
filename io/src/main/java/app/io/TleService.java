package app.io;

import app.data.InitialOrbit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TleService {
	public InitialOrbit readTle(Path path) throws IOException {
		List<String> lines = Files.readAllLines(path);
		String l1 = lines.size() > 0 ? lines.get(0).trim() : "";
		String l2 = lines.size() > 1 ? lines.get(1).trim() : "";
		return new InitialOrbit(l1, l2);
	}
}