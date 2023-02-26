package de.pandastudios.pandaGameEngine.core;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import de.pandastudios.pandaGameEngine.core.objects.Enemy;
import de.pandastudios.pandaGameEngine.core.objects.GameObject;
import de.pandastudios.pandaGameEngine.core.objects.Player;
import de.pandastudios.pandaGameEngine.core.objects.RedRectangle;
import de.pandastudios.pandaGameEngine.utility.GameAppConfig;
import de.pandastudios.pandaGameEngine.utility.RenderUtilDAO;

public class TestGame extends Game {

	private ArrayList<GameObject> gameObjects;
	private RenderUtilDAO renderUtilDAO;

	@Override
	public void create() {
		gameObjects = new ArrayList<>();
		renderUtilDAO = new RenderUtilDAO();

		renderUtilDAO.setRenderer(new ShapeRenderer());
		renderUtilDAO.setBatch(new SpriteBatch());

		Player player = new Player(GameAppConfig.RESOLUTION_WIDTH_HALF, GameAppConfig.RESOLUTION_HEIGHT_HALF,
				new Texture(Gdx.files.internal("player.png")));
		gameObjects.add(player);

		Enemy enemy = new Enemy(250, 250, new Texture(Gdx.files.internal("Pikachu.png")));
		gameObjects.add(enemy);

		RedRectangle redRectangle = new RedRectangle(100, 100, 50, 50);
		gameObjects.add(redRectangle);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderUtilDAO.getRenderer().begin(ShapeRenderer.ShapeType.Filled);
		renderUtilDAO.getBatch().begin();

		for (GameObject gameObject : gameObjects) {
			gameObject.render(renderUtilDAO);
			gameObject.update();
		}

		renderUtilDAO.endAllRenderer();
	}

	@Override
	public void dispose() {
		renderUtilDAO.getRenderer().dispose();
		renderUtilDAO.getBatch();
	}
}
