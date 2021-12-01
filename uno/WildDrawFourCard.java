package uno;



/**
 * This class represents a Wild Draw Four Card.
 */
public class WildDrawFourCard extends WildCard{
	private Value value;
	
	public WildDrawFourCard(){
		super();
        this.value = Value.WILDDRAWFOUR;	
	}
	
	/**
     * Get the value of the card (WILDDRAWFOUR).
     */
    @Override
    public String getValue(){
    	return this.value.toString();
    }
    
	

}
