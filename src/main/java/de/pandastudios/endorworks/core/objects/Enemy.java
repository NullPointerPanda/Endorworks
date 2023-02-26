package de.pandastudios.endorworks.core.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.pandastudios.endorworks.utility.RenderUtilDAO;

public class Enemy implements GameObject{
	
	private Texture texture;

	private float x;
	private float y;

	public Enemy(final float x, final float y, final Texture texture) {
		this.x = x;
		this.y = y;
		this.texture = texture;
	}

	@Override
	public void update() {
		
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
