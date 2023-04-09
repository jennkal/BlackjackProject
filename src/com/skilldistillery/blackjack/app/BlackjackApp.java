package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Hand;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {
	private Player player = new Player();
	private Dealer dealer = new Dealer();
	private BlackjackHand hand = new BlackjackHand();

	public static void main(String[] args) {
		BlackjackApp bja = new BlackjackApp();
		bja.run();
	}

	public void run() {

		menu();
	}

	public void menu() {

		int input = 0;
		Scanner kb = new Scanner(System.in);

		System.out.println("Would you like to play Blackjack?");
		System.out.println("Enter 1 for Yes");
		System.out.println("Enter 2 for No");
		input = kb.nextInt();

		kb.nextLine();
		if (input == 1) {
			play();
		} else if (input == 2) {
			System.out.println("Ta Ta For Now");
		} else {
			System.out.println("Wrong! Bad Llama, enter valid input.");
		}
	}

	public void play() {

		dealer.getHand().clear(hand);
		player.getHand().clear(hand);

		// shuffle the deck
		dealer.shuffle();
		// System.out.println(dealer.getDeck().checkDeckSize());
		try {
			dealer.getDeck().dealCard(player.getHand());
			dealer.getDeck().dealCard(dealer.getHand());
			dealer.getDeck().dealCard(player.getHand());
			System.out.println("Dealer card facing up " + dealer.getHand().getHandValue(dealer.getHand()));

			dealer.getDeck().dealCard(dealer.getHand());
			System.out.println("Player cards: " + player.getHand().getHandValue(player.getHand()));

			// check if blackJack
			// if player is blackjack player wins and game over

			if (hand.isBlackjack(player.getHand()) == true) {
				System.out.println("Yay Blackjack");
			} else {
				// if not continue
				keepPlaying();
			}
		} catch (Exception e) {
			System.err.println("You Gamble Too Much.");
		}

	}

	public void keepPlaying() {
		int input = 0;
		Scanner sc = new Scanner(System.in);

		while (input != 2) {
			System.out.println("Would you like to Hit or Stand?");
			System.out.println("Enter 1 for Hit");
			System.out.println("Enter 2 for Stand");
			input = sc.nextInt();

			sc.nextLine();
			if (input == 1) {
				dealer.getDeck().dealCard(player.getHand());
				// if blackjack
				if (hand.isBlackjack(player.getHand()) == true) {
					dealersTurn();
				} else if (hand.isBust(player.getHand()) == true) {
					menu();
				}
				System.out.println("Player cards: " + player.getHand().getHandValue(player.getHand()));
			} else if (input == 2) {
				dealersTurn();
			} else {
				System.out.println("Please Enter Valid Input");
			}
		}

	}

	public void dealersTurn() {
		System.out.println("Dealer Cards: " + dealer.getHand().getHandValue(dealer.getHand()));
		// if dealer has blackjack.
		if (hand.isBlackjack(dealer.getHand()) == true) {
			// check if player also blackjack
			if (hand.isBlackjack(player.getHand())) {
				System.out.println("Push/Tie");
			} else {
				System.out.println("Dealer Blackjacks, Dealer wins");
			}
		}
		while (hand.getHandValue(dealer.getHand()) < 17) {
			dealer.getDeck().dealCard(dealer.getHand());
			if (hand.isBust(dealer.getHand()) == true) {
				System.out.println("Player wins, dealer Bust");
				menu();
			}
		}
		if (hand.getHandValue(dealer.getHand()) >= 17) {
			System.out.println("Dealer Stands");
			if (hand.getHandValue(dealer.getHand()) > hand.getHandValue(player.getHand())) {
				System.out.println("Dealer wins");
				menu();
			} else if (hand.getHandValue(dealer.getHand()) < hand.getHandValue(player.getHand())) {
				System.out.println("Player wins");
				menu();
			} else if (hand.getHandValue(dealer.getHand()) == hand.getHandValue(player.getHand())) {
				System.out.println("Push/Tie");
				menu();
			}
		}
		// if dealers hand <17 hits till >=17
		// if dealers hand >=17 dealer must stand.

		// determine the winner winner chicken dinner.
	}
}
