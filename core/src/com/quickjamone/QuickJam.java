package com.quickjamone;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class QuickJam extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite snowball;
	int snowballSize;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		snowballSize = 16;
		snowball = new Sprite(new Texture("snowball.png"));
		snowball.setSize(snowballSize, snowballSize);
		snowball.setPosition(768/2-snowballSize/2, 380-snowballSize/2);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		snowball.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
