package de.pandastudios.endorworks.core;

import static de.pandastudios.endorworks.core.GameScreen.HEIGHT;
import static de.pandastudios.endorworks.core.GameScreen.WIDTH;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main (String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "ENDORWORKS";
        config.width = WIDTH;
        config.height = HEIGHT;
        config.resizable = false;
        new LwjglApplication(new EndorworksGame(), config);
    }
}