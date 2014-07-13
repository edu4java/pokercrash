package com.pokercrash.game;

import java.util.HashMap;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokercrash.game.model.Services;

public class Pokercrash extends Game {
	public static final String TITLE = "Texas Holdem poker", VERSION = "0.0.primera";
	SpriteBatch batch;
	Texture img;
	private Screen lobby;
	private HashMap<Integer,TableScreen> tableScreens= new HashMap<Integer, TableScreen>();
	private Services service;


	@Override
	public void create() {
		Assets.load();
		service = new Services();
		setScreen(new Login(this));
	}

	public void gotoLobby() {
		if (lobby == null) {
			lobby = new Lobby(this);
		}
		setScreen(lobby);
	}

	public void gotoMesa(int idGameTable) {
		if (!tableScreens.containsKey(idGameTable)) {
			tableScreens.put(idGameTable, new TableScreen(this,idGameTable));
		}
		setScreen(tableScreens.get(idGameTable));
	}
	

	public Services getService() {
		return service;
	}

}
