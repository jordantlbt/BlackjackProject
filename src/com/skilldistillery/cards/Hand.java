package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	//create an Arraylist to add cards to a hand
	protected List<Card> hand = new ArrayList<>();

	public Hand() {
	}

	public void addCard(Card card) {
		// add cards to hand
		hand.add(card);

	}

	public int getHandValue() {
		int totalValue = 0;
		for (Card card : hand) {
			totalValue += card.getValue();
		}
		return totalValue;

	}

	//lets dealer show top card to player
	//have not implemented this method yet
	public void showTopCard() {
		if(hand.size() == 2) {
			System.out.println(hand.get(1));
		}
	}
	// find out if the hand is over 21
	public boolean isItOver21() {
		int value = getHandValue();

		if (value > 21) {
			return true;
		} else {
			return false;
		}
	}
	//find out if the hand is less than 17
	public boolean isItLessThan17() {
		int value = getHandValue();

		if (value < 17) {
			return true;
		} else {
			return false;
		}
	}
	//find out if the hand is exactly 21
	public boolean isIt21() {
		int value = getHandValue();

		if (value == 21) {
			return true;
		} else {
			return false;
		}
	}
	//clear hand for a new game
	//have not looped the game yet
	//have not implemented this method yet
	public void clearHand() {
		hand.removeAll(hand);
	}

	//why doesn't this override? I don't understand
	@Override
	public String toString() {
		return "Hand " + hand;
	}

}
