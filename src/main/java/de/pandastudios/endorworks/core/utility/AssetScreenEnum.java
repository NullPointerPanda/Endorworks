package de.pandastudios.endorworks.core.utility;

import java.util.Arrays;
import java.util.List;

/**
 * Enum for the information of the files with the textures.
 *
 */
public enum AssetScreenEnum {
	GAMESCREEN("GameScreen",Arrays.asList("baum_upper.png", "grass_upper.png", "grass.png", "sand_upper.png", "sand.png",
			"water_upper.png", "water.png")),
	MENUSCREEN("MenuScreen",Arrays.asList("", ""));
	//UMBAUEN FÜR ATLAS!	
	
	public String className;
	public List<String> assetList;

	private AssetScreenEnum(String className, List<String> assetList) {
		this.className = className;
		this.assetList = assetList;
	}
}
