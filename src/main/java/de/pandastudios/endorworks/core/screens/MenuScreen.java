package de.pandastudios.endorworks.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

import de.pandastudios.endorworks.core.EndorworksGame;

public class MenuScreen extends ScreenAdapter {
	private Texture background;
	private SpriteBatch batch;

	private Image img;

	private Stage stage;
	private Skin skin;
	private float alpha = 1f; // initial alpha value
	private boolean temp;

	public MenuScreen() {

	}

	@Override
	public void show() {
		stage = new Stage(new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
		skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
//		arcadeSkin.addRegions(new TextureAtlas(Gdx.files.internal("skin/arcade-ui.atlas")));
//		arcadeSkin.load(Gdx.files.internal("skin/arcade-ui.json"));

		batch = new SpriteBatch();
		background = new Texture(Gdx.files.internal("splash.png"));

		temp = false;

		Gdx.input.setInputProcessor(stage);

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
				temp = true;
				stage.addAction(Actions.sequence(//
						Actions.fadeOut(1), //
						Actions.run(() -> {//
							EndorworksGame.INSTANCE.setScreen(new GameScreen());
						})//
				));
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
		Gdx.gl.glClearColor(1, 1, 1, alpha);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();

		batch.setBlendFunction(Gdx.gl.GL_SRC_ALPHA, Gdx.gl.GL_ONE_MINUS_SRC_ALPHA);
		batch.enableBlending();

		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();

		stage.draw();

		if (temp) {
			batch.setColor(1.0f, 1.0f, 1.0f, alpha);
			alpha -= delta * 0.5f;
			if (alpha < 0) {
				alpha = 0;
			}
		}

	}

	@Override
	public void hide() {
		stage.dispose();
		skin.dispose();
	}
}
