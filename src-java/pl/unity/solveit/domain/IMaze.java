package pl.unity.solveit.domain;

import pl.unity.solveit.logic.MazeActionResult;
import pl.unity.solveit.logic.player.PlayerActionDirection;
import pl.unity.solveit.util.Position;

public interface IMaze {

	public MazeActionResult actionAt(PlayerActionDirection playerActionDirection, Position playerPosition);

	public boolean positionOutOfTheRangeOfMaze(Position playerPosition);
}
