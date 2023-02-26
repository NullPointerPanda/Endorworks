package de.pandastudios.endorworks.core.objects;

import de.pandastudios.endorworks.utility.RenderUtilDAO;

public interface GameObject {

	public abstract void update();
	
	public abstract void render(RenderUtilDAO renderUtilDAO);
	
	public abstract void dispose();
}
