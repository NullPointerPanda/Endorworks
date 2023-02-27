package de.pandastudios.endorworks.utility;

import static com.badlogic.gdx.Gdx.files;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.BufferedReader;
import java.io.IOException;

import org.slf4j.Logger;

import com.badlogic.gdx.files.FileHandle;

public class MapFileHandler {
	private static final Logger LOGGER = getLogger(MapFileHandler.class);
	
	public static String[][] readMap(final int rows, final int cols, final String fileName) {

		String[][] map = new String[rows][cols];
		FileHandle fileHandle = files.internal(fileName);

		try (BufferedReader bufferedReader = new BufferedReader(fileHandle.reader())) {

			String stringHolder = EMPTY;
			int count = 0;

			while ((stringHolder = bufferedReader.readLine()) != null) {
				map[count] = stringHolder.split(SPACE);
				count++;
			}

		} catch (IOException e) {
			LOGGER.warn("An error occurred while reading {}. Log: {}", fileName, e);
		}

		return map;
	}
}
