package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	private int handValue = 0;
	// constructor
	public BlackjackHand() {
	}

	// got value from hand?
	// add logic
	@Override
	public int getHandValue(Hand hand) {
		// handValue = hand + hand
		int handValue = 0;
		for (Card card : hand.getCards()) {
			handValue += card.getValue();	
		}
		return handValue;
	}

	// checking if blackjack
	public boolean isBlackjack(Hand hand) {
		if (getHandValue(hand) == 21) {
			System.out.println("Yay Blackjack");
			return true;
		} else {
			return false;
		}
	}

	// checking if bust, over 21
	public boolean isBust(Hand hand) {
		if (getHandValue(hand) > 21) {
			System.out.println("Oh No Bust");
			return true;
		} else {
			return false;
		}
	}
}
