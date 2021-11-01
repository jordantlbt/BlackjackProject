package com.skilldistillery.cards;

public class Dealer extends Player{
	//Dealer can use all the same methods the player class has since it implements the player class

	Deck deck = new Deck();
	
	public boolean isLessThan17() {
		//if total value of the dealers cards is less than 17 the dealer has to hit
		return hand.isItLessThan17();		
	}
	
	public void shuffleDeck() {
		deck.shuffleCards();
	}
	public Card dealCard() {
		//remove the top card from the deck
		return deck.dealCard();
		
	}


}
