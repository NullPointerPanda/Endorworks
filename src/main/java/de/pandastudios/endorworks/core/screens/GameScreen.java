package de.pandastudios.endorworks.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.pandastudios.endorworks.core.objects.IsometricTileMap;
import de.pandastudios.endorworks.core.utility.PlayerManager;
import de.pandastudios.endorworks.core.utility.Producer;

/**
 * GameScreen.class is responsible for handling (i.e., processing and rendering)
 * a game screen.
 *
 */
public class GameScreen extends ScreenAdapter {
	private SpriteBatch batch;
	private IsometricTileMap isometricTileMap;

	/**
	 * Constructor.
	 * 
	 * @param batch
	 */
	public GameScreen() {
		this.batch = new SpriteBatch();
	}

	@Override
	public void show() {
		isometricTileMap = Producer.getIsometricTileMap();
		PlayerManager.getInstance().addTilemap(isometricTileMap);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(PlayerManager.getInstance().getPlayerCamera().combined);

		PlayerManager.getInstance().getPlayerCamera().update();

		batch.begin();
		batch.enableBlending();

		isometricTileMap.renderIsometricTilemap(batch, delta,
				PlayerManager.getInstance().getPlayer().getPlayerTilePos());
		PlayerManager.getInstance().getPlayer().render(batch);

		batch.disableBlending();
		batch.end();
	}

	@Override
	public void hide() {
		System.out.println("HIDE");
		PlayerManager.getInstance().deleteTilemap();
		isometricTileMap.dispose();
		batch.dispose();
	}

}
