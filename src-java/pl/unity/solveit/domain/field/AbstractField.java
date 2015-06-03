package pl.unity.solveit.domain.field;

import pl.unity.solveit.logic.field.FieldInteractionResult;
import pl.unity.solveit.logic.player.PlayerActionDirection;
import pl.unity.solveit.util.Position;

public abstract class AbstractField {

	private final Position position;


	public AbstractField(int positionX, int positionY) {

		position = new Position(positionX, positionY);
	}

	public int getPositionX() {
		return position.getX();
	}

	public int getPositionY() {
		return position.getY();
	}

	public abstract FieldInteractionResult fieldInteraction(PlayerActionDirection playerActionDirection);

}
