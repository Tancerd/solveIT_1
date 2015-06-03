package pl.unity.solveit.logic.algorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pl.unity.solveit.domain.IMaze;
import pl.unity.solveit.domain.Maze;
import pl.unity.solveit.util.Position;

public class DFSFunctionalTest {

	/**
	 * H - hole 
	 * C - colision 
	 * E - exit 
	 * O - empty
	 */

	@Test
	public void shouldNotFindWayToExit1() {

		String stringMaze = "O O";
		Position playerStartPosition = new Position(0, 0);

		IMaze maze = new Maze(stringMaze);
		IPassingAlgorithm passingAlgorithm = new DFS();

		boolean result = passingAlgorithm.wayExists(maze, playerStartPosition);

		assertEquals(result, false);
	}

	@Test
	public void shouldNotFindWayToExit2() {

		String stringMaze = "O C\n"
						+ 	"C E";
		Position playerStartPosition = new Position(0, 0);

		IMaze maze = new Maze(stringMaze);
		IPassingAlgorithm passingAlgorithm = new DFS();

		boolean result = passingAlgorithm.wayExists(maze, playerStartPosition);

		assertEquals(result, false);
	}

	@Test
	public void shouldFindWayToExit1() {

		String stringMaze = "O E";
		Position playerStartPosition = new Position(0, 0);

		IMaze maze = new Maze(stringMaze);
		IPassingAlgorithm passingAlgorithm = new DFS();

		boolean result = passingAlgorithm.wayExists(maze, playerStartPosition);

		assertEquals(result, true);
	}

	@Test
	public void shouldFindWayToExit2() {

		String stringMaze = "O H O E";
		Position playerStartPosition = new Position(0, 0);

		IMaze maze = new Maze(stringMaze);
		IPassingAlgorithm passingAlgorithm = new DFS();

		boolean result = passingAlgorithm.wayExists(maze, playerStartPosition);

		assertEquals(result, true);
	}

	@Test
	public void shouldFindWayToExit3() {

		String stringMaze = "O H C C E\n"
						+ 	"O O H O O";
		Position playerStartPosition = new Position(0, 0);

		IMaze maze = new Maze(stringMaze);
		IPassingAlgorithm passingAlgorithm = new DFS();

		boolean result = passingAlgorithm.wayExists(maze, playerStartPosition);

		assertEquals(result, true);
	}
}
