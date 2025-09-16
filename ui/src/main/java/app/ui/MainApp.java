package app.ui;

import app.core.PropagationService;
import app.data.Ephemeris;
import app.visual.GlobePanel;

import javax.swing.*;
import java.awt.*;

public class MainApp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(MainApp::start);
	}

	private static void start() {
		JFrame frame = new JFrame("Mission Design App - Demo");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);

		GlobePanel globePanel = new GlobePanel();
		JButton runButton = new JButton("Run Propagation (TLE)");
		JLabel status = new JLabel("Ready");

		runButton.addActionListener(e -> {
			String l1 = JOptionPane.showInputDialog(frame, "Enter TLE Line 1:", "1 25544U 98067A   20344.54791435  .00001264  00000-0  29621-4 0  9998");
			if (l1 == null || l1.trim().isEmpty()) return;
			String l2 = JOptionPane.showInputDialog(frame, "Enter TLE Line 2:", "2 25544  51.6449  64.8069 0001675  87.6084  51.4309 15.49318255257157");
			if (l2 == null || l2.trim().isEmpty()) return;
			status.setText("Running...");
			PropagationService svc = new PropagationService();
			Ephemeris eph = svc.propagateTle(l1.trim(), l2.trim(), 60, 30);
			status.setText("Done: " + eph.states.size() + " samples");
			JOptionPane.showMessageDialog(frame, "Propagation complete: " + eph.states.size() + " states.");
		});

		JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT));
		controls.add(runButton);
		controls.add(status);

		frame.setLayout(new BorderLayout());
		frame.add(controls, BorderLayout.NORTH);
		frame.add(globePanel, BorderLayout.CENTER);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}