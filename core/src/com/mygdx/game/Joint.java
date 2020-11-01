package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.util.ArrayList;

public class Joint extends Entity {

    ArrayList<Attachment> attachments;

    Joint(float x, float y, float radius, World world) {
        super(x, y, radius, 1, world);
    }

    @Override
    void draw() {

        shapeDrawer.setColor(Color.GRAY);
        shapeDrawer.filledCircle(position.x, position.y, dimensions.x);

    }

    @Override
    void update(float dt) {
        position.x = body.getPosition().x;
        position.y = body.getPosition().y;
    }

}
