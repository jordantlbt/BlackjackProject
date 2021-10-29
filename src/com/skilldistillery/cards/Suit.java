package com.skilldistillery.cards;

public enum Suit {
	
	HEARTS("\u2665\uFE0F"),
	SPADES("\u2660\uFE0F"),
	CLUBS("\u2663\uFE0F"),
	DIAMONDS("\u2666\uFE0F");
	
	private final String name;
	private Suit(String n){
		this.name = n;
	}
	
	@Override 
	public String toString() {
		return name;
	}
}
