package com.pokercrash.game.model;

import java.util.ArrayList;

public class Services {
	
	User user;
	private int seatPos;
	ArrayList<TableChangeListener> tableChangeListeners = new ArrayList<TableChangeListener>();

	
	
	public void addTableChangeListener(TableChangeListener tableChangeListener) {
		tableChangeListeners.add(tableChangeListener);
	}
	
	public void removeTableChangeListener(TableChangeListener tableChangeListener) {
		tableChangeListeners.remove(tableChangeListener);
	}
	
	/**
	 * lo llaman desde el server para informar que cambio el modelo
	 */
	public void modelChange() {
		for (TableChangeListener tableChangeListener : tableChangeListeners) {
			tableChangeListener.onChange();
		}
	}

	public GameTable[] getGameTables() {
		GameTable[] gameTables = new GameTable[4];
		for (int j = 0; j < gameTables.length; j++) {
			gameTables[j] = new GameTable(j + ". mesa blablabla pito q fauta ", j);
		}
		return gameTables;
	}

	public User getUser() {
		return new User("Juancho", "pass", 100);
	}

	/**
	 * quedas sentado pero no jugando (estado reserved por tiempo limitado)
	 * 
	 * @param seatPos
	 * @param i
	 * @return true si queda en estado reserved
	 */
	public boolean tryReservedSeat(int idGameTable, int seatPos) {
		this.seatPos = seatPos;
		getGameTable(idGameTable).getSeats().get(seatPos).empty= false;
		getGameTable(idGameTable).getSeats().get(seatPos).playerName = getUser().getNickName(); 
		
		
		modelChange();
		
		
		return true;
	}

	/**
	 * trata de sentar al usuario con el dinero
	 * 
	 * @param money
	 * @return
	 */
	public boolean trySeat(int idGameTable, String money) {
		
		getGameTable(idGameTable).getSeats().get(seatPos).stack = Float.valueOf(money);
		modelChange();
		
		return true;
	}


	/**
	 * cancelar la reserva o deja el asiento libre 
	 * @param idGameTable
	 * @param seatPos
	 */
	public void cancelSeat(int idGameTable, int seatPos) {
		// TODO Auto-generated method stub
	}

	GameTable mockTable = new GameTable("fsdfsdfsd",3);
	public GameTable getGameTable(int idGameTable) {

		return mockTable;
	}
	
	

}
