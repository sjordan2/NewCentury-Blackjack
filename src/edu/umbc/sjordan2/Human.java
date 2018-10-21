package edu.umbc.sjordan2;

public class Human extends Player {
	
	// Invokes the superclass constructor and creates a new Player with the name "Human"
	public Human() {
		super("Human");
	}
	
	// Overrides the superclass method and implements unique hit/stand conditionals for the
	// human, which is based on a scanner input.
	@Override
	public void hitOrStand() {
		System.out.println("Would you like to 'hit' or 'stand'? Type your answer and then hit ENTER.");
		String hitOrStand = Game.scanner.nextLine();
		while(!hitOrStand.equalsIgnoreCase("hit") && !hitOrStand.equalsIgnoreCase("stand")) {
			System.out.println("Your answer must be either 'hit' or 'stand'! Please try again!");
			hitOrStand = Game.scanner.nextLine();
		}
		if(hitOrStand.equals("hit")) {
			Deck.dealCard(1, this);
		} else {
			this.finalizedValue = true;
			Dealer.notDealerTurn = false;
			System.out.println("You are standing at a hand value of " + this.cardValueHeld + ".\n");
		}
	}
	
	// Overrides the superclass method and implements unique printing conditionals for the
	// human (cards are always printed no matter what)
	@Override
	public void printCards() {
		System.out.println("Here are your cards:");
		for(Card c : this.getCurrentHand()) {
			System.out.println(c.printWholeCardString());
		}
		System.out.println("The value of your hand is " + this.cardValueHeld + ".\n");
	}

}
