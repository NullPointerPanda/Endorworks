package de.pandastudios.endorworks.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MenuScreen extends ScreenAdapter {

	private Stage stage;
	private Skin skin;

	public MenuScreen() {

	}

	@Override
	public void show() {
		stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
		skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
//		arcadeSkin.addRegions(new TextureAtlas(Gdx.files.internal("skin/arcade-ui.atlas")));
//		arcadeSkin.load(Gdx.files.internal("skin/arcade-ui.json"));

		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);

		TextButton button1 = new TextButton("Start Game", skin);
		TextButton button2 = new TextButton("Options", skin);

		button1.setPosition(50, 100);
		button2.setPosition(50, 50);

		Label label = new Label("Menü", skin);

		button1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("BTN 1");
			}
		});

		button2.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("BTN 2");
			}
		});

		table.add(label).colspan(2).center().padBottom(20);
		table.row();
		table.add(button1).padRight(10);
		table.add(button2);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();
		stage.draw();
	}
	
	@Override
	public void hide() {
		stage.dispose();
		skin.dispose();
	}
}
