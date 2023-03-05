package de.pandastudios.endorworks.core.utility;

import java.util.Arrays;
import java.util.List;

/**
 * Enum for the information of the files with the textures.
 *
 */
public enum AssetScreenEnum {
	GAMESCREEN(Arrays.asList("baum_upper.png", "grass_upper.png", "grass.png", "sand_upper.png", "sand.png",
			"water_upper.png", "water.png")),
	MENUSCREEN(Arrays.asList("", ""));
	//UMBAUEN FÜR ATLAS!	
	
	public List<String> assetList;

	private AssetScreenEnum(List<String> assetList) {
		this.assetList = assetList;
	}
}
