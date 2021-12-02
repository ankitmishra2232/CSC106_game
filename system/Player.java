package system;

import uno.Hand;
import uno.UnoCard;

/** 
 * This class represents a player.
 */
public class Player {
	private ID p_id;
	private Hand p_hand;
	private String p_name;
	
	
	public Player(String name, int p_id) {
		this.p_id   = new ID(p_id);
		this.p_hand = new Hand();
		this.p_name = name;
	}
	
	
	/**
	 * Get the Identification (ID) of the player.
	 * returns the player's ID.
	 */
	public int getID(){
		return this.p_id.getID();
	}
	
	/**
	 * Get the name of the player.
	 * returns the player's name.
	 */
	public String getName(){
		return this.p_name;
	}
	
	/**
	 * returns the number of cards present in hand
	 */
	public int numCards(){
		return p_hand.getNumCards();
	}
	
	/**
	 * The player takes a card if it's its turn.
	 * takes card that will be taken.
	 */
	public boolean takeCard(UnoCard card){
		return this.p_hand.addCard(card);
	}
	
	/**
	 * Play a card if it is its turn.
	 * takes cardName: The name of the card. The name is compared by the color 
	 * and the number or effect.
	 * returns the card.
	 */
	public UnoCard playCard(String cardName){
		int i = 0;
		while(i != this.p_hand.getNumCards()){
			if(this.p_hand.showCard(i).equals(cardName))
				return this.p_hand.getCard(i);
			i++;
		}
		
		return null;
	}
	
	/**
	 * Play the ith card in the hand of the player; 
	 * takes ith index of the card.
	 * returns the ith card or null if there is no ith card.
	 */
	public UnoCard playCard(int i){
		return this.p_hand.getCard(i);
	}
	
	/**
	 * Print all the cards on the hand of the player.
	 */
	public void showCards(){
		int ncards =  this.p_hand.getNumCards();
		String toPrint = "";
		int i;
		if(ncards == 0){
			System.out.print("EMPTY HAND.");
			
		} else{
			for(i = 0; i < ncards; i++){
				toPrint += "[" + this.p_hand.showCard(i) + "] ";
			}
		}
		
		
		System.out.println(toPrint);
		
	}
	
	/**
	 * Empty the hand.
	 */
	public void emptyHand(){
		while(!this.p_hand.isEmpty())
			this.p_hand.getCard(0);
		}
}
