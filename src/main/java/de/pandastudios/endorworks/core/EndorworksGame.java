package de.pandastudios.endorworks.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndorworksGame extends Game {

	private SpriteBatch batch;
	private GameScreen screen;

	@Override
	public void create() {
		batch = new SpriteBatch();
		screen = new GameScreen(batch);
		setScreen(screen);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
		screen.dispose();
	}

}
