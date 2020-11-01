package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.AnythingEvolver;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = AnythingEvolver.WINDOW_WIDTH * 2;
		config.height = AnythingEvolver.WINDOW_HEIGHT * 2;
		config.resizable = false;
		config.fullscreen = true;
		config.vSyncEnabled = true;
		new LwjglApplication(new AnythingEvolver(), config);
	}
}
