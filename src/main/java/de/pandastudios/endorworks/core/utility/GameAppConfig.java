package de.pandastudios.endorworks.core.utility;

/**
 * Class for game constants that are relevant for everything.
 *
 */
public final class GameAppConfig {

	public static final int ISOMETRIC_MAP_SIZE = 50;
	public static final int TILE_WIDTH = 64;
	public static final int TILE_HEIGHT = 74;
	public static final int CAMERA_WIDTH = 320 * 4; // 1280
	public static final int CAMERA_HEIGHT = 180 * 4; // 720
	public static final int KEY_W_VALUE = 51;
	public static final int KEY_S_VALUE = 47;
	public static final int KEY_A_VALUE = 29;
	public static final int KEY_D_VALUE = 32;
	public static final int KEY_T_VALUE = 48;
	public static final int KEY_Z_VALUE = 54;

	public static final boolean isMapRandom = true;
	public static final boolean isDevelopmentMode = true;

	public static void logHeapSize() {
		System.out.println(formatSize(Runtime.getRuntime().totalMemory()));
		System.out.println(formatSize(Runtime.getRuntime().maxMemory()));
		System.out.println(formatSize(Runtime.getRuntime().freeMemory()));
	}

	public static String formatSize(long v) {
		if (v < 1024)
			return v + " B";
		int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
		return String.format("%.1f %sB", (double) v / (1L << (z * 10)), " KMGTPE".charAt(z));
	}
}
