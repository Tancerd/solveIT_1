package pl.unity.solveit.logic;

import static pl.unity.solveit.logic.field.FieldInteractionResult.ACTION_NOT_ALLOWED;
import pl.unity.solveit.logic.field.FieldInteractionResult;
import pl.unity.solveit.util.Position;

public final class MazeActionResult {

	public static final MazeActionResult MAZE_ACTION_NOT_ALLOWED = new MazeActionResult(null, ACTION_NOT_ALLOWED);

	private final Position position;
	private final FieldInteractionResult fieldInteractionResult;


	public MazeActionResult(Position position, FieldInteractionResult fieldInteractionResult) {

		this.position = position;
		this.fieldInteractionResult = fieldInteractionResult;
	}

	public Position getPosition() {
		return position;
	}

	public FieldInteractionResult getFieldInteractionResult() {
		return fieldInteractionResult;
	}
}
