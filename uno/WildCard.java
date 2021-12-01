package uno;


/**
 * This class represents a Wild Card.
 */
public class WildCard extends UnoCard{
   
    public enum Value {        
        WILD            { public String toString() { return "WILD";}},
        WILDDRAWFOUR    { public String toString() { return "WILD+4";}}
    }

    private final String color = "BLACK";
    private final Value value;
    private boolean used;
    private String effectiveColor;

    public WildCard(){
        this.value = Value.WILD;
        this.used = false;
    }
    
    /**
     * Get the color of the card. If this card was already played, then
     * the new color is showed.
     */
    @Override
    public String getColor(){
    	if(!this.used)
    		return this.color;
    	else
    		return this.effectiveColor;
    }
    
    /**
     * Get the value of the card(WILD).
     */
    @Override
    public String getValue(){
    	return this.value.name();
    }
    
   
    
    /**
     * Only matches with other cards if its has a color different of BLACK.
     */
    @Override
    public boolean match(UnoCard card){
    	if(this.getColor().equals("BLACK"))
    		return false;
    	else if(card.getColor().equals("BLACK"))
    		return true;
    	else
    		return (card.getColor().equals(this.getColor()));	
    }
    
    /**
     * Set the color of the wild card.
     * takes color desired.
     * returns if the operation could be done.
     */
    public boolean setColor(String color){
    	if(this.used)
    		return false;
    	
    	this.effectiveColor = color;
    	this.used = true;
    	return true;  	
    }
    
    /**
     * Get the representation of the card. 
     * returns the value of the wild card if the card wasn't used yet. If the
     * card was already used, then it returns the color chosen and the type.
     */
    @Override
    public String toString(){
    	if(this.used)
    		return super.toString();
    		
    	return this.getValue();
    }

	@Override
	public void applyEffect() {
		// TODO Auto-generated method stub
		
	}
}
