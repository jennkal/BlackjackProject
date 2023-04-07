package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>();
	
	public Deck() {
		//.values, all values in Rank
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		
		//generate 52 cards in deck
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card card = new Card(suit, rank);
				//add card to deck
				deck.add(card);
			}
		}
	}
	
//	public List<Card> getDeck() {
//		return deck;
//	}
	
	public void shuffleDeck() {
		//shuffle deck, like in NBA Draft pick app.
		//good old Collections.shuffle to rearrange the arraylist.
		Collections.shuffle(deck);
	}
	
	//returns a card
	public Card dealCard() {
		//get and remove dealt card from deck.
		Card dealtCard = deck.remove(0);
		return dealtCard;
	}

	public int checkDeckSize() {
		//returns the number of cards still in deck.
		return deck.size();
	}
	
	
}
