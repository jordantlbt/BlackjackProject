package com.skilldistillery.cards;

import java.util.Scanner;

public class BlackJackApp {

	// create a new player and a new dealer gives each its own Arraylist to add
	// cards
	// new player can call any method from the player class(which calls from the
	// hand class, which uses the deck->cards->rank->suit)
	// new dealer can use all methods from player class and extra methods from
	// dealer class
	Player user = new Player();
	Dealer dealer = new Dealer();
	Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp bja = new BlackJackApp();

		bja.runMenu();

	}

	public void runMenu() {

		System.out.println("Welcome to Blackjack!");
		// shuffle deck
		dealer.shuffleDeck();
		// deal a card to the user
		Card card = dealer.dealCard();
		user.addCardToHand(card);
		// deal a card to the dealer
		card = dealer.dealCard();
		dealer.addCardToHand(card);
		// deal another card to the user
		card = dealer.dealCard();
		user.addCardToHand(card);
		System.err.println("Your hand:");
		user.printHand();
		// deal a card to the dealer
		card = dealer.dealCard();
		dealer.addCardToHand(card);

		// tell user what their total hand value is
		System.out.print("Here is your current hand total:  ");
		user.printValue();

		// check if user already has 21
		boolean userDidntBust;
		while (userDidntBust = true) {
			if (user.isIt21()) {
				System.out.println("You have 21! You win!");
				userDidntBust = false;
				break;
			}
			// let user decide to hit or stay
			System.out.print("Would you like to hit or stay?  ");
			String input = userInput.next();
			if (input.equalsIgnoreCase("hit")) {

				card = dealer.dealCard();
				user.addCardToHand(card);
				user.printHand();
				user.printValue();

				// if user hits and they go over 21 tell them
				// if user hits and gets 21 tell them
				if (user.isItOver21()) {
					System.out.println("You have gone over 21 you lose!");
					userDidntBust = false;
					break;
				} else if (user.isIt21()) {
					System.out.println("You have 21! You win!");
					userDidntBust = false;
					break;
				}

			} else if (input.equalsIgnoreCase("Stay")) {

				break;
			}
		}

		// dealer shows his hand value

		while (userDidntBust == true) {

			System.err.println("Dealers hand:");
			dealer.printHand();
			dealer.printValue();

			if (dealer.isIt21()) {
				userDidntBust = false;
				break;
			} else if (dealer.isLessThan17()) {

				// if dealers hand is less than 17 they will draw another card
				System.out.println("Dealer will draw another card");
				card = dealer.dealCard();
				dealer.addCardToHand(card);
				dealer.printHand();
				dealer.printValue();
				if (dealer.isItOver21()) {
					// if dealer goes over 21 the user wins
					System.out.println("Dealer has gone over 21! You win!");
					userDidntBust = false;
					break;
				} else if (dealer.isIt21()) {
					// if the dealer got exactly 21 and the user has less the dealer wins
					System.out.println("Dealer has 21! You lose!");
					userDidntBust = false;
					break;
				}
				// if the dealer has 17 or more they stay
			} else if (!dealer.isLessThan17()) {
				break;
			}
		}
		// determine winner
		// if players value is higher than the dealer but less than 21 the users win
		// if the players value is less than the dealer then they lose
		// if players value and the dealers value are the exact same its a push
		if (user.totalValueOfHand() > dealer.totalValueOfHand() && user.totalValueOfHand() < 21) {
			System.out.println("Congratulations you won!");
		} else if (user.totalValueOfHand() < dealer.totalValueOfHand() && dealer.totalValueOfHand() < 21) {
			System.out.println("You lost!");
		} else if (user.totalValueOfHand() == dealer.totalValueOfHand()) {
			System.err.println("Dealers hand:");
			dealer.printHand();
			dealer.printValue();
			System.out.println("Its a push!");

		}

	}
}
