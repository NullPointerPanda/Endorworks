package de.pandastudios.endorworks.core.utility;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class InputSystem implements InputProcessor {
	private List<InputObserver> observers = new ArrayList<>();

	public void addObserver(InputObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(InputObserver observer) {
		observers.remove(observer);
	}

	private void notifyObservers(int keycode) {
		for (InputObserver observer : observers) {
			observer.onNotify(keycode);
		}
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.W || keycode == Input.Keys.S || keycode == Input.Keys.A || keycode == Input.Keys.D
				|| keycode == Input.Keys.T || keycode == Input.Keys.Z) {
			notifyObservers(keycode);
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
