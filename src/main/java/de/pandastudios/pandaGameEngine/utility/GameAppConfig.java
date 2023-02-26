package de.pandastudios.pandaGameEngine.utility;

import com.badlogic.gdx.Gdx;

public final class GameAppConfig {
	public static final String RESOURCE_PATH = "src/main/resources/assets/";

	public static final String PLAYER_PNG = "player.png";
	
	public static final float RESOLUTION_WIDTH_HALF = Gdx.graphics.getWidth() / 2f; 
	
	public static final float RESOLUTION_HEIGHT_HALF = Gdx.graphics.getHeight() / 2f; 

	public static final float VELOCITY_Y_PLAYER_UP = 100f;

	public static final float VELOCITY_Y_PLAYER_DOWN = -100f;

	public static final float VELOCITY_X_PLAYER_RIGHT = 100f;

	public static final float VELOCITY_X_PLAYER_LEFT = -100f;

	public static String getResourcePath(final String objectString) {
		return RESOURCE_PATH + objectString;
	}
}
