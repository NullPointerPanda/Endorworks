package de.pandastudios.endorworks.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.pandastudios.endorworks.core.objects.Player;
import de.pandastudios.endorworks.utility.CameraInputHandler;

public class GameScreen extends ScreenAdapter {

	public static final int WIDTH = 320 * 4;
	public static final int HEIGHT = 180 * 4;

	private SpriteBatch batch;
	private OrthographicCamera camera;
	private IsometricRenderer renderer;
	private Player player;

	public GameScreen(SpriteBatch batch) {
		this.batch = batch;
	}

	@Override
	public void show() {
		camera = new OrthographicCamera(WIDTH, HEIGHT);
		camera.position.set(WIDTH / 2 - 600, HEIGHT / 2, 10);

		renderer = new IsometricRenderer();
		player = new Player();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);

		player.update(delta, camera);
		CameraInputHandler.handleCameraInput(camera);
		camera.update();

		batch.begin();
		batch.enableBlending();

		renderer.drawIsometricTilemap(batch, delta, player.getPlayerTilePos());
		player.render(batch);

		batch.disableBlending();
		batch.end();
	}

}
