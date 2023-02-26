package de.pandastudios.endorworks.core;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main (String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "ENDORWORKS";
        config.width = 1920;
        config.height = 1080;
        config.resizable = false;
        new LwjglApplication(new Endorworks(), config);
    }
}