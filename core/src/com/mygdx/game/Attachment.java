package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Attachment extends Entity {

    Entity start, end;

    Attachment(float x, float y, float width, float height, World world) {
        super(x, y, width, height, world);
    }


}
