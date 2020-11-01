package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.util.ArrayList;

public class AnythingEvolver extends Game {
	SpriteBatch batch;
	Texture img;



	public static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int WINDOW_HEIGHT = (int)(Toolkit.getDefaultToolkit().getScreenSize().height * 1.5);

	public static final int VIEWPORT_WIDTH = 64;
	public static final int VIEWPORT_HEIGHT = 36;

	GameScreen gameScreen;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		gameScreen = new GameScreen(this);
		this.setScreen(gameScreen);
	}

	@Override
	public void render () {
		super.render();
		/*Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
	}
	
	/*@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}*/
}
