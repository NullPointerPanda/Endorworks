package de.pandastudios.pandaGameEngine.utility;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class RenderUtilDAO {

	private SpriteBatch batch;
	private ShapeRenderer renderer;

	public RenderUtilDAO() {
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public ShapeRenderer getRenderer() {
		return renderer;
	}

	public void setRenderer(ShapeRenderer renderer) {
		this.renderer = renderer;
	}

	public void endAllRenderer() {
		if (batch != null) {
			batch.end();
		}
		if (renderer != null) {
			renderer.end();
		}
	}

}
