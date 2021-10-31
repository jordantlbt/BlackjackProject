package com.skilldistillery.cards;

public class Dealer extends Player{
	

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
	//if total value of the dealers cards is 17 or more the dealer has to stay
	//if the total value of the dealers cards is over 21 they lose 
	//if the dealers value is less than the player the dealer losses
	//if the dealers value is more than the player but less than 22 the dealer wins

}
