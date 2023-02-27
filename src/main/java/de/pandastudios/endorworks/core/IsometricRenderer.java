package de.pandastudios.endorworks.core;

import static de.pandastudios.endorworks.utility.GameAppConfig.ISOMETRIC_MAP_SIZE;
import static de.pandastudios.endorworks.utility.GameAppConfig.TILE_HEIGHT;
import static de.pandastudios.endorworks.utility.GameAppConfig.TILE_WIDTH;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import de.pandastudios.endorworks.utility.GameAppConfig;
import de.pandastudios.endorworks.utility.MapFileHandler;
import de.pandastudios.endorworks.utility.TextureEnum;

public class IsometricRenderer {

	private LinkedList<Isometric> base_floor;
	private LinkedList<Isometric> upper_floor;

	public IsometricRenderer() {
		base_floor = new LinkedList<>();
		upper_floor = new LinkedList<>();

		if (GameAppConfig.isMapRandom) {
			generateMapRandom();
		} else {
			generateMapByFile();
		}

	}

	public void drawIsometricTilemap(SpriteBatch batch, float delta, Vector2 playerTilePos) {
		for (Isometric tile : base_floor) {
			tile.render(batch, delta, playerTilePos);
		}

		for (Isometric tile : upper_floor) {
			tile.render(batch, delta, playerTilePos);
		}
	}

	private void fillIsometricTileToMap(final int[][] baseMap, final int[][] upperMap, final int rows, final int cols) {

		for (int row = rows - 1; row >= 0; row--) {
			for (int col = cols - 1; col >= 0; col--) {

				float x = (row - col) * TILE_WIDTH / 2f;
				float y = (col + row) * TILE_HEIGHT / 4f;
				
				switch (baseMap[row][col]) {
				case 1: {
					base_floor.add(new Isometric(new Texture(Gdx.files.internal(TextureEnum.GRASS.assetName)),
							new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				case 3: {
					base_floor.add(new Isometric(new Texture(Gdx.files.internal(TextureEnum.WATER.assetName)),
							new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				case 5: {
					base_floor.add(new Isometric(new Texture(Gdx.files.internal(TextureEnum.SAND.assetName)),
							new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + baseMap[row][col]);
				}

				switch (upperMap[row][col]) {
				case 0: {
					break;
				}
				case 2: {
					upper_floor.add(new Isometric(new Texture(Gdx.files.internal(TextureEnum.GRASS_UPPER.assetName)),
							new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				case 4: {
					upper_floor.add(new Isometric(new Texture(Gdx.files.internal(TextureEnum.WATER_UPPER.assetName)),
							new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				case 6: {
					upper_floor.add(new Isometric(new Texture(Gdx.files.internal(TextureEnum.SAND_UPPER.assetName)),
							new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				case 7: {
					upper_floor.add(new Isometric(new Texture(Gdx.files.internal(TextureEnum.TREE_UPPER.assetName)),
							new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + upperMap[row][col]);
				}

			}
		}
	}

	private void generateMapRandom() {

		int[][] baseMap = new int[ISOMETRIC_MAP_SIZE][ISOMETRIC_MAP_SIZE];
		int[][] upperMap = new int[ISOMETRIC_MAP_SIZE][ISOMETRIC_MAP_SIZE];

		for (int row = ISOMETRIC_MAP_SIZE - 1; row >= 0; row--) {
			for (int col = ISOMETRIC_MAP_SIZE - 1; col >= 0; col--) {

				double randomBase = Math.random();
				double randomUpper = Math.random();

				if (randomBase < 0.6) {
					baseMap[row][col] = 1;
					if (randomUpper > 0.8) {
						upperMap[row][col] = 7;
					} else if (randomUpper < 0.1) {
						upperMap[row][col] = 2;
					}
				} else if (randomBase > 0.8) {
					baseMap[row][col] = 3;
				} else {
					baseMap[row][col] = 5;
					if (randomUpper < 0.1) {
						upperMap[row][col] = 6;
					}
				}
			}
		}

		baseMap[6][6] = 1;
		upperMap[6][6] = 0;

		fillIsometricTileToMap(baseMap, upperMap, ISOMETRIC_MAP_SIZE, ISOMETRIC_MAP_SIZE);
	}

	private void generateMapByFile() {

		final int rows = 10;
		final int cols = 10;

		String[][] map = MapFileHandler.readMap(rows, cols, "mapBase.txt");

		int[][] baseMap = new int[rows][cols];
		int[][] upperMap = new int[rows][cols];

		for (int row = rows - 1; row >= 0; row--) {
			for (int col = cols - 1; col >= 0; col--) {

				double randomUpper = Math.random();

				if (map[row][col].equals("g")) {
					baseMap[row][col] = 1;
					if (randomUpper > 0.8) {
						upperMap[row][col] = 7;
					} else if (randomUpper < 0.1) {
						upperMap[row][col] = 2;
					}
				} else if (map[row][col].equals("w")) {
					baseMap[row][col] = 3;
				} else if (map[row][col].equals("s")) {
					baseMap[row][col] = 5;
					if (randomUpper < 0.1) {
						upperMap[row][col] = 6;
					}
				}
			}
		}

		fillIsometricTileToMap(baseMap, upperMap, rows, cols);
	}
}
