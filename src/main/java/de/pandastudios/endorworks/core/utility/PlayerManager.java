package de.pandastudios.endorworks.core.utility;

import com.badlogic.gdx.graphics.OrthographicCamera;

import de.pandastudios.endorworks.core.objects.IsometricTileMap;
import de.pandastudios.endorworks.core.objects.Player;

public class PlayerManager implements InputObserver {

	// OUT OF MAP?

	// private Map<GameObjectEnum, Vector2> map;

	private static PlayerManager INSTANCE;

	private Player player;
	private OrthographicCamera playerCamera;
	private IsometricTileMap isometricTileMap;

	private PlayerManager() {
		this.player = Producer.getPlayer();
		this.playerCamera = Producer.getSettedOrthographicCamera();
	}

	public static PlayerManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PlayerManager();
		}
		return INSTANCE;
	}

	@Override
	public void onNotify(int keycode) {
		if (keycode == GameAppConfig.KEY_W_VALUE) {
			player.getPlayerWorldPos().x -= 32f;
			player.getPlayerWorldPos().y += 18.5f;
			player.getPlayerTilePos().y += 1;
			playerCamera.position.x -= 32;
			playerCamera.position.y += 18.5;
		} else if (keycode == GameAppConfig.KEY_S_VALUE) {
			player.getPlayerWorldPos().x += 32f;
			player.getPlayerWorldPos().y -= 18.5f;
			player.getPlayerTilePos().y -= 1;
			playerCamera.position.x += 32;
			playerCamera.position.y -= 18.5;
		} else if (keycode == GameAppConfig.KEY_A_VALUE) {
			player.getPlayerWorldPos().x -= 32f;
			player.getPlayerWorldPos().y -= 18.5f;
			player.getPlayerTilePos().x -= 1;
			playerCamera.position.x -= 32;
			playerCamera.position.y -= 18.5;
		} else if (keycode == GameAppConfig.KEY_D_VALUE) {
			player.getPlayerWorldPos().x += 32f;
			player.getPlayerWorldPos().y += 18.5f;
			player.getPlayerTilePos().x += 1;
			playerCamera.position.x += 32;
			playerCamera.position.y += 18.5;
		}

	}

	public void addTilemap(IsometricTileMap tilemap) {
		this.isometricTileMap = tilemap;
	}

	public void deleteTilemap() {
		this.isometricTileMap = null;
	}

	public Player getPlayer() {
		return player;
	}

//	public Vector2 getPlayerTileMapPos() {
//		return map.get(GameObjectEnum.PLAYER);
//	}

	public OrthographicCamera getPlayerCamera() {
		return playerCamera;
	}

}
