package de.pandastudios.endorworks.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraInputHandler {
	public static void handleCameraInput(final OrthographicCamera camera) {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			camera.position.x -= 5;
		} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			camera.position.x += 5;
		} else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			camera.position.y += 5;
		} else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			camera.position.y -= 5;
		} else if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
			camera.zoom -= 0.01;
		} else if (Gdx.input.isKeyPressed(Input.Keys.V)) {
			camera.zoom += 0.01;
		}
	}
}
