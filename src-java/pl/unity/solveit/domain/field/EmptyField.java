package pl.unity.solveit.domain.field;

import static pl.unity.solveit.logic.field.FieldInteractionResult.ACTION_ALLOWED;
import static pl.unity.solveit.logic.field.FieldInteractionResult.ACTION_NOT_ALLOWED;
import static pl.unity.solveit.logic.player.PlayerAction.GO;
import pl.unity.solveit.logic.field.FieldInteractionResult;
import pl.unity.solveit.logic.player.PlayerActionDirection;

public class EmptyField extends AbstractField {

	public EmptyField(int positionX, int positionY) {
		super(positionX, positionY);
	}

	@Override
	public FieldInteractionResult fieldInteraction(PlayerActionDirection playerActionDirection) {

		if (playerActionDirection.getPlayerAction() == GO) {
			return ACTION_ALLOWED;
		}

		return ACTION_NOT_ALLOWED;
	}

}
