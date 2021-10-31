package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public class Player {

	protected Hand hand = new Hand();
	

	public void addCardToHand(Card card) {
		hand.addCard(card);

	}

	public void printHand() {
		// card is shown to everyone
		System.out.println(hand);

	}

	public int totalValueOfHand() {
		// cards are added up
		return hand.getHandValue();
	}
	
	public void printValue() {
		System.out.println(hand.getHandValue());
	}

	// player can hit or stay
	public boolean isItOver21() {
		return hand.isItOver21();
		
	}
	
	public boolean isIt21() {
		return hand.isIt21();
	}
	// if players value goes over 21 they lose
	// if the players value is less than the dealer then they lose
	// if players value has higher value than dealer but less than 22 they win

}
