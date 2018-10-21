package edu.umbc.sjordan2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	// This static list contains the current set of cards remaining in the pile yet to be drawn.
	public static List<Card> deckCards;
	
	// This constructor, when called, creates the new list to hold 52 different cards. 
	public Deck() {
		deckCards = new ArrayList<Card>(52);
	}
	
	// This function adds the 52 unique cards to the deck list, each with a unique index and
	// combination of number and suit.
	public void createStandardDeck() {
		int numCounter = 1;
		int cardCounter = 1;
		int cardsPerNumber = 4;
		int totalCounter = 0;
		while(cardCounter <= 13) {
			while(numCounter <= cardsPerNumber) {
				switch(numCounter) {
				case 1:
					deckCards.add(totalCounter, new Card(cardCounter, "Spades"));
					break;
				case 2:
					deckCards.add(totalCounter, new Card(cardCounter, "Hearts"));
					break;
				case 3:
					deckCards.add(totalCounter, new Card(cardCounter, "Clubs"));
					break;
				case 4:
					deckCards.add(totalCounter, new Card(cardCounter, "Diamonds"));
					break;
				}
				numCounter++;
				totalCounter++;
			}
			cardCounter++;
			numCounter = 1;
		}
	}
	
	// This function randomizes the cards in the deck list (i.e. shuffles them).
	public static void shuffleDeck() {
		System.out.println("Shuffling the deck...");
		Collections.shuffle(deckCards);
	}
	
	// This function, when given an integer 'n' and a player 'p', deals cards from the deck list
	// by giving n cards to the player p and adding it to the player's hand. The function only 
	// announces what card the player drew if it isn't the first turn (since the dealer's 
	// second card needs to remain hidden).
	public static void dealCard(int numCards, Player player) {
		for(int i = 0; i < numCards; i++) {
			Card randomCard = deckCards.get(0);
			deckCards.remove(0);
			player.currentHand.add(randomCard);
			player.numCardsHeld++;
			player.updateCardValue();
			if(!Game.firstTurn) {
				System.out.println("The " + player.playerName + " drew a " + 
			    randomCard.getCardName() + "!\n");
			}
		}
	}

}
