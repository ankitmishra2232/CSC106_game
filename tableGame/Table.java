package tableGame;

import java.util.ArrayList;

import uno.DiscardPile;
import uno.UnoCard;
import uno.UnoDeck;
import uno.WildCard;
import uno.WildDrawFourCard;

/*
  This class represents a game of UNO. It includes the discard pile, the
  deck, the players and their hands and info about the state of the game.
 */

public class Table {
	private DiscardPile dPile; //the Discard Pile are put back into the deck and then it is shuffle.
	private UnoDeck deck;
	private static Table table = null;
	
	private Table(){
		this.dPile = new DiscardPile(); 
		this.deck = new UnoDeck(); 
	}
	
	public static Table getInstance(){
		if(table == null)
			table = new Table();
		
		return table;
	}
	
	/*
	 * Prepares the table to start the game. 
	 */
	public void prepareTable(){
		if(this.dPile.getNumCards() != 0){
			ArrayList <UnoCard> list = dPile.takeCardsBack();
			for(int i = 0; i < list.size(); i++)
				this.deck.addCard(list.remove(0));
		}
		
		deck.shuffle();
		
		UnoCard card = this.deck.getCard(0);
		while(card.getColor().equals("BLACK")){
			this.deck.addCard(card);
			card = this.deck.getCard(0);
		}
		
		this.dPile.initialize(card);
	} 
	
	
	public UnoCard showTopCard(){   //shows last card played
		return this.dPile.getTopCard();
	}

	/*
	  Try to play a card that is in the hand of the current player. 
	  If it is possible, then the card is put in the discard pile and its effect is applied in the game. 
	  takes cardName the name of the card that will be played.
	  returns if the operation was successful.
	 */
	public boolean pushCard(UnoCard card){		
		if(card == null)
			return false;
		
		if(this.dPile.getTopCard().match(card)){
			this.dPile.addCard(card);
			return true;
			
		} else{
			return false;
		}		
	}
	
	/*
	  Take a card from the top of the deck. If the deck is empty, then
	  the discard pile is used to provide more cards to the game.
	  returns one card.
	 */
	public UnoCard pullCard(){	
		UnoCard card = null;
		if(this.deck.isEmpty()){
			ArrayList <UnoCard> list = dPile.takeCardsBack();
			if(list.size() != 0){     
				for(int i = 0; i < list.size(); i++)
					card = list.remove(0);               
				
				if(card.getValue().equals("WILD+4"))
					this.deck.addCard(new WildDrawFourCard()); 
				else if(card.getValue().equals("WILD"))
					this.deck.addCard(new WildCard());
				else
					this.deck.addCard(card);
				
				this.deck.shuffle();
			} else{
				System.out.println("NO MORE CARDS AVAILABLE");
				return null;
			}
		}	
			
		return this.deck.getCard(0);
	}
	
	/*
	  Get the number of cards left in the deck.
	  returns the number of cards in the deck.
	 */
	public int getNumCardsOnDeck(){
		return this.deck.getNumCards();
	}

}
