package de.pandastudios.endorworks.utility;

import static com.badlogic.gdx.Gdx.files;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.BufferedReader;
import java.io.IOException;

import org.slf4j.Logger;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import de.pandastudios.endorworks.core.Tile;

public class TilemapUtility {
	private static final Logger LOGGER = getLogger(TilemapUtility.class);
	private static TilemapUtility INSTANCE;

	public static final String BASE_MAP_NAME = "mapBase.txt";
	public static final int BASE_MAP_SIZE = 10;
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 74;

	private TilemapUtility() {
	}

	public static TilemapUtility getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new TilemapUtility();
		}

		return INSTANCE;
	}

	public Tile generateTile(TextureEnum textureEnum, Vector2 tilemapPos, Vector2 worldPos) {
		return new Tile(new Texture(files.internal(textureEnum.assetName)), tilemapPos, worldPos);
	}

	public String[][] readBaseMap() {

		String[][] map = new String[BASE_MAP_SIZE][BASE_MAP_SIZE];
		FileHandle fileHandle = files.internal(BASE_MAP_NAME);

		try (BufferedReader bufferedReader = new BufferedReader(fileHandle.reader())) {

			String stringHolder = EMPTY;
			int count = 0;

			while ((stringHolder = bufferedReader.readLine()) != null) {
				// LOGGER.info(stringHolder);
				map[count] = stringHolder.split(SPACE);
				count++;
			}

		} catch (IOException e) {
			LOGGER.warn("An error occurred while reading {}. Log: {}", BASE_MAP_NAME, e);
		}

		return map;
	}
}
