package com.quickjamone;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by libri on 11/19/16.
 */
public class Obstacle {

    public final String[] obstacleTextures = {"rock.png", "tree.png"};
    private Sprite sprite;

    public Obstacle() {
        String path = obstacleTextures[(int)(Math.random() * obstacleTextures.length)];

        sprite = new Sprite(new Texture(path));
        
        sprite.setSize(32, 32);
        
        sprite.setY(-50);
        sprite.setX((float) (Math.random()*768));
    }

    public Sprite getSprite() {
        return sprite;
    }

    public float updatePos(float snowballSize, float dt) {
        sprite.setY(sprite.getY() + ((200 + snowballSize) * dt));
        return sprite.getY();
    }
}
