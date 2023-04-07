package com.skilldistillery.blackjack.entities;

public enum Suit {
	
	HEARTS("Hearts"),
	SPADES("Spades"),
	CLUBS("Clubs"),
	DIAMONDS("Diamonds");
	
	final private String suit;
	
	Suit(String suitType) {
		this.suit = suitType;
	}

	@Override
	public String toString () {
		return suit;
	}
}
