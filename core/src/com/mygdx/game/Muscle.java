package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.GearJointDef;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;

public class Muscle extends Attachment {

    float baseLength;

    Muscle(Entity start, Entity end, float width, World world) {
        super(0, 0, width, 1, world);
        this.start = start;
        this.end = end;

        baseLength = (float)Math.sqrt(Math.pow(start.position.x - end.position.x, 2) + Math.pow(start.position.y - end.position.y, 2));

        PrismaticJointDef prismaticJointDef = new PrismaticJointDef();
        prismaticJointDef.bodyA = start.body;
        prismaticJointDef.localAnchorA.set(start.position);
        prismaticJointDef.bodyB = end.body;
        prismaticJointDef.upperTranslation = 0.1f;
        prismaticJointDef.lowerTranslation = 0.01f;
        prismaticJointDef.localAnchorB.set(end.position);
        prismaticJointDef.initialize(start.body, end.body, start.position, end.position);
        prismaticJointDef.collideConnected = true;

        /*GearJointDef gearJointDef = new GearJointDef();
        gearJointDef.bodyA = start.body;
        gearJointDef.joint1 =
        gearJointDef.bodyB = end.body;
        gearJointDef.joint2 =
        gea
        gearJointDef.collideConnected = true;
*/
        world.createJoint(prismaticJointDef);
    }

    @Override
    void draw() {

        float currentDistance = (float)Math.sqrt(Math.pow(start.position.x - end.position.x, 2) + Math.pow(start.position.y - end.position.y, 2));
        float flex = baseLength / currentDistance;

        shapeDrawer.setColor(Color.MAROON);

        shapeDrawer.line(start.position, end.position, 0.1f*flex);

    }

    @Override
    void update(float dt) {
        //(float) Math.sqrt(Math.pow(start.position.x + end.position.x, 2) + Math.pow(start.position.y + end.position.y, 2))
    }
}
