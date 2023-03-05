package de.pandastudios.endorworks.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import de.pandastudios.endorworks.core.EndorworksGame;
import de.pandastudios.endorworks.core.utility.AssetScreenEnum;

public class LoadingScreen extends ScreenAdapter {

	public LoadingScreen(AssetScreenEnum assetScreenEnum) {
		for (String asset : assetScreenEnum.assetList) {
			EndorworksGame.INSTANCE.getAssetManager().load(asset, Texture.class);
		}
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (EndorworksGame.INSTANCE.getAssetManager().update()) {
			EndorworksGame.INSTANCE.setScreen(new GameScreen());
		}
	}

	@Override
	public void hide() {

	}
}
