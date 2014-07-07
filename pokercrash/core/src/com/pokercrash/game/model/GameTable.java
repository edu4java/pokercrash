package com.pokercrash.game.model;

public class GameTable {

	private String string;
	private int id;


	public GameTable(String string, int i) {
		this.string = string;
		this.id = i;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return string;
	}

}
