package de.pandastudios.endorworks.core;

import static de.pandastudios.endorworks.utility.TilemapUtility.BASE_MAP_SIZE;
import static de.pandastudios.endorworks.utility.TilemapUtility.TILE_HEIGHT;
import static de.pandastudios.endorworks.utility.TilemapUtility.TILE_WIDTH;
import static de.pandastudios.endorworks.utility.TilemapUtility.getInstance;

import java.util.LinkedList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import de.pandastudios.endorworks.utility.TextureEnum;

public class Tilemap {

	public LinkedList<Tile> base_floor;
	public LinkedList<Tile> upper_floor;

	public Tilemap() {
		base_floor = new LinkedList<>();
		upper_floor = new LinkedList<>();

//		fillMapWithFile();
		generateMapRandom();
	}

	public void render(SpriteBatch batch) {
		for (Tile tile : base_floor) {
			tile.render(batch);
		}

		for (Tile tile : upper_floor) {
			tile.render(batch);
		}
	}

	public void generateMapRandom() {
		int tempSize = 20;

		for (int row = tempSize - 1; row >= 0; row--) {
			for (int col = tempSize - 1; col >= 0; col--) {

				float x = (row - col) * TILE_WIDTH / 2f;
				float y = (col + row) * TILE_HEIGHT / 4f;

				var randomBase = Math.random();
				if (randomBase < 0.6) {
					base_floor.add(
							getInstance().generateTile(TextureEnum.GRASS, new Vector2(row, col), new Vector2(x, y)));
					var randomUpper = Math.random();
					if (randomUpper > 0.8) {
						upper_floor.add(getInstance().generateTile(TextureEnum.TREE_UPPER, new Vector2(row, col),
								new Vector2(x, y)));
					} else if (randomUpper < 0.1) {
						upper_floor.add(getInstance().generateTile(TextureEnum.GRASS_UPPER, new Vector2(row, col),
								new Vector2(x, y)));
					}
				} else if (randomBase > 0.8) {
					base_floor.add(
							getInstance().generateTile(TextureEnum.WATER, new Vector2(row, col), new Vector2(x, y)));
				} else {
					base_floor.add(
							getInstance().generateTile(TextureEnum.SAND, new Vector2(row, col), new Vector2(x, y)));
					var randomUpper = Math.random();
					if (randomUpper < 0.1) {
						upper_floor.add(getInstance().generateTile(TextureEnum.SAND_UPPER, new Vector2(row, col),
								new Vector2(x, y)));
					}
				}
			}
		}
	}

	public void fillMapWithFile() {
		String[][] baseMap = getInstance().readBaseMap();

		Random r = new Random();

		for (int row = BASE_MAP_SIZE - 1; row >= 0; row--) {
			for (int col = BASE_MAP_SIZE - 1; col >= 0; col--) {

				float x = (row - col) * TILE_WIDTH / 2f;
				float y = (col + row) * TILE_HEIGHT / 4f;

				if (baseMap[row][col].equals("g")) {
					base_floor.add(
							getInstance().generateTile(TextureEnum.GRASS, new Vector2(row, col), new Vector2(x, y)));

					int num = r.nextInt(100);

					if (num > 70) {
						upper_floor.add(getInstance().generateTile(TextureEnum.TREE_UPPER, new Vector2(row, col),
								new Vector2(x, y)));
					} else if (num < 4) {
						upper_floor.add(getInstance().generateTile(TextureEnum.GRASS_UPPER, new Vector2(row, col),
								new Vector2(x, y)));
					}

				} else if (baseMap[row][col].equals("w")) {
					base_floor.add(
							getInstance().generateTile(TextureEnum.WATER, new Vector2(row, col), new Vector2(x, y)));
				} else if (baseMap[row][col].equals("s")) {
					base_floor.add(
							getInstance().generateTile(TextureEnum.SAND, new Vector2(row, col), new Vector2(x, y)));
				}
			}
		}
	}
}
