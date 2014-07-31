package com.pokercrash.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static TextureAtlas atlas;
	public static TextureRegion table_background;
	public static TextureRegion dealer;
	public static TextureRegion card_0_0;
	public static TextureRegion player;
	public static TextureRegion botonDown;
	public static TextureRegion botonUp;
	public static BitmapFont whiteFont;
	public static BitmapFont blackFont;
	
	
	public static void load() {
		atlas = new TextureAtlas("images/pokercrash.pack");
		table_background = atlas.findRegion("tableBackGround");
		dealer = atlas.findRegion("dealer");
		card_0_0 = atlas.findRegion("card-0-0");
		player = atlas.findRegion("player");
		botonUp = atlas.findRegion("boton_Up");
		botonDown = atlas.findRegion("boton_Down");
		whiteFont = new BitmapFont(Gdx.files.internal("fnt/comic_white.fnt"),false);
	    blackFont = new BitmapFont(Gdx.files.internal("fnt/comic_black.fnt"),false);

	}

	public static void dispose() {
		atlas.dispose();
	}
}
