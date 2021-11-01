package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public class Player {

	// this creates a new hand(its own Arraylist to add cards) for a player
	protected Hand hand = new Hand();

	public void addCardToHand(Card card) {
		hand.addCard(card);

	}

	public void printHand() {
		// hand is shown to everyone
		System.out.println(hand);

	}

	public int totalValueOfHand() {
		// cards are added up and returns value
		return hand.getHandValue();
	}

	public void printValue() {
		// show the value of the hand without changing the value
		System.out.println(hand.getHandValue());
	}

	// find out if the hand is over 21
	public boolean isItOver21() {
		return hand.isItOver21();

	}

	// find out if the hand is exactly 21
	public boolean isIt21() {
		return hand.isIt21();
	}

}
