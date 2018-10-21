package edu.umbc.sjordan2;

public class Dealer extends Player {
	
	// A boolean flag representing whether or not it is the dealer's turn to draw
	public static boolean notDealerTurn = true;
	
	// Invokes the superclass constructor and creates a new Player with the name "Dealer"
	public Dealer() {
		super("Dealer");
	}
	
	// Overrides the superclass method and implements unique hit/stand conditionals for the
	// dealer, which is based on a hand of 17.
	@Override
	public void hitOrStand() {
		if(this.cardValueHeld < 17) {
			Deck.dealCard(1, this);
		} else {
			System.out.println("The dealer stood at a hand value of " + this.cardValueHeld + ".");
			this.finalizedValue = true;
		}
	}
	
	// Overrides the superclass method and implements unique printing conditionals for the
	// dealer (second card is hidden until it is the dealer's turn).
	@Override
	public void printCards() {
		System.out.println("Here are the dealer's cards:");
		if(Dealer.notDealerTurn) {
			System.out.println(this.getCurrentHand().get(0).printWholeCardString());
			System.out.println("--> ** HIDDEN **");
			System.out.print("\n");
		} else {
			for(Card c : this.getCurrentHand()) {
				System.out.println(c.printWholeCardString());
			}
			System.out.println("The value of the dealer's hand is " + this.cardValueHeld + ".\n");
		}
	}

}
