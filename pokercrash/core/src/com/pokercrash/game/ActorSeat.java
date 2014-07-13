package com.pokercrash.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.pokercrash.game.model.Seat;

public class ActorSeat extends Actor {

	private TextureRegion textureRegion;
	private String playerName ="Lugar Vacio";
	private String stack="$ 00.00";
	boolean empty= true;
	private int seatPos;

	public int getSeatPos() {
		return seatPos;
	}


	public ActorSeat(int seatPos, TextureRegion textureRegion) {
		this.seatPos = seatPos;
		this.textureRegion = textureRegion;
		setBounds(0, 0, textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
	}
	

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
	
		if (!empty) {
			batch.draw(textureRegion, getX(), getY());
			Assets.whiteFont.draw(batch,playerName, getX()+5, getY()+30);
			Assets.whiteFont.draw(batch, stack, getX()+5, getY());
		}
	
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


	public void updateModel(Seat seat) {
		empty = seat.empty;
		if (!empty) {
			playerName = seat.playerName;
			stack = Float.toString(seat.stack);
		}

		
	}

}
