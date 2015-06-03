package pl.unity.solveit.logic.player;

public final class PlayerActionDirection {

	private final PlayerAction playerAction;
	private final ActionDirection actionDirection;


	public PlayerActionDirection(PlayerAction playerAction, ActionDirection actionDirection) {

		this.playerAction = playerAction;
		this.actionDirection = actionDirection;
	}

	public PlayerAction getPlayerAction() {
		return playerAction;
	}

	public ActionDirection getActionDirection() {
		return actionDirection;
	}
}
