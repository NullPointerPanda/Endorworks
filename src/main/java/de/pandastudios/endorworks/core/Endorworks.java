package de.pandastudios.endorworks.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Endorworks extends Game {

//	private ArrayList<GameObject> gameObjects;
//	private RenderUtilDAO renderUtilDAO;
	
	private SpriteBatch batch;
	private GameScreen screen;

	@Override
	public void create() {
		batch = new SpriteBatch();
		screen = new GameScreen(batch);
		setScreen(screen);
//		gameObjects = new ArrayList<>();
//		renderUtilDAO = new RenderUtilDAO();
//
//		renderUtilDAO.setRenderer(new ShapeRenderer());
//		renderUtilDAO.setBatch(new SpriteBatch());
//
//		Player player = new Player(GameAppConfig.RESOLUTION_WIDTH_HALF, GameAppConfig.RESOLUTION_HEIGHT_HALF,
//				new Texture(Gdx.files.internal("player.png")));
//		gameObjects.add(player);
//
//		Enemy enemy = new Enemy(250, 250, new Texture(Gdx.files.internal("Pikachu.png")));
//		gameObjects.add(enemy);
//
//		RedRectangle redRectangle = new RedRectangle(100, 100, 50, 50);
//		gameObjects.add(redRectangle);
	}

	@Override
	public void render() {
		super.render();
//		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//		renderUtilDAO.getRenderer().begin(ShapeRenderer.ShapeType.Filled);
//		renderUtilDAO.getBatch().begin();
//
//		for (GameObject gameObject : gameObjects) {
//			gameObject.render(renderUtilDAO);
//			gameObject.update();
//		}
//
//		renderUtilDAO.endAllRenderer();
	}

	@Override
	public void dispose() {
//		renderUtilDAO.getRenderer().dispose();
//		renderUtilDAO.getBatch();
	}

}
