package uno;

/**
 * This class represents a hand of a UNO player. There are basic operations like
 * add, get and show cards.
 */
public class Hand extends CardCollection <UnoCard>{
	
	public Hand(){
		super();
	}
	
	/**
	 * Add a card in the hand of the player.
	 * returns if it was possible to add the card.
	 */
	@Override
	public boolean addCard(UnoCard card){
		return this.cardList.add(card);
	}

	/**
	 * Remove a card in the hand of the player.
	 * takes index of the desired card.
	 * returns the UNO card removed.
	 */
	@Override
	public UnoCard getCard(int index){
		return this.cardList.remove(index);
	}
	
	/**
	 * Show a card that is on the hand.
	 * takes index of the desired card.
	 */
	public String showCard(int index){
		return this.cardList.get(index).toString();
	}
}
