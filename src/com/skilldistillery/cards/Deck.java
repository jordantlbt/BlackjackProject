package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	protected List<Card> deck = new ArrayList<>();

	public Deck() {

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(suit, rank);
				deck.add(card);
			}
		}
	}

	public int checkDeckSize() {
		return deck.size();

	}

	public void shuffleCards() {
		Collections.shuffle(deck);
	}

	public Card dealCard() {
		Card card = deck.remove(0);
		return card;
	}

}
