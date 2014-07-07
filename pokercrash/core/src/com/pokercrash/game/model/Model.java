package com.pokercrash.game.model;

public class Model {
	public GameTable[] getGameTable() {
		GameTable[] r = new GameTable[4];
		for (int j = 0; j < r.length; j++) {
			r[j] = new GameTable(j + ". mesa blablabla pito q fauta ", j);
		}
		return r;
	}
}
