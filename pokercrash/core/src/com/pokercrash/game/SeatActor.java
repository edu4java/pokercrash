package com.pokercrash.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

public class SeatActor extends Actor {

	private TextureRegion textureRegion;
	private String playerName ="Lugar Vacio";
	private String stack="$ 00.00";
	private boolean empty= true;

	public SeatActor(TextureRegion textureRegion) {
		this.textureRegion = textureRegion;

	}
	

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(textureRegion, getX(), getY());
		Assets.whiteFont.draw(batch,playerName, getX()+5, getY()+30);
		Assets.whiteFont.draw(batch, stack, getX()+5, getY());
//		if (!empty) {
//			batch.draw(textureRegion, getX(), getY());
//			Assets.whiteFont.draw(batch,playerName, getX()+5, getY()+30);
//			Assets.whiteFont.draw(batch, stack, getX()+5, getY());
//		}
	
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	
}
