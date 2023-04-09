package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	// can the hand have the deck of cards?
	private List<Card> cards = new ArrayList<>();

	public Hand() {
	}

//	public Hand(List<Card> card) {
//		
//	}

	// card delt to players hands via hand
	public void addCard(Card card) {
		cards.add(card);

	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	// get the value of the hand adding together.
	public abstract int getHandValue(Hand hand);

	// print out handValue
	public String toString() {

		return "Card" ;
	}

	// clear hand
	public void clear(Hand hand) {
		
		cards.removeAll(cards);
 	}
	

}
