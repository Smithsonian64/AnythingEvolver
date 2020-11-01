package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.World;

public class Platform extends Entity {

    Platform(float x, float y, float width, float height, World world) {
        super(x, y, width, height, world);

    }

    @Override
    void draw() {
        shapeDrawer.setColor(Color.LIME);
        shapeDrawer.rectangle(position.x, position.y, dimensions.x, dimensions.y, 0.1f);
    }

    @Override
    void update(float dt) {
        position.x = body.getPosition().x;
        position.y = body.getPosition().y;
    }
}
