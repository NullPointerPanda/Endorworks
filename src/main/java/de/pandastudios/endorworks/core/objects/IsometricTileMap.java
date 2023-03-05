package de.pandastudios.endorworks.core.objects;

import static de.pandastudios.endorworks.core.utility.GameAppConfig.ISOMETRIC_MAP_SIZE;
import static de.pandastudios.endorworks.core.utility.GameAppConfig.TILE_HEIGHT;
import static de.pandastudios.endorworks.core.utility.GameAppConfig.TILE_WIDTH;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

import de.pandastudios.endorworks.core.utility.GameAppConfig;
import de.pandastudios.endorworks.core.utility.MapFileHandler;
import de.pandastudios.endorworks.core.utility.TextureEnum;

/**
 * IsometricTileMap.class to create an Isometric-TileMap.
 *
 */
public class IsometricTileMap implements Disposable{

	private LinkedList<IsometricTile> base_floor;
	private LinkedList<IsometricTile> upper_floor;

	private int[][] baseMap;
	private int[][] upperMap;

	/**
	 * Constructor.
	 */
	public IsometricTileMap() {
		base_floor = new LinkedList<>();
		upper_floor = new LinkedList<>();

		if (GameAppConfig.isMapRandom) {
			generateMapRandom();
		} else {
			generateMapByFile();
		}

	}

	/**
	 * Runs through a loop of individual tiles that calls the render logic of the
	 * Isometric class.
	 * 
	 * @param batch         SpriteBatch
	 * @param delta         the amount of time that has elapsed since the previous
	 * @param playerTilePos position of the player in the TileMap
	 */
	public void renderIsometricTilemap(SpriteBatch batch, float delta, Vector2 playerTilePos) {
		for (IsometricTile tile : base_floor) {
			tile.render(batch, delta, playerTilePos);
		}

		for (IsometricTile tile : upper_floor) {
			tile.render(batch, delta, playerTilePos);
		}
	}

	/**
	 * Fills lists with the arranged tiles.
	 * 
	 * @param base  Map Map with the base tiles.
	 * @param upper Map Map with the upper tiles.
	 * @param rows  rows
	 * @param cols  cols
	 */
	private void fillIsometricTileToMap(final int[][] baseMap, final int[][] upperMap, final int rows, final int cols) {

		for (int row = rows - 1; row >= 0; row--) {
			for (int col = cols - 1; col >= 0; col--) {

				float x = (row - col) * TILE_WIDTH / 2f;
				float y = (col + row) * TILE_HEIGHT / 4f;

				switch (baseMap[row][col]) {
				case 1: {
					base_floor.add(new IsometricTile(new Texture(Gdx.files.internal(TextureEnum.GRASS.assetName)),
							new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				case 3: {
					base_floor.add(new IsometricTile(new Texture(Gdx.files.internal(TextureEnum.WATER.assetName)),
							new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				case 5: {
					base_floor.add(new IsometricTile(new Texture(Gdx.files.internal(TextureEnum.SAND.assetName)),
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
					upper_floor
							.add(new IsometricTile(new Texture(Gdx.files.internal(TextureEnum.GRASS_UPPER.assetName)),
									new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				case 4: {
					upper_floor
							.add(new IsometricTile(new Texture(Gdx.files.internal(TextureEnum.WATER_UPPER.assetName)),
									new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				case 6: {
					upper_floor.add(new IsometricTile(new Texture(Gdx.files.internal(TextureEnum.SAND_UPPER.assetName)),
							new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				case 7: {
					upper_floor.add(new IsometricTile(new Texture(Gdx.files.internal(TextureEnum.TREE_UPPER.assetName)),
							new Vector2(row, col), new Vector2(x, y)));
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + upperMap[row][col]);
				}

			}
		}
	}

	/**
	 * Assigns tiles to a random value in an iteration and stores them in an integer
	 * matrix.
	 */
	private void generateMapRandom() {

		baseMap = new int[ISOMETRIC_MAP_SIZE][ISOMETRIC_MAP_SIZE];
		upperMap = new int[ISOMETRIC_MAP_SIZE][ISOMETRIC_MAP_SIZE];

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

	/**
	 * Tiles are assigned to a texture based on a fixed map.
	 */
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

	public int[][] getBaseMap() {
		return baseMap;
	}

	public int[][] getUpperMap() {
		return upperMap;
	}

	@Override
	public void dispose() {
		for (IsometricTile tile : base_floor) {
			tile.dispose();
		}

		for (IsometricTile tile : upper_floor) {
			tile.dispose();
		}
	}
}
