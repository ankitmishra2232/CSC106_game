package uno;

import tableGame.EffectsController;;

public class SkipCard extends SpecialCard{

	public SkipCard(NormalCard.Color color){
		super(color, SpecialCard.Value.SKIP);
	}
	
	/**
	 * Rotates the game in order to produce the result of skipping a player
	 * in the end of the turn.
	 */
	@Override
	public void applyEffect(EffectsController ctrl){
		ctrl.applySkip();
	}
}
