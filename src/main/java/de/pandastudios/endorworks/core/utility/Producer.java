package de.pandastudios.endorworks.core.utility;

import static de.pandastudios.endorworks.core.utility.GameAppConfig.CAMERA_HEIGHT;
import static de.pandastudios.endorworks.core.utility.GameAppConfig.CAMERA_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

import de.pandastudios.endorworks.core.objects.IsometricTileMap;
import de.pandastudios.endorworks.core.objects.Player;

public class Producer {
	public static Player getPlayer() {
		return new Player();
	}

	public static IsometricTileMap getIsometricTileMap() {
		return new IsometricTileMap();
	}

	public static OrthographicCamera getSettedOrthographicCamera() {
		OrthographicCamera camera = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
//				300 * (GDX.GRAPHICS.GETHEIGHT() / GDX.GRAPHICS.GETWIDTH()));
//		SYSTEM.OUT.PRINTLN("ANFANG CAM X: " + CAMERA.POSITION.X + " ANFANG CAM Y: " + CAMERA.POSITION.Y);
//		CAMERA.POSITION.SET(GDX.GRAPHICS.GETWIDTH(), GDX.GRAPHICS.GETHEIGHT() / 2,
//		5);
//		CAMERA.POSITION.SET(CAMERA.VIEWPORTWIDTH / 2F, CAMERA.VIEWPORTHEIGHT / 2F, 0);
//		SYSTEM.OUT.PRINTLN("ENDE CAM X: " + CAMERA.POSITION.X + " ENDE CAM Y: " + CAMERA.POSITION.Y);
		camera.position.set(CAMERA_WIDTH / 2 - 600, CAMERA_HEIGHT / 2, 5);
		return camera;
	}
}
