package uno;

import tableGame.EffectsController;

public class DrawTwoCard extends SpecialCard{
	public DrawTwoCard(NormalCard.Color color){
		super(color, SpecialCard.Value.DRAWTWO);
	}
	
	/**
	 * This card makes the next player takes two more cards.
	 * It also loses its turn.
	 */
	@Override
	public void applyEffect(EffectsController ctrl){
		ctrl.applyDrawTwo();
	}
}
