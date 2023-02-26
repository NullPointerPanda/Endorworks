package de.pandastudios.endorworks.utility;

import static de.pandastudios.endorworks.utility.TextureEnum.GRASS;
import static de.pandastudios.endorworks.utility.TextureEnum.GRASS_UPPER;
import static de.pandastudios.endorworks.utility.TextureEnum.SAND;
import static de.pandastudios.endorworks.utility.TextureEnum.SAND_UPPER;
import static de.pandastudios.endorworks.utility.TextureEnum.TREE_UPPER;
import static de.pandastudios.endorworks.utility.TextureEnum.WATER;
import static de.pandastudios.endorworks.utility.TextureEnum.WATER_UPPER;

import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TilemapUtility {
	private Map<String, Texture> TEXTURE_MAP;

	private static TilemapUtility INSTANCE;

	private TilemapUtility() {
		initTextureMap();
	}

	public static TilemapUtility getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new TilemapUtility();
		}

		return INSTANCE;
	}

	private void initTextureMap() {
		TEXTURE_MAP.put(GRASS.name(), new Texture(Gdx.files.internal(GRASS.assetName)));
		TEXTURE_MAP.put(GRASS_UPPER.name(), new Texture(Gdx.files.internal(GRASS_UPPER.assetName)));
		TEXTURE_MAP.put(WATER.name(), new Texture(Gdx.files.internal(WATER.assetName)));
		TEXTURE_MAP.put(WATER_UPPER.name(), new Texture(Gdx.files.internal(WATER_UPPER.assetName)));
		TEXTURE_MAP.put(SAND.name(), new Texture(Gdx.files.internal(SAND.assetName)));
		TEXTURE_MAP.put(SAND_UPPER.name(), new Texture(Gdx.files.internal(SAND_UPPER.assetName)));
		TEXTURE_MAP.put(TREE_UPPER.name(), new Texture(Gdx.files.internal(TREE_UPPER.assetName)));
	}
}
