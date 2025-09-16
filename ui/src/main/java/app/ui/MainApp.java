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
		JButton runButton = new JButton("Run Propagation");
		JLabel status = new JLabel("Ready");

		runButton.addActionListener(e -> {
			status.setText("Running...");
			PropagationService svc = new PropagationService();
			Ephemeris eph = svc.propagateDummy();
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