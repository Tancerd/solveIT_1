package pl.unity.solveit.domain.field;

import pl.unity.solveit.logic.field.FieldInteractionResult;
import pl.unity.solveit.logic.player.PlayerActionDirection;

public class ColisionField extends AbstractField {

	public ColisionField(int positionX, int positionY) {
		super(positionX, positionY);
	}

	@Override
	public FieldInteractionResult fieldInteraction(PlayerActionDirection playerActionDirection) {
		return FieldInteractionResult.ACTION_NOT_ALLOWED;
	}

}
