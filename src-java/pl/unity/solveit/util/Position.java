package pl.unity.solveit.util;

public final class Position {

	private final int x;
	private final int y;


	public Position(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Position multiply(int multiply) {
		return new Position(x * multiply, y * multiply);
	}

	public Position add(Position vector) {
		return new Position(x + vector.x, y + vector.y);
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null || !(obj instanceof Position)) {
			return false;
		}

		Position position = (Position) obj;
		return x == position.x && y == position.y;
	}
}
