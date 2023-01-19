package com.badlogic.TankStars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class TanksStars extends Game {

	public SpriteBatch batch;
	public BitmapFont font;
	//public ShapeRenderer shape;

	public void create() {
		batch = new SpriteBatch();
		//shape= new ShapeRenderer();
		font = new BitmapFont(); // use libGDX's default Arial font
		this.setScreen(new LoadingScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}

}
