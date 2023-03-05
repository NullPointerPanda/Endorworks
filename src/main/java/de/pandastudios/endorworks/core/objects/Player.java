package de.pandastudios.endorworks.core.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Player.class in which different player information is stored.
 *
 */
public class Player{

	private Texture playerTexture;
	private Vector2 playerWorldPos;
	private Vector2 playerTilePos;
	private float movementTimeLock;

	/**
	 * Constructor.
	 * 
	 */
	public Player() {
		playerTexture = new Texture(Gdx.files.internal("baum_upper.png"));
		playerWorldPos = new Vector2(0, 259);
		playerTilePos = new Vector2(7, 7);
	}

	/**
	 * Render method for drawing the sprite.
	 * 
	 * @param batch SpriteBatch
	 */
	public void render(SpriteBatch batch) {
		batch.draw(playerTexture, playerWorldPos.x, playerWorldPos.y);
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
