package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

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

	
	public void showTopCard() {
		if(hand.size() == 2) {
			System.out.println(hand.get(1));
		}
	}

	public boolean isItOver21() {
		int value = getHandValue();

		if (value > 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isItLessThan17() {
		int value = getHandValue();

		if (value < 17) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isIt21() {
		int value = getHandValue();

		if (value == 21) {
			return true;
		} else {
			return false;
		}
	}

	public void clearHand() {
		hand.removeAll(hand);
	}

	@Override
	public String toString() {
		return "Hand " + hand;
	}

}
