package com.quickjamone;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class QuickJam extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite snowball;
	
	float snowballSize;
	float snowballGrowth;
	
	
	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		snowballSize = 16;
		snowballGrowth = 4;
		
		snowball = new Sprite(new Texture("snowball.png"));
		snowball.setSize(snowballSize, snowballSize);
		snowball.setPosition((768/2-snowballSize/2), (380-snowballSize/2));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		float dt = Gdx.graphics.getDeltaTime();
		
		snowballSize = snowballSize + (snowballGrowth * dt);
		
		snowball.setSize(snowballSize, snowballSize);
		snowball.setPosition(snowball.getX()-(snowballGrowth * dt)/2, (380-snowballSize/2));
		
		/*
		for (Obstacle o : obstacles) {
			o.updatePos(snowballSize, dt);
		}
		*/
		
		batch.begin();
		
		/*
		for (Obstacle o : obstacles) {
			o.getSprite().draw(batch);
		}
		*/
		
		snowball.draw(batch);
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
