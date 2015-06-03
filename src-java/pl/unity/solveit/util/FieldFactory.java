package pl.unity.solveit.util;

import pl.unity.solveit.domain.field.AbstractField;
import pl.unity.solveit.domain.field.ColisionField;
import pl.unity.solveit.domain.field.EmptyField;
import pl.unity.solveit.domain.field.HoleField;
import pl.unity.solveit.domain.field.MazeExitField;

public final class FieldFactory {

	public final static AbstractField create(String stringField, int positionX,
			int positionY) {

		switch (stringField.toUpperCase()) {

		case "H":
			return new HoleField(positionX, positionY);
		case "C":
			return new ColisionField(positionX, positionY);
		case "E":
			return new MazeExitField(positionX, positionY);
		case "O":
		default:
			return new EmptyField(positionX, positionY);
		}

	}
}
