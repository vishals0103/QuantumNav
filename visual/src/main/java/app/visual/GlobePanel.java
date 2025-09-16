package app.visual;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.layers.CompassLayer;
import gov.nasa.worldwind.layers.StarsLayer;
import gov.nasa.worldwind.layers.Earth.BMNGOneImageLayer;

import javax.swing.*;
import java.awt.*;

public class GlobePanel extends JPanel {
	private final WorldWindowGLCanvas wwd;

	public GlobePanel() {
		setLayout(new BorderLayout());
		wwd = new WorldWindowGLCanvas();
		wwd.setModel(new BasicModel());
		// Ensure some basic layers are present
		wwd.getModel().getLayers().add(new BMNGOneImageLayer());
		wwd.getModel().getLayers().add(new StarsLayer());
		wwd.getModel().getLayers().add(new CompassLayer());
		add(wwd, BorderLayout.CENTER);
	}

	public WorldWindowGLCanvas getWorldWindow() {
		return wwd;
	}
}