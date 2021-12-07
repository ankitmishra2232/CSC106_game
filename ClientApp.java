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
		game.init();					// Initiate the game.
		sign.sign();	// Registers players.
		game.start();					// Start the game.
		inter.readCommands();			// Read the commands from users.
		game.finish();					// Finishes the game.
		
	}

}
