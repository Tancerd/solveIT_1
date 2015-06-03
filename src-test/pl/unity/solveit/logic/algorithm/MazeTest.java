package pl.unity.solveit.logic.algorithm;

import org.junit.Test;

import pl.unity.solveit.domain.IMaze;
import pl.unity.solveit.domain.Maze;

public class MazeTest {

	/**
	 * H - hole C - colision E - exit O - empty
	 */

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionWhenStringMazeIsToSmall() {

		String stringMaze = "O";

		IMaze maze = new Maze(stringMaze);
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionWhenStringMazeIsNull() {

		String stringMaze = null;

		IMaze maze = new Maze(stringMaze);
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowExceptionWhenNumberOfColumnIsDiffrentInRows() {

		String stringMaze = "O O\n"
				+ 			"O";

		IMaze maze = new Maze(stringMaze);
	}
}
