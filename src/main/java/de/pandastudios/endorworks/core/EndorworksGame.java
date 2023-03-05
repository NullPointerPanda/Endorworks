package de.pandastudios.endorworks.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;

import de.pandastudios.endorworks.core.screens.GameScreen;
import de.pandastudios.endorworks.core.screens.LoadingScreen;
import de.pandastudios.endorworks.core.screens.MenuScreen;
import de.pandastudios.endorworks.core.utility.AssetScreenEnum;
import de.pandastudios.endorworks.core.utility.GameAppConfig;
import de.pandastudios.endorworks.core.utility.InputObserver;
import de.pandastudios.endorworks.core.utility.InputSystem;
import de.pandastudios.endorworks.core.utility.PlayerManager;

/**
 * The Game class is responsible for handling multiple screens and provides some
 * helper methods for this purpose.
 */
public class EndorworksGame extends Game implements InputObserver {
	// private EnemyManager enemyManager;
	// private GameManager gameManager;
	// private ScreenManager screenManager;
	public static EndorworksGame INSTANCE;

	private InputSystem inputSystem;

	private MenuScreen menuScreen;
	private GameScreen gameScreen;

	private AssetManager assetManager;

	public EndorworksGame() {
		INSTANCE = this;
	}

	@Override
	public void create() {
		this.initInputSystem();
		assetManager = new AssetManager();
		setScreen(new LoadingScreen(AssetScreenEnum.GAMESCREEN));
		

		//setScreen(gameScreen);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		assetManager.dispose();
	}

	@Override
	public void onNotify(int keycode) {
		if (keycode == GameAppConfig.KEY_T_VALUE) {
			setScreen(new GameScreen());
			GameAppConfig.logHeapSize();
		} else if (keycode == GameAppConfig.KEY_Z_VALUE) {
			setScreen(new MenuScreen());
			GameAppConfig.logHeapSize();
		}
	}

	public void initInputSystem() {
		inputSystem = new InputSystem();
		Gdx.input.setInputProcessor(inputSystem);
		this.initInputObserver();
	}

	public void initInputObserver() {
		inputSystem.addObserver(this);
		inputSystem.addObserver(PlayerManager.getInstance());
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}
}
