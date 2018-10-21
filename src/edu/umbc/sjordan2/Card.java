package edu.umbc.sjordan2;

public class Card {
	
	// Basic card attributes (number value is not equal to face value)
	private int numberValue;
	private String cardName;
	
	// Shows whether this card (if it is an ace) has been changed to a one from an eleven.
	private boolean changedAce;
	
	// This Enum lists the four possible suits in a standard deck of cards, and makes it easy
	// to assign a single suit to each card in the deck list.
	public enum SUIT {
		Diamonds, Spades, Hearts, Clubs
	}
	
	// This constructor, when called with a number and a suit, creates a new card with the
	// given number and the given suite. It then combines the two in order to generate the card
	// name, which helps the player identify what card they drew form the deck. Additionally,
	// this constructor assigns the inherit number value of each card - all cards count as their
	// face value, except for Jack, Queen, and King (all count as 10), and Ace (11 until it
	// makes the player bust, in which case another class changes it to 1). 
	public Card(int number, String suite) {
		SUIT suit = SUIT.valueOf(suite);
		if(number >  1 && number < 11) {
			this.numberValue = number;
			cardName = Integer.toString(numberValue) + " of " + suit;
		} else {
			if(number == 1) {
				cardName = "Ace" + " of " + suit;
				this.changedAce = false;
				this.numberValue = 11;
			} else if(number == 11) {
				cardName = "Jack" + " of " + suit;
				this.numberValue = 10;
			} else if(number == 12) {
				this.numberValue = 10;
				cardName = "Queen" + " of " + suit;
			} else {
				cardName = "King" + " of " + suit;
				this.numberValue = 10;
			}
		}
	}
	
	// This getter method gets the number (point) value of the card it was called on.
	public int getNumberValue() {
		return numberValue;
	}
	
	// This getter method gets the card name of the card it was called on.
	public String getCardName() {
		return cardName;
	}
	
	// This setter method sets the number (point) value of the card it was called on to the
	// passed integer. Mainly used to update the number value of an Ace card in the case that 
	// an 11 makes the player bust.
	public void setNumberValue(int number) {
		this.numberValue = number;
	}
	
	// This getter method gets the status of a card if it happens to be an ace. If the status is
	// set to true, then the card has been changed from 11 to 1. It remains false otherwise.
	public boolean getAceStatus() {
		return this.changedAce;
	}
	
	// This setter method sets the ace status of the card to the passed boolean variable.
	// Mainly used to indicate that an Ace card has been changed from 11 to 1.
	public void setAceStatus(boolean status) {
		this.changedAce = status;
	}
	
	// Prints the name of the card as well as the number value (points) it currently holds
	// to the user. This is how the players' hands are communicated to the user.
	public String printWholeCardString() {
		String wholeString = "--> " + this.getCardName() + " (" + this.getNumberValue() 
		+ " points)";
		return wholeString;
	}

}
