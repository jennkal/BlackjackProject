package com.skilldistillery.blackjack.test;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealerTest {

	public static void main(String[] args) {
		DealerTest dealer = new DealerTest();
		dealer.run();
	}
	
	public void run() {
		Deck deck = new Deck();
		deck.shuffleDeck();
		int numCardsInDeck = deck.checkDeckSize();
		System.out.println("Current cards in deck: " + deck.checkDeckSize());
		
		Scanner scan = new Scanner(System.in);
		System.out.println("How many cards ");
		int numCardsIWant = scan.nextInt();
		scan.nextLine();
		
		if(numCardsIWant <= numCardsInDeck) {
			
		int sumOfCards = 0;
		for(int cardNumDealt = 0; cardNumDealt < numCardsIWant; cardNumDealt++) {
			Card dealtCard = deck.dealCard();
			sumOfCards += dealtCard.getRank().getValue();
			
			System.out.println("you now have: " 
					+ dealtCard + " " 
					+ deck.checkDeckSize() 
					+ " cards left");
			
		}
		} else {
			System.out.println("Go away, you want too many cards.");
		}
		scan.close();
	}

}
