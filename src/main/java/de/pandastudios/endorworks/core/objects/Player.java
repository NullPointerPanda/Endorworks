package de.pandastudios.endorworks.core.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import de.pandastudios.endorworks.utility.PlayerInputHandler;

public class Player {

	private Texture playerTexture;
	private Vector2 playerWorldPos;
	private Vector2 playerTilePos;
	private float movementTimeLock;

	public Player() {
		playerTexture = new Texture(Gdx.files.internal("baum_upper.png"));
		playerWorldPos = new Vector2(0, 259);
		playerTilePos = new Vector2(7, 7);
		movementTimeLock = 0.15f;
	}

	public void render(SpriteBatch batch) {
		batch.draw(playerTexture, playerWorldPos.x, playerWorldPos.y);
	}

	public void update(float delta, OrthographicCamera camera) {
		movementTimeLock += delta;

		if (movementTimeLock > 0.15) {
			switch (PlayerInputHandler.handlePlayerInput(this)) {
			case 0: {
				break;
			}
			case Input.Keys.W: {
				camera.position.x -= 32;
				camera.position.y += 18.5;
				break;
			}
			case Input.Keys.S: {
				camera.position.x += 32;
				camera.position.y -= 18.5;
				break;
			}
			case Input.Keys.A: {
				camera.position.x -= 32;
				camera.position.y -= 18.5;
				break;
			}
			case Input.Keys.D: {
				camera.position.x += 32;
				camera.position.y += 18.5;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value from PlayerInputHandler");
			}
		}
	}

	public float getMovementTimeLock() {
		return movementTimeLock;
	}

	public void setMovementTimeLock(final float movementTimeLock) {
		this.movementTimeLock = movementTimeLock;
	}

	public Vector2 getPlayerWorldPos() {
		return playerWorldPos;
	}

	public void setPlayerWorldPosX(final float playerWorldPosX) {
		this.playerWorldPos.x = playerWorldPosX;
	}
	
	public void setPlayerWorldPosY(final float playerWorldPosY) {
		this.playerWorldPos.y = playerWorldPosY;
	}

	public Vector2 getPlayerTilePos() {
		return playerTilePos;
	}

	public void setPlayerTilePosX(final float playerTilePosX) {
		this.playerTilePos.x = playerTilePosX;
	}
	
	public void setPlayerTilePosY(final float playerTilePosY) {
		this.playerTilePos.y = playerTilePosY;
	}
}
