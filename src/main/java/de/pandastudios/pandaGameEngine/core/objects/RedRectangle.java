package de.pandastudios.pandaGameEngine.core.objects;

import com.badlogic.gdx.graphics.Color;

import de.pandastudios.pandaGameEngine.utility.RenderUtilDAO;

public class RedRectangle implements GameObject {

	private float width;
	private float height;
	private float x;
	private float y;

	public RedRectangle(float x, float y, float width, float height) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(RenderUtilDAO renderUtilDAO) {
		renderUtilDAO.getRenderer().setColor(Color.RED);
		renderUtilDAO.getRenderer().rect(x, y, width, height);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
