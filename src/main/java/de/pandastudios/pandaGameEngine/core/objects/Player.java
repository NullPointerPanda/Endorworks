package de.pandastudios.pandaGameEngine.core.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import de.pandastudios.pandaGameEngine.utility.RenderUtilDAO;

public class Player implements GameObject {
	private Texture texture;
	private Vector2 velocity = new Vector2();

	private float x;
	private float y;

	public Player(final float x, final float y, final Texture texture) {
		this.x = x;
		this.y = y;
		this.texture = texture;
	}

	@Override
	public void update() {
		velocity.x = 0;
		velocity.y = 0;

		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			velocity.x = -200;
		} else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			velocity.x = 200;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			velocity.y = 200;
		} else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			velocity.y = -200;
		}

		x += velocity.x * Gdx.graphics.getDeltaTime();
		y += velocity.y * Gdx.graphics.getDeltaTime();
	}

	@Override
	public void render(RenderUtilDAO renderUtilDAO) {
		SpriteBatch batch = renderUtilDAO.getBatch();
		batch.enableBlending();
		batch.draw(texture, x, y);
		batch.disableBlending();
	}

	@Override
	public void dispose() {
		texture.dispose();
	}
}
