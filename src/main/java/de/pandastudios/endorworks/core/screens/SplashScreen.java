package de.pandastudios.endorworks.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class SplashScreen extends ScreenAdapter {
//	private Texture background;
//	private Stage stage;

	public SplashScreen() {
//		EndorworksGame.INSTANCE.getAssetManager().load("splash.png", Texture.class);
//		background = EndorworksGame.INSTANCE.getAssetManager().get("splash.png");
	}

	@Override
	public void show() {
		// stage = new Stage(new ScreenViewport());
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 1, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//		if (EndorworksGame.INSTANCE.getAssetManager().update()) {
//			EndorworksGame.INSTANCE.setScreen(new GameScreen());
//		}
	}

	@Override
	public void hide() {

	}
}
