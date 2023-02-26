package de.pandastudios.endorworks.core;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main (String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "My TEST Game";
        config.width = 1920;
        config.height = 1080;
        new LwjglApplication(new Endorworks(), config);
    }
}