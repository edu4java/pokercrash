package com.pokercrash.game.model;

import java.util.ArrayList;

import com.pokercrash.game.ActorSeat;

public class GameTable {

	private String string;
	private int id;
	private float minStack=10f;
	private ArrayList<Seat> seats = new ArrayList<Seat>();


	public GameTable(String string, int i) {
		
		seats.add(new Seat("ripa", 22f, false));
		seats.add(new Seat("dario", 55f, false));
		seats.add(new Seat("juan", 33f, false));
		seats.add(new Seat("edu", 93f, false));
		seats.add(new Seat("xx", 0, true));
		seats.add(new Seat("xx", 0, true));
		seats.add(new Seat("xx", 0, true));
		seats.add(new Seat("xx", 0, true));
		seats.add(new Seat("xx", 0, true));
		
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

	public float getMinStack() {
		return minStack;
	}

	public ArrayList<Seat> getSeats() {
		return this.seats ;	
	}

}
