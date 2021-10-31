package com.skilldistillery.cards;

import java.util.Scanner;

public class BlackJackApp {

	Player user = new Player();
	Dealer dealer = new Dealer();
	Scanner userInput = new Scanner(System.in);
	// run the deck

	public static void main(String[] args) {
		BlackJackApp bja = new BlackJackApp();

		bja.runMenu();

	}

	public void runMenu() {

		System.out.println("Welcome to Blackjack!");

		dealer.shuffleDeck();

		// make loop
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

//		boolean noWinnersYet;
//		while (noWinnersYet = true) {
		// tell user what their total hand value is
		System.out.print("Here is your current hand total:  ");
		user.printValue();
//			
//		System.err.println("Dealers visible card:");
//		dealer.hand.showTopCard();
//		System.out.println();
		// let user decide to hit or stay

		boolean userDidntBust;
		while (userDidntBust = true) {
			if (user.isIt21()) {
				System.out.println("You have 21! You win!");
				userDidntBust = false;
				break;
			}
			System.out.print("Would you like to hit or stay?  ");
			String input = userInput.next();
			if (input.equalsIgnoreCase("hit")) {

				card = dealer.dealCard();
				user.addCardToHand(card);
				user.printHand();
				user.printValue();

				// if user hits and they go over 21 tell them
				if (user.isItOver21()) {
					System.out.println("You have gone over 21 you lose!");
					userDidntBust = false;
					break;
				} else if (user.isIt21()) {
					System.out.println("You have 21! You win!");
					// userDidntBust = false;
					userDidntBust = false;
					break;
				}

//				System.out.print("Would you like to hit or stay?  ");
//				input = userInput.next();

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
			}else if (dealer.isLessThan17()) {
				System.out.println("Dealer will draw another card");
				card = dealer.dealCard();
				dealer.addCardToHand(card);
				dealer.printHand();
				dealer.printValue();
				if (dealer.isItOver21()) {
					System.out.println("Dealer has gone over 21! You win!");
					userDidntBust = false;
					break;
				} else if (dealer.isIt21()) {
					System.out.println("Dealer has 21! You lose!");
					userDidntBust = false;
					break;
				}

			} else if (!dealer.isLessThan17()) {
				break;
			}
		}

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
