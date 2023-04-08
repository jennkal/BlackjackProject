package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	protected Hand hand = new BlackjackHand();
	
	//Both a dealer and a player has-a Hand (they each have their own Hand field for their own hand object)

	public Player () {
		super();
	}

	//get cards being dealt by dealer


	@Override
	public String toString() {
		return "Player hand:" + hand;
		//print hand and value
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	
}
