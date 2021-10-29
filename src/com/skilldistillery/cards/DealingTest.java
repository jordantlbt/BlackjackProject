package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DealingTest {

	public static void main(String[] args) {
		DealingTest dealing = new DealingTest();
		dealing.deal();
	}

	public void deal() {

		// make a new Deck of 52 cards
		Deck deck = new Deck();
		// shuffle the deck
		deck.shuffleCards();

		// create scanner and ask user how many cards they want
		Scanner userInput = new Scanner(System.in);
		System.out.print("How many cards would you like? ");
		// create a variable
		int howMany = userInput.nextInt();
		userInput.nextLine();
		int handTotal = 0;
		List<Card> userHand = new ArrayList<>();
		// remove that amount of cards from the deck and give to user one card at a time
		for (int numCard = 0; numCard < howMany && (deck != null) && (deck.checkDeckSize() > 0)
				&& (howMany < deck.checkDeckSize()); numCard++) {

			Card dealtCard = deck.dealCard();
			// user puts the cards into their hands
			userHand.add(dealtCard);
			// user adds cards based on their rank
			handTotal += dealtCard.getValue();
			// have the user show their hand
			System.out.println("Player hand: " + handTotal);

		}

		for (Card card : userHand) {
			System.out.println(card);
		}
	}
}
