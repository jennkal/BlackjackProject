package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {
	
	private Deck deck;
	//inharets blackjackhand from player
	
	public Dealer () {
		super();
		//new deck per new game
		deck = new Deck();
		
	}
	//deck
	public void shuffle() {
		deck.shuffleDeck();
	}
	//deal to hands
	public void dealCards(Hand hand) {
		deck.dealCard();
	}
	
	public void showTopCard() {
		//gets the top card to show in dealers hand
		hand.getCards().get(1);
	}
	
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	//method for dealers turn
	

	//inharet everything player can do
}
