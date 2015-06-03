package pl.unity.solveit.logic.algorithm;

import static pl.unity.solveit.logic.field.FieldInteractionResult.ACTION_ALLOWED;
import static pl.unity.solveit.logic.field.FieldInteractionResult.MAZE_EXIT;

import java.util.ArrayList;
import java.util.List;

import pl.unity.solveit.domain.IMaze;
import pl.unity.solveit.logic.MazeActionResult;
import pl.unity.solveit.logic.field.FieldInteractionResult;
import pl.unity.solveit.logic.player.ActionDirection;
import pl.unity.solveit.logic.player.PlayerAction;
import pl.unity.solveit.logic.player.PlayerActionDirection;
import pl.unity.solveit.util.Position;

public class DFS implements IPassingAlgorithm {

	private static final List<PlayerActionDirection> allPlayersActionsDirections = new ArrayList<>();

	static {

		for (ActionDirection actionDirection : ActionDirection.values()) {

			for(PlayerAction playerAction : PlayerAction.values()) {
				allPlayersActionsDirections.add(new PlayerActionDirection(playerAction, actionDirection));
			}
		}

	}

	private IMaze maze;
	private boolean wayExists = false;

	@Override
	public boolean wayExists(IMaze maze, Position playerPosition) {

		if (maze == null || playerPosition == null
				|| maze.positionOutOfTheRangeOfMaze(playerPosition)) {
			throw new IllegalStateException("Invalid input data");
		}

		this.maze = maze;

		dfs(new ArrayList<>(), playerPosition);

		return wayExists;
	}

	private void dfs(List<Position> visitedPositions, final Position position) {

		visitedPositions.add(position);

		if (wayExists) {
			return;
		}

		allPlayersActionsDirections.stream().forEach((playerActionDirection) -> {

			MazeActionResult result = maze.actionAt(playerActionDirection, position);

			FieldInteractionResult fieldInteractionResult = result.getFieldInteractionResult();
			Position newPosition = result.getPosition();

			System.out.println(playerActionDirection.getPlayerAction() + " " + playerActionDirection.getActionDirection() + " " + fieldInteractionResult);

			if (fieldInteractionResult == MAZE_EXIT) {

				wayExists = true;
				return;
			}
			else if (fieldInteractionResult == ACTION_ALLOWED && positionNotVisited(visitedPositions, newPosition)) {

				dfs(new ArrayList<>(visitedPositions), newPosition);
			}
		});
	}

	private boolean positionNotVisited(List<Position> visitedPositions, Position position) {
		return !visitedPositions.contains(position);
	}

}
