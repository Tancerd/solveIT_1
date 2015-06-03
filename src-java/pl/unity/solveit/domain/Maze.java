package pl.unity.solveit.domain;

import static pl.unity.solveit.logic.MazeActionResult.MAZE_ACTION_NOT_ALLOWED;
import static pl.unity.solveit.logic.field.FieldInteractionResult.ACTION_NOT_ALLOWED;
import static pl.unity.solveit.util.FieldFactory.create;

import java.util.ArrayList;
import java.util.List;

import pl.unity.solveit.domain.field.AbstractField;
import pl.unity.solveit.logic.MazeActionResult;
import pl.unity.solveit.logic.field.FieldInteractionResult;
import pl.unity.solveit.logic.player.ActionDirection;
import pl.unity.solveit.logic.player.PlayerActionDirection;
import pl.unity.solveit.util.Position;

public class Maze implements IMaze {

	private static final int JUMP_MULTIPLY = 2;
	private static final int GO_MULTIPLY = 1;

	private List<List<AbstractField>> maze;

	private int width;
	private int height;

	public Maze(String stringMaze) {

		if (stringMaze == null || stringMaze.length() < 2) {
			throw new IllegalStateException("Maze to small");
		}

		maze = new ArrayList<>();

		String[] stringRows = stringMaze.split("\n");

		for (int i = 0; i < stringRows.length; i++) {

			List<AbstractField> columns = new ArrayList<>();
			String[] stringColumns = stringRows[i].split(" ");

			for (int j = 0; j < stringColumns.length; j++) {

				String stringField = stringColumns[j];

				AbstractField field = create(stringField, j, i);

				columns.add(field);
			}

			updateWidth(columns.size());

			maze.add(columns);
		}

		updateHeight(maze.size());
	}

	@Override
	public MazeActionResult actionAt(PlayerActionDirection playerActionDirection, Position playerPosition) {

		if (positionOutOfTheRangeOfMaze(playerPosition)) {
			return MAZE_ACTION_NOT_ALLOWED;
		}

		Position positionAfterAction;

		switch (playerActionDirection.getPlayerAction()) {

		case JUMP:
			positionAfterAction = recalculateOldPositionForJump(playerActionDirection.getActionDirection(), playerPosition);
		case GO:
		default:
			positionAfterAction = recalculateOldPositionForGo(playerActionDirection.getActionDirection(), playerPosition);
		}

		if (positionOutOfTheRangeOfMaze(positionAfterAction)) {
			return MAZE_ACTION_NOT_ALLOWED;
		}

		AbstractField field = getFieldAt(positionAfterAction);

		FieldInteractionResult interactionResult = field.fieldInteraction(playerActionDirection);

		if (interactionResult == ACTION_NOT_ALLOWED) {
			return MAZE_ACTION_NOT_ALLOWED;
		}

		return new MazeActionResult(positionAfterAction, interactionResult);
	}

	@Override
	public boolean positionOutOfTheRangeOfMaze(Position playerPosition) {
		return playerPosition.getX() < 0 || playerPosition.getY() < 0 || playerPosition.getX() >= width || playerPosition.getY() >= height;
	}

	private void updateWidth(int size) {

		if (width == 0) {
			width = size;
		} else if (width != size) {
			throw new IllegalStateException(
					"Different numbers of fields in rows.");
		}
	}

	private void updateHeight(int size) {
		height = size;
	}

	private AbstractField getFieldAt(Position position) {
		return maze.get(position.getY()).get(position.getX());
	}

	private Position recalculateOldPositionForJump(ActionDirection actionDirection, Position playerPosition) {

		Position moveVector = findMoveVector(actionDirection);

		return playerPosition.add(moveVector.multiply(JUMP_MULTIPLY));
	}

	private Position recalculateOldPositionForGo(ActionDirection actionDirection, Position playerPosition) {

		Position moveVector = findMoveVector(actionDirection);

		return playerPosition.add(moveVector.multiply(GO_MULTIPLY));
	}

	private Position findMoveVector(ActionDirection actionDirection) {

		switch (actionDirection) {
		case UP:
			return new Position(0, 1);
		case DOWN:
			return new Position(0, -1);
		case LEFT:
			return new Position(-1, 0);
		case RIGHT:
		default:
			return new Position(1, 0);
		}

	}
}
