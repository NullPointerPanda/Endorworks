package de.pandastudios.endorworks.core.screens;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import de.pandastudios.endorworks.core.EndorworksGame;
import de.pandastudios.endorworks.core.tween.SpriteAccessor;
import de.pandastudios.endorworks.core.utility.AssetScreenEnum;

public class LoadingScreen extends ScreenAdapter {
	private boolean isAnimationPlayed;
	private Texture texture;
	private SpriteBatch batch;
	private Sprite sprite;
	private TweenManager tweenManager;
	private String className;

	public LoadingScreen(AssetScreenEnum assetScreenEnum) {
		isAnimationPlayed = false;
		className = assetScreenEnum.className;
		for (String asset : assetScreenEnum.assetList) {
			EndorworksGame.INSTANCE.getAssetManager().load(asset, Texture.class);
		}

	}

	@Override
	public void show() {
		texture = new Texture(Gdx.files.internal("splash.png"));
		sprite = new Sprite(texture);
		sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new SpriteBatch();

		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		Tween.set(sprite, SpriteAccessor.ALPHA).target(1).start(tweenManager);
	}

	@Override
	public void render(float delta) {
		Gdx.app.debug("LoadingScreen", "Render called");
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		tweenManager.update(delta);

		batch.begin();
		sprite.draw(batch);
		batch.end();

		if (!isAnimationPlayed && EndorworksGame.INSTANCE.getAssetManager().update()) {
			Gdx.app.log("LoadingScreen", "Assets loaded, playing animation...");
			isAnimationPlayed = true;
			Tween.to(sprite, SpriteAccessor.ALPHA, 2).target(0).start(tweenManager);

			Timer.schedule(new Task() {
				@Override
				public void run() {
					EndorworksGame.INSTANCE.setScreen(new GameScreen());
				}
			}, 1.72f);
		}
	}

	@Override
	public void hide() {
		batch.dispose();
		texture.dispose();
	}

}
