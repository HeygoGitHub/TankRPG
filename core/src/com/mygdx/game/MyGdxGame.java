package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private PlayerTank myTank;
    private Bullet bullet;                        // Было бы неплохо сделать эмиттер

    public Bullet getBullet() {
        return bullet;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        myTank = new PlayerTank(this);
        bullet = new Bullet();
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(0, 0.6f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        myTank.render(batch);
        if (bullet.isActive()) {
            bullet.render(batch);
        }
        batch.end();
    }

    public void update(float dt) {
        myTank.update(dt);
        if (bullet.isActive()) {
            bullet.update(dt);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
