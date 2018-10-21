package edu.umbc.sjordan2;

import java.util.Scanner;

public class Game {
	
	// Defines types for the human, dealer, and deck
	Human human;
	Dealer dealer;
	Deck deck;
	
	// Blackjack runs until this boolean value is true
	private boolean gameFinished = false;
	
	// Boolean flag representing the first turn of the game or not
	public static boolean firstTurn;
	
	// Serves the purpose of revealing the hidden card if blackjack is acquired immediately.
	private int dealerTurns;
	
	// Scanner used throughout the program
	public static final Scanner scanner = new Scanner(System.in);
	
	// This function initializes the game and prepares it to the point where the player
	// decides whether they hit or stand. In order to make it easier for the human to
	// comprehend what is happening, the thread is put to sleep multiple times. This
	// function resets default variables, creates/shuffles the deck, and deals the two
	// beginning cards to both the human and the dealer. 
	public void initializeGame() {
		try {
			firstTurn = true;
			Dealer.notDealerTurn = true;
			dealerTurns = 0;
			System.out.println("Welcome to Blackjack!");
			Thread.sleep(1500);
			System.out.println("Creating deck of 52 cards...");
			Thread.sleep(1000);
			deck = new Deck();
			deck.createStandardDeck();
			Deck.shuffleDeck();
			Thread.sleep(2000);
			human = new Human();
			dealer = new Dealer();
			System.out.println("Dealing cards to player and dealer...\n");
			Thread.sleep(750);
			Deck.dealCard(2, human);
			Deck.dealCard(2, dealer);
			firstTurn = false;
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// This function actually runs the Blackjack game. A while loop is implemented for both
	// the human and dealer turns to ensure that they don't bust (it exits when they stand).
	// It has some unique bits for the human and dealer in order to make the whole game
	// experience more smooth and entertaining. Again, the threads are put to sleep to aid
	// in the processing time for humans. Frequently, the game ending conditions are checked
	// to make sure that the rules are followed to the T.
	public void runGame() {
		checkConditions();
		try {
			dealer.printCards();
			Thread.sleep(500);
			human.printCards();
			Thread.sleep(500);
			if(!gameFinished) {
				System.out.println("It is the player's turn!");
				while(!human.finalizedValue && !gameFinished) {
					human.hitOrStand();
					Thread.sleep(750);
					if(!human.finalizedValue) {
						human.printCards();
					}
					checkConditions();
					Thread.sleep(1000);
				}
				if(!gameFinished) {
					System.out.println("It is the dealer's turn!");
					System.out.println("The dealer's hidden card was a " + dealer.getCurrentHand().get(1).getCardName() + "!");
					Thread.sleep(250);
					dealer.printCards();
					Thread.sleep(750);
					while(!dealer.finalizedValue && !gameFinished) {
						dealer.hitOrStand();
						dealerTurns++;
						Thread.sleep(750);
						if(!dealer.finalizedValue) {
							dealer.printCards();
						}
						checkConditions();
						Thread.sleep(1000);
					}
					gameFinished = true;
				}
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// This function's sole purpose is to check the game ending conditions for blackjack.
	// It sets the boolean flag for gameFinished to false if any of the triggers are hit.
	// It also checks for the ace problem, and calls the associated function to change it
	// from 11 to 1 if it makes the player bust. Most of the conditions are checked AFTER
	// the human has completed their turn, which is much like the actual game.
	public void checkConditions() {
		if(human.finalizedValue && dealer.finalizedValue) {
			System.out.println("Both players stood! The game is finished!\n");
			if(human.cardValueHeld > dealer.cardValueHeld) {
				System.out.println("The human won the game! Congratulations!");
			} else if(human.cardValueHeld < dealer.cardValueHeld) {
				System.out.println("Sorry, but the dealer won this round!");
			} else {
				System.out.println("The game is a tie! No one wins!");
			}
			gameFinished = true;
		}
		if(human.finalizedValue) {
			if(human.cardValueHeld != 21 && dealer.cardValueHeld == 21) {
				System.out.println("The dealer got blackjack! Sorry!");
				if(dealerTurns < 1) {
					System.out.println("The dealer's hidden card was a " + dealer.getCurrentHand().get(1).getCardName() + "!");
				}
				gameFinished = true;
			}
			if(human.cardValueHeld == 21 && dealer.cardValueHeld == 21) {
				System.out.println("Both players got 21! The game is a tie!");
				gameFinished = true;
			}
		}
		if(human.cardValueHeld == 21 && dealer.cardValueHeld != 21) {
			System.out.println("The player got blackjack! Congratulations!");
			gameFinished = true;
		}
		if(human.cardValueHeld > 21) {
			if(human.handContainsAce()) {
				System.out.println("The human has an ace! Changing it's value from 11 to 1...");
				human.updateCardValue();
				System.out.println("The new value of your hand is " + human.cardValueHeld + ".\n");
			} else {
				System.out.println("Oh no! The player busted! The dealer wins!");
				gameFinished = true;
			}
		} 
		if(dealer.cardValueHeld > 21) {
			if(dealer.handContainsAce() && human.finalizedValue) {
				System.out.println("The dealer has an ace! Changing it's value from 11 to 1...");
				dealer.updateCardValue();
			} else {
				System.out.println("Oh no! The dealer busted! The player wins!");
				gameFinished = true;
			}
		}
	}
}
