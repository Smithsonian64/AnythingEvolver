package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJoint;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.GearJointDef;

import java.awt.*;

public class Bone extends Attachment {

    Bone(Entity start, Entity end, float width, World world) {
        super(0, 0, width, 1, world);
        this.start = start;
        this.end = end;

        DistanceJointDef distanceJointDef = new DistanceJointDef();
        distanceJointDef.bodyA = start.body;
        distanceJointDef.localAnchorA.set(start.position);
        distanceJointDef.bodyB = end.body;
        distanceJointDef.localAnchorB.set(end.position);
        distanceJointDef.initialize(start.body, end.body, start.position, end.position);
        distanceJointDef.collideConnected = true;

        world.createJoint(distanceJointDef);

    }

    @Override
    void draw() {
        shapeDrawer.setColor(Color.WHITE);
        shapeDrawer.line(start.position, end.position, dimensions.x);
    }

    @Override
    void update(float dt) {

    }
}
