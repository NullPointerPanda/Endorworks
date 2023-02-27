package de.pandastudios.endorworks.core;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Isometric {

	private Texture texture;
	private Vector2 tilemapPos;
	private Vector2 worldPos;
	private boolean onScreen;
	private float aniY;
	private float time;
	private float aniSpeed;

	public Isometric(Texture texture, Vector2 tilemapPos, Vector2 worldPos) {
		this.texture = texture;
		this.tilemapPos = tilemapPos;
		this.worldPos = worldPos;
		this.aniY = worldPos.y - 32;
		this.onScreen = false;
		float[] aniOptions = { 2, 4, 8, 16 };
		Random random = new Random();
		aniSpeed = aniOptions[random.nextInt(4)];
	}

	public void render(SpriteBatch batch, float delta, Vector2 playerTilePos) {

		if (Math.abs(tilemapPos.x - playerTilePos.x) <= 4 && Math.abs(tilemapPos.y - playerTilePos.y) <= 4) {

			if (!onScreen) {
				time += delta;

				if (time > 0.02f) {
					aniY += aniSpeed;
					time = 0;
				}

				if (aniY == worldPos.y) {
					onScreen = true;
				}
			}

			batch.draw(texture, worldPos.x, aniY);
		} else {

			if (onScreen) {
				time += delta;
				if (time > 0.02f) {
					aniY -= aniSpeed;
					time = 0;
				}

				if (aniY == worldPos.y - 32) {
					onScreen = false;
				}

				batch.draw(texture, worldPos.x, aniY);
			}

		}

	}

}
