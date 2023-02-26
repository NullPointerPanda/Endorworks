package de.pandastudios.endorworks.core;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tile {
	
	private Texture texture;
	public Vector2 tilemapPos;
	public Vector2 worldPos;
	
	public Tile(Texture texture, Vector2 tilemapPos, Vector2 worldPos) {
		this.texture = texture;
		this.tilemapPos = tilemapPos;
		this.worldPos = worldPos;
	}
	
	public void render(SpriteBatch batch) {
		batch.draw(texture, worldPos.x, worldPos.y);
	}
}
