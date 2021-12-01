package uno;

import java.util.Random;

/**
 * This class represents a deck of uno cards.
 */
public class UnoDeck extends CardCollection <UnoCard>{
	private final static Random sourceRandom = new Random();
	public final static int LENGTH = 108;
	
	public UnoDeck(){
        for(NormalCard.Color c:NormalCard.Color.values()){
            for(int j = 0; j < 2 ; j++) {
                for(NormalCard.Value v:NormalCard.Value.values()){
                    if(j == 1 && v.equals(NormalCard.Value.ZERO) )
                        continue;
                    else 
                        cardList.add(new NormalCard(c,v));
                }
            }
        }

        for(NormalCard.Color c:NormalCard.Color.values()){
            for(int j = 0; j < 2 ; j++) {
                cardList.add(new SkipCard(c));
                cardList.add(new ReverseCard(c));
                cardList.add(new DrawTwoCard());
                
            }
        }

        
        for(int j = 0; j < 4; j++) {
             cardList.add(new WildCard());
             cardList.add(new WildDrawFourCard());
        }
        
    }

	/**
	 * Shuffles the deck.
	 */
    public void shuffle() {
        for(int i = cardList.size() - 1; i > 0; --i){
            int index = sourceRandom.nextInt(i);
            UnoCard c = cardList.get(index);
            cardList.set(index,cardList.get(i));
            cardList.set(i,c);
        }
    }

    /**
     * Get a card in the deck.
     * takes ith index of the card
     * returns the card.
     */
    public UnoCard get(final int i) { 
    	return this.cardList.get(i); 
    }

    /**
     * Make a string that contains all cards in the deck.
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for(UnoCard c : cardList){ sb.append(c.toString() + " ");}
        return sb.toString();
    }
	
    /**
     * Add a card in the deck.
     */
	@Override
	public boolean addCard(UnoCard card){
		return this.cardList.add(card);
	}

	/**
	 * Get a card from the deck.
	 */
	@Override
	public UnoCard getCard(int index){
		return this.cardList.remove(index);	
	}
}
