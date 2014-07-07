package com.pokercrash.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;
import com.pokercrash.game.Pokercrash;


public class DesktopLauncher {
	public static void main (String[] arg) {
		boolean rebuildAtlas=true;
		if (rebuildAtlas) {
			Settings settings = new Settings();
//			settings.maxWidth = 1024;
//			settings.maxHeight = 1024;
			settings.debug = true;
			TexturePacker2.process(settings, "tema",
			"../android/assets/images",
			"pokercrash.pack");
			}
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Pokercrash(), config);
	}
}
