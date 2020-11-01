package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class GameScreen implements Screen {

    public static AnythingEvolver game;
    public Stage stage;

    public World world;

    Camera camera;

    Debug debug;

    ArrayList<Entity> entities;

    GameScreen(AnythingEvolver game) {
        GameScreen.game = game;
        camera = new OrthographicCamera(AnythingEvolver.VIEWPORT_WIDTH, AnythingEvolver.VIEWPORT_HEIGHT);
        camera.position.set(AnythingEvolver.VIEWPORT_WIDTH/2f, AnythingEvolver.VIEWPORT_HEIGHT/2f, 0);
        camera.update();
        entities = new ArrayList<>();
        world = new World(new Vector2(0, -9.8f), true);
        world.setAutoClearForces(true);
        entities.add(new Joint(32f, 18f, 1f, world));
        entities.add(new Joint(16f, 9f, 1f, world));
        entities.add(new Joint(48f, 12f,1f, world));


        entities.add(new Platform(0, 0, 64, 1f, world));

        //entities.add(new Bone(entities.get(0), entities.get(1), 0.1f, world));
        //entities.add(new Bone(entities.get(1), entities.get(2), 0.1f, world));
        //entities.add(new Bone(entities.get(2), entities.get(0), 0.1f, world));
        entities.add(new Muscle(entities.get(0), entities.get(1), 0.1f, world));
        debug = new Debug();

    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float dt) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(dt);
        stage.draw();

        update(dt);



        game.batch.begin();

        for(Entity i : entities) i.draw();
        if(debug != null) debug.draw(dt);

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.end();
        stage.draw();
    }

    void update(float dt) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
           System.exit(0);
        }

        System.out.println(entities.get(0).position.x);
        System.out.println(entities.get(0).position.y);

        float mousex = (Gdx.input.getX())*(16f/AnythingEvolver.WINDOW_WIDTH);
        float mousey = (AnythingEvolver.WINDOW_HEIGHT - Gdx.input.getY())*(9f*AnythingEvolver.WINDOW_HEIGHT);
        debug.mouseX = mousex;
        debug.mouseY = mousey;

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {




            float angle = (float)Math.atan2(mousex - entities.get(0).position.x, mousey - entities.get(0).position.y);

            float x = (float)(Math.sin(angle));
            float y = (float)(Math.cos(angle));

            entities.get(0).body.applyForce(x, y, entities.get(0).position.x, entities.get(0).position.y, true);
            System.out.println(entities.get(0).body.getLinearVelocity().x);

            //entities.get(0).body.applyLinearImpulse(new Vector2(x, y), entities.get(0).position, true);
        }

        for(Entity i : entities) i.update(dt);
        world.step(Gdx.graphics.getDeltaTime(), 10, 10);
        world.clearForces();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        game.batch.dispose();
    }
}
