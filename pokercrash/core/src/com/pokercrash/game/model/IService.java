package com.pokercrash.game.model;

public interface IService {

	 void addTableChangeListener(TableChangeListener tableChangeListener);

	 void removeTableChangeListener(TableChangeListener tableChangeListener);

	 GameTable[] getGameTables();

	 User getUser();

	/**
	 * quedas sentado pero no jugando (estado reserved por tiempo limitado)
	 * 
	 * @param seatPos
	 * @param i
	 * @return true si queda en estado reserved
	 */
	 boolean tryReservedSeat(int idGameTable, int seatPos);

	/**
	 * trata de sentar al usuario con el dinero
	 * 
	 * @param money
	 * @return
	 */
	 boolean trySeat(int idGameTable, String money);

	/**
	 * cancelar la reserva o deja el asiento libre 
	 * @param idGameTable
	 * @param seatPos
	 */
	 void cancelSeat(int idGameTable, int seatPos);

	 GameTable getGameTable(int idGameTable);

	 boolean validateUser(String nickname, String password);

}