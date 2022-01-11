import game.Match;
import interpreter.Interpreter;
import system.SignUpPlayer;

public class ClientApp {

	public static void main(String[] args) {
		Interpreter inter = new Interpreter();	
		SignUpPlayer sign = new SignUpPlayer();
		Match game = Match.getInstance();
		
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\tUNO CARD GAME");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.println("RULES: - \n 1> To play a card you have to write 'play cardname'."
				+ "			\n 2> To play wild card write 'wild color'."
				+ "			\n 3> To draw card from deck keyword 'draw'. "
				+ "			\n 4> Once you draw and not got appropiate card to play 'pass'. "
				+ "			\n 5> When you put the second last card to the table you must say uno otherwise two card will be drawn from the deck to you"
				+ "\n \tfor example: - 'play red4 uno'");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		game.init();					// Initiate the game.
		sign.sign();	// Registers players.
		game.start();					// Start the game.
		inter.readCommands();			// Read the commands from users.
		game.finish();					// Finishes the game.
		
	}

}
