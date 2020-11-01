package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.awt.*;

public class Debug {

    ShapeDrawer shapeDrawer = new ShapeDrawer(GameScreen.game.batch, new TextureRegion(new Texture("shapeDrawerTextureMap.png")));

    float mouseX = (Gdx.input.getX())*(16f/AnythingEvolver.WINDOW_WIDTH);
    float mouseY = (AnythingEvolver.WINDOW_HEIGHT - Gdx.input.getY())*(9f*AnythingEvolver.WINDOW_HEIGHT);

    void draw(float dt) {
        shapeDrawer.setColor(Color.MAGENTA);
        shapeDrawer.circle(mouseX, mouseY, 0.1f, 0.1f);
    }

}
