package de.pandastudios.endorworks.core.utility;

public enum GameObjectEnum {

	GRASS(true), //
	GRASS_UPPER(false), //
	WATER(false), //
	WATER_UPPER(false), //
	SAND(true), //
	SAND_UPPER(false), //
	TREE_UPPER(true),//
	PLAYER(false);//

	public final boolean isAccessible;

	private GameObjectEnum(boolean isAccessible) {
		this.isAccessible = isAccessible;
	}
}
