package com.quickjamone;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by libri on 11/19/16.
 */
public class Obstacle {

    public final String[] obstacleTextures = {""};
    private Sprite sprite;

    public Obstacle() {
        String path = obstacleTextures[(int)(Math.random() * obstacleTextures.length)];

        sprite = new Sprite(new Texture(path));
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void updatePos(float snowballSize, float dt) {
        sprite.setY(sprite.getY() - ((200 + snowballSize) * dt));
    }
}
