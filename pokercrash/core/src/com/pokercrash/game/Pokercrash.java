package com.pokercrash.game;

import java.util.HashMap;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokercrash.game.model.Model;

public class Pokercrash extends Game {
	public static final String TITLE = "Texas Holdem poker", VERSION = "0.0.primera";
	SpriteBatch batch;
	Texture img;
	private Screen lobby;
	private HashMap<Integer,TableScreen> tableScreens= new HashMap<Integer, TableScreen>();
	private Model model;


	@Override
	public void create() {
		Assets.load();
		model = new Model();
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
			tableScreens.put(idGameTable, new TableScreen(this));
		}
		setScreen(tableScreens.get(idGameTable));
	}

	public Model getModel() {
		return model;
	}

}
