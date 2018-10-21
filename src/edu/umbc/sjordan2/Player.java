package edu.umbc.sjordan2;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	// Basic values for players, including the number of cards they are currently
	// holding as well as the total point value of their hand
	public int numCardsHeld;
	public int cardValueHeld;
	
	// A string representing the player's name (human/dealer)
	public String playerName;
	
	// A list indicating the current cards in the player's hand
	public List<Card> currentHand;
	
	public boolean finalizedValue = false;
	
	// This constructor, when called, creates a new instance of the "Player" object and gives it
	// default values. It also sets the player's name to the passed string. 
	public Player(String player) {
		numCardsHeld = 0;
		cardValueHeld = 0;
		currentHand = new ArrayList<Card>(2);
		this.playerName = player;
	}
	
	// This getter function returns a list of cards in the player's current hand.
	public List<Card> getCurrentHand() {
		return this.currentHand;
	}
	
	// This function updates the player's card value to reflect an card addition or change to
	// any existing cards in the player's hand.
	public void updateCardValue() {
		int value = 0;
		for(Card c : currentHand) {
			value += c.getNumberValue();
		}
		cardValueHeld = value;
	}
	
	// Basic function allowing overriding for subclasses
	public void printCards() {

	}
	
	// Basic function allowing overriding for subclasses
	public void hitOrStand() {
		
	}
	
	// Checks whether or not the player's current hand contains an Ace or not. If it does
	// contain an ace, and it hasn't been updated yet, then it sets the value to 1 and
	// returns true to the Game class.
	public boolean handContainsAce() {
		boolean containsAce = false;
		for(Card c : this.getCurrentHand()) {
			if(c.getCardName().contains("Ace")) {
				if(!c.getAceStatus()) {
					c.setNumberValue(1);
					c.setAceStatus(true);
					containsAce = true;
				}
			}
		}
		return containsAce;
	}

}
