package uno;

import tableGame.EffectsController;

public class ReverseCard extends SpecialCard{
	
	public ReverseCard(NormalCard.Color color){
		super(color, SpecialCard.Value.REVERSE);
	}
	
	/**
	 * Revert the direction of the game. If only two persons are playing, 
	 * then this effect is similar to the skip one.
	 */
	@Override
	public void applyEffect(EffectsController ctrl){
		ctrl.applyReverse();
	}

}
