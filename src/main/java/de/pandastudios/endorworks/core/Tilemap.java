package de.pandastudios.endorworks.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Vector2;

import de.pandastudios.endorworks.utility.TextureEnum;

public class Tilemap {

	private static final int MAP_SIZE = 10;
	private static final int TILE_WIDTH = 64;
	private static final int TILE_HEIGHT = 74;

	public LinkedList<Tile> base_floor;
	public LinkedList<Tile> upper_floor;

	private Texture hill;
	private Texture water;
	private Texture grass;
	private Texture sand;
	private Texture tree;

	private Texture TEST;
	private Texture TEST2;

	private String[][] map;

	public Tilemap() {
		grass = new Texture(Gdx.files.internal(TextureEnum.GRASS.assetName));
		hill = new Texture(Gdx.files.internal(TextureEnum.GRASS_UPPER.assetName));
		water = new Texture(Gdx.files.internal(TextureEnum.WATER.assetName));
		sand = new Texture(Gdx.files.internal(TextureEnum.SAND.assetName));
		tree = new Texture(Gdx.files.internal(TextureEnum.TREE_UPPER.assetName));

		base_floor = new LinkedList<>();
		upper_floor = new LinkedList<>();

		map = new String[10][10];

//		fillBaseFileMap();

		try {
			fillMap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void render(SpriteBatch batch) {
		for (Tile tile : base_floor) {
			tile.render(batch);
		}

		for (Tile tile : upper_floor) {
			tile.render(batch);
		}
	}

	private void fillBaseFileMap() {
		for (int row = MAP_SIZE; row > 0; row--) {
			for (int col = MAP_SIZE; col > 0; col--) {

				float x = (row - col) * TILE_WIDTH / 2f;
				float y = (col + row) * TILE_HEIGHT / 3f;

				System.out.println("ROW: " + row + "\n" + "COL: " + col + "\n" + "X: " + x + "\n" + "Y: " + y);

				base_floor.add(new Tile(TEST, new Vector2(row, col), new Vector2(x, y)));
			}
		}
	}

	public void fillMap() throws IOException {
		FileHandle fh = Gdx.files.internal("mapBase.txt");
		try (BufferedReader br = new BufferedReader(fh.reader())) {
			String s = "";
			int count = 0;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
				map[count] = s.split(" ");
				count++;
			}
		} catch (IOException e) {
			// Fehlerbehandlung
		}

		Random r = new Random();
		for (int row = 9; row >= 0; row--) {
			for (int col = 9; col >= 0; col--) {

				float x = (row - col) * TILE_WIDTH / 2.0001f;
				float y = (col + row) * TILE_HEIGHT / 4f;

				if (map[row][col].equals("g")) {
					base_floor.add(new Tile(grass, new Vector2(row, col), new Vector2(x, y)));

					int num = r.nextInt(100);

	    			if(num > 70) {
	    				upper_floor.add(new Tile(tree, new Vector2(row, col), new Vector2(x,y)));
	    			} else if(num < 4) {
	    				upper_floor.add(new Tile(hill, new Vector2(row, col), new Vector2(x,y)));
	    			}

				} else if (map[row][col].equals("w")) {
					base_floor.add(new Tile(water, new Vector2(row, col), new Vector2(x, y)));
				} else if (map[row][col].equals("s")) {
					base_floor.add(new Tile(sand, new Vector2(row, col), new Vector2(x, y)));
				}
			}
		}
	}
}
