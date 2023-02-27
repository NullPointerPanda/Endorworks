package de.pandastudios.endorworks.utility;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import de.pandastudios.endorworks.core.objects.Player;

public class PlayerInputHandler {
	public static int handlePlayerInput(Player player) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
			player.setPlayerWorldPosX(player.getPlayerWorldPos().x - 32f);
			player.setPlayerWorldPosY(player.getPlayerWorldPos().y + 18.5f);
			player.setPlayerTilePosY(player.getPlayerTilePos().y + 1);
			player.setMovementTimeLock(0);
			return Input.Keys.W;
		} else if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
			player.setPlayerWorldPosX(player.getPlayerWorldPos().x + 32f);
			player.setPlayerWorldPosY(player.getPlayerWorldPos().y - 18.5f);
			player.setPlayerTilePosY(player.getPlayerTilePos().y - 1);
			player.setMovementTimeLock(0);
			return Input.Keys.S;
		} else if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
			player.setPlayerWorldPosX(player.getPlayerWorldPos().x - 32f);
			player.setPlayerWorldPosY(player.getPlayerWorldPos().y - 18.5f);
			player.setPlayerTilePosX(player.getPlayerTilePos().x - 1);
			player.setMovementTimeLock(0);
			return Input.Keys.A;
		} else if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
			player.setPlayerWorldPosX(player.getPlayerWorldPos().x + 32f);
			player.setPlayerWorldPosY(player.getPlayerWorldPos().y + 18.5f);
			player.setPlayerTilePosX(player.getPlayerTilePos().x + 1);
			player.setMovementTimeLock(0);
			return Input.Keys.D;
		}
		return 0;
	}
}
