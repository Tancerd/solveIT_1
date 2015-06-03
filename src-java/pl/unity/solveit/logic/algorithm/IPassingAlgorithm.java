package pl.unity.solveit.logic.algorithm;
import pl.unity.solveit.domain.IMaze;
import pl.unity.solveit.util.Position;


public interface IPassingAlgorithm {

	public boolean wayExists(IMaze maze, Position playerPosition);
}
