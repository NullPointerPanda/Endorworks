package de.pandastudios.endorworks.core;

import static de.pandastudios.endorworks.core.utility.GameAppConfig.CAMERA_HEIGHT;
import static de.pandastudios.endorworks.core.utility.GameAppConfig.CAMERA_WIDTH;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * Class to start the application.
 *
 */
public class DesktopLauncher {
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "ENDORWORKS";
		config.width = CAMERA_WIDTH;
		config.height = CAMERA_HEIGHT;
		config.resizable = false;
		new LwjglApplication(new EndorworksGame(), config);
	}
}