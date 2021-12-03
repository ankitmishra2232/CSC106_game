package system;

import java.util.Scanner;

import tableGame.PlayersManager;


/**
 * This class sign up the players.
 */

public class SignUpPlayer {
	
	private Scanner input = new Scanner(System.in);
	private PlayersManager pM = PlayersManager.getInstance();
	private IDGenerator idGen = IDGenerator.getInstance();
	
	public void sign(){
		int number;
		
		System.out.print("ENTER THE NUMBER OF PLAYERS (2 TO 10): ");
		number = input.nextInt();
		
		while(number < 2 || number > 10){
			System.out.println("RANGE IS FROM 2 TO 10 PLAYERS");
			System.out.print("ENTER THE NUMBER OF PLAYER (2 TO 10): ");
			number =input.nextInt();
		}
		
		for(int i = 0 ; i < number ; i++){
			System.out.print("PLAYER " + String.valueOf(i+1) + ": ");
			pM.addPlayer(new Player(input.next(), idGen.getAnID()));
		}
		
	}
}
