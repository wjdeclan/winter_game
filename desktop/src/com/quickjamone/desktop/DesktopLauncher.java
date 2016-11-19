package com.quickjamone.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.quickjamone.QuickJam;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Selaruse - Winter Game";
		config.width = 768;
		config.height = 576;
		new LwjglApplication(new QuickJam(), config);
	}
}
