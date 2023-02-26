package de.pandastudios.pandaGameEngine.core.objects;

import de.pandastudios.pandaGameEngine.utility.RenderUtilDAO;

public interface GameObject {

	public abstract void update();
	
	public abstract void render(RenderUtilDAO renderUtilDAO);
	
	public abstract void dispose();
}
