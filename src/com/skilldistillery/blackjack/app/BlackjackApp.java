package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Hand;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

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
		// shuffle the deck
		Player player = new Player();
		Dealer dealer = new Dealer();
		dealer.shuffle();
		// System.out.println(dealer.getDeck().checkDeckSize());
		dealer.getDeck().dealCard(player.getHand());
		dealer.getDeck().dealCard(dealer.getHand());
		dealer.getDeck().dealCard(player.getHand());
		System.out.println("Dealer card facing up " + dealer.getHand().getHandValue(dealer.getHand()));

		dealer.getDeck().dealCard(dealer.getHand());
		System.out.println("Player cards: " + player.getHand().getHandValue(player.getHand()));

		// check if blackJack
		// if player is blackjack player wins and game over
		BlackjackHand hand = new BlackjackHand();

		if (hand.isBlackjack(player.getHand()) == true) {
			System.out.println("Yay Blackjack");
		} else {
			// if not continue
			int input = 0;
			Scanner sc = new Scanner(System.in);

			System.out.println("Would you like to Hit or Stand?");
			System.out.println("Enter 1 for Hit");
			System.out.println("Enter 2 for Stand");
			input = sc.nextInt();

			sc.nextLine();
			if (input == 1) {
				dealer.getDeck().dealCard(player.getHand());
				System.out.println("Player cards: " + player.getHand().getHandValue(player.getHand()));
			} else if (input == 2) {
				// once player stands dealers turn, shows both cards and rule of 17.

				// if dealer blackjack dealer wins
				// if < 17 dealer deals himself card till Over 17, bust, or blackjack
				// if > 17 dealer 'stands' and compare to player.
				// winner or tie

				System.out.println("Dealer Cards: " + dealer.getHand().getHandValue(dealer.getHand()));
			} else {
				System.out.println("Please Enter Valid Input");
			}
		}

	}
}
