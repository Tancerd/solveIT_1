package pl.unity.solveit.domain.field;

import static pl.unity.solveit.logic.field.FieldInteractionResult.ACTION_NOT_ALLOWED;
import static pl.unity.solveit.logic.field.FieldInteractionResult.MAZE_EXIT;
import static pl.unity.solveit.logic.player.PlayerAction.GO;
import pl.unity.solveit.logic.field.FieldInteractionResult;
import pl.unity.solveit.logic.player.PlayerActionDirection;

public class MazeExitField extends AbstractField {

	public MazeExitField(int positionX, int positionY) {
		super(positionX, positionY);
	}

	@Override
	public FieldInteractionResult fieldInteraction(PlayerActionDirection playerActionDirection) {

		if (playerActionDirection.getPlayerAction() == GO) {
			return MAZE_EXIT;
		}

		return ACTION_NOT_ALLOWED;
	}

}
