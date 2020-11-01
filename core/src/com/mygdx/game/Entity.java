package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import space.earlygrey.shapedrawer.ShapeDrawer;

public abstract class Entity {

    ShapeDrawer shapeDrawer;
    World world;
    Vector2 position;
    Vector2 dimensions;

    Body body;
    BodyDef bodyDef;
    Shape shape;
    FixtureDef fixtureDef;
    Fixture fixture;

    Entity(float x, float y, float width, float height, World world) {
        this.position = new Vector2(x, y);
        this.dimensions = new Vector2(width, height);
        this.world = world;

        bodyDef = new BodyDef();


        bodyDef.type = BodyDef.BodyType.DynamicBody;
        if(this instanceof Platform) bodyDef.type = BodyDef.BodyType.StaticBody;

        bodyDef.position.set(x, y);

        body = world.createBody(bodyDef);

        if(this instanceof Joint) {
            shape = new CircleShape();
            shape.setRadius(dimensions.x);
        } else {
            PolygonShape pShape = new PolygonShape();
            pShape.setAsBox(width, height);
            shape = pShape;
        }




        fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0;
        fixture = body.createFixture(fixtureDef);

        shape.dispose();


        shapeDrawer = new ShapeDrawer(GameScreen.game.batch, new TextureRegion(new Texture("shapeDrawerTextureMap.png")));
    }

    abstract void draw();

    abstract void update(float dt);

    void setDensity(float density) {
        this.fixture.setDensity(density);
    }



}
