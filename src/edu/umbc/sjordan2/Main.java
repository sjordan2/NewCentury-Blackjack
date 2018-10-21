package edu.umbc.sjordan2;

public class Main {
	
	// This beautiful main method acts as a sentinel loop. It runs the game indefinitely until
	// the player inputs "no" when prompted by the console.
	public static void main(String[] args) {
		boolean wantToContinue = true;
		String newGame;
		while(wantToContinue) {
			Game game = new Game();
			game.initializeGame();
			game.runGame();
			System.out.println("Would you like to play another game? (yes/no)");
			newGame = Game.scanner.nextLine();
			while(!newGame.equalsIgnoreCase("yes") && !newGame.equalsIgnoreCase("no")) {
				System.out.println("Invalid answer! Must be either 'yes' or 'no'!");
				newGame = Game.scanner.nextLine();
			}
			if(newGame.equalsIgnoreCase("no")) {
				System.out.println("Thank you for playing! Good bye!");
				Game.scanner.close();
				wantToContinue = false;
			}
		}
	}
	
}
