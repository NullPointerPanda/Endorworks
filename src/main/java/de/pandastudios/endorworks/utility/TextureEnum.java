package de.pandastudios.endorworks.utility;

public enum TextureEnum {
	GRASS("GRASS", "grass.png"),
	GRASS_UPPER("GRASS_UPPER", "grass_upper.png"),
	WATER("WATER", "water.png"),
	WATER_UPPER("WATER_UPPER", "water_upper.png"),
	SAND("SAND", "sand.png"),
	SAND_UPPER("SAND_UPPER", "sand_upper.png"),
	TREE_UPPER("TREE_UPPER", "baum_upper.png");
	
	public final String assetName;
	
	private TextureEnum(String name, String assetName) {
		this.assetName = assetName;
	}
}
