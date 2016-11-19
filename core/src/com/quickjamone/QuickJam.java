package com.quickjamone;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;

public class QuickJam extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Sprite snowball;
	
	float snowballSize;
	float snowballGrowth;
	
	float obstaclesPerSecond = 5;
	
	float timeToObstacle;
	float currentTime;
	
	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		snowballSize = 16;
		snowballGrowth = 4;
		
		timeToObstacle = 1 / obstaclesPerSecond;
		currentTime = 0;
		
		snowball = new Sprite(new Texture("snowball.png"));
		snowball.setSize(snowballSize, snowballSize);
		snowball.setPosition((768/2-snowballSize/2), (380-snowballSize/2));
		
		Gdx.input.setInputProcessor(this);
	}
	
	public void reset() {
		snowballSize = 16;
		snowballGrowth = 4;
		
		obstacles = new ArrayList<Obstacle>();
		
		snowball.setSize(snowballSize, snowballSize);
		snowball.setPosition((768/2-snowballSize/2), (380-snowballSize/2));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		float dt = Gdx.graphics.getDeltaTime();
		
		currentTime += dt;
		
		if (currentTime > timeToObstacle) {
			obstacles.add(new Obstacle());
			currentTime -= timeToObstacle;
		}
		
		snowballSize = snowballSize + (snowballGrowth * dt);
		
		snowball.setSize(snowballSize, snowballSize);
		snowball.setPosition(snowball.getX()-(snowballGrowth * dt)/2, (380-snowballSize/2));
		
		ArrayList<Obstacle> toRemove = new ArrayList<Obstacle>();
		
		for (Obstacle o : obstacles) {
			if (o.updatePos(snowballSize, dt) > 775) {
				toRemove.add(o);
			}
			if (Intersector.overlaps(snowball.getBoundingRectangle(), o.getSprite().getBoundingRectangle())) {
				reset();
			}
		}
		
		for (Obstacle o : toRemove) {
			obstacles.remove(o);
		}
		
		batch.begin();
		
		for (Obstacle o : obstacles) {
			o.getSprite().draw(batch);
		}
		
		snowball.draw(batch);
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		System.out.println(keycode);
		if (keycode == Keys.LEFT) {
			snowball.setX(Math.max(snowball.getX()-16, 0));
		}
		if (keycode == Keys.RIGHT) {
			snowball.setX(Math.min(snowball.getX()+16, 576));
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
