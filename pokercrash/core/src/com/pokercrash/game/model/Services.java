package com.pokercrash.game.model;

import java.util.ArrayList;

public class Services implements IService {
	
	User user;
	private int seatPos;
	ArrayList<TableChangeListener> tableChangeListeners = new ArrayList<TableChangeListener>();

	
	
	/* (non-Javadoc)
	 * @see com.pokercrash.game.model.IService#addTableChangeListener(com.pokercrash.game.model.TableChangeListener)
	 */
	@Override
	public void addTableChangeListener(TableChangeListener tableChangeListener) {
		tableChangeListeners.add(tableChangeListener);
	}
	
	/* (non-Javadoc)
	 * @see com.pokercrash.game.model.IService#removeTableChangeListener(com.pokercrash.game.model.TableChangeListener)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see com.pokercrash.game.model.IService#getGameTables()
	 */
	@Override
	public GameTable[] getGameTables() {
		GameTable[] gameTables = new GameTable[4];
		for (int j = 0; j < gameTables.length; j++) {
			gameTables[j] = new GameTable(j + ". mesa blablabla pito q fauta ", j);
		}
		return gameTables;
	}

	/* (non-Javadoc)
	 * @see com.pokercrash.game.model.IService#getUser()
	 */
	@Override
	public User getUser() {
		return user;
	}

	/* (non-Javadoc)
	 * @see com.pokercrash.game.model.IService#tryReservedSeat(int, int)
	 */
	@Override
	public boolean tryReservedSeat(int idGameTable, int seatPos) {
		this.seatPos = seatPos;
		getGameTable(idGameTable).getSeats().get(seatPos).empty= false;
		getGameTable(idGameTable).getSeats().get(seatPos).playerName = getUser().getNickName(); 
		
		
		modelChange();
		
		
		return true;
	}

	/* (non-Javadoc)
	 * @see com.pokercrash.game.model.IService#trySeat(int, java.lang.String)
	 */
	@Override
	public boolean trySeat(int idGameTable, String money) {
		
		getGameTable(idGameTable).getSeats().get(seatPos).stack = Float.valueOf(money);
		modelChange();
		
		return true;
	}


	/* (non-Javadoc)
	 * @see com.pokercrash.game.model.IService#cancelSeat(int, int)
	 */
	@Override
	public void cancelSeat(int idGameTable, int seatPos) {
		// TODO Auto-generated method stub
	}

	GameTable mockTable = new GameTable("fsdfsdfsd",3);
	/* (non-Javadoc)
	 * @see com.pokercrash.game.model.IService#getGameTable(int)
	 */
	@Override
	public GameTable getGameTable(int idGameTable) {

		return mockTable;
	}

	/* (non-Javadoc)
	 * @see com.pokercrash.game.model.IService#validateUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean validateUser(String nickname, String password) {
		this.user = new User(nickname, password, 100);
		return true;
	}
	
	

}
