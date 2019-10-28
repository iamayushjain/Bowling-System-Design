package design.system.bowling.game.strategies;

import design.system.bowling.game.DisplayMessage;
import design.system.bowling.game.Turn;
import design.system.bowling.game.TurnHelper;
import design.system.bowling.pojo.Player;

/**
 * GameStrategies model for Gutter
 * contains overall logic such as validation, bonus awards, message display, next turn scenario and much more.
 * @todo make it a sub class for {@link PinDownRoll}
 */

public class GutterRoll extends GameStrategies {

    public GutterRoll(int setNumber, Turn turn, TurnHelper turnHelper, int remainingPins, int totalPinDown, int currentShotPinDown) {
        super(setNumber, turn, turnHelper, remainingPins, totalPinDown, currentShotPinDown);
    }

    @Override
    public boolean validate() {
        return (currentShotPinDown == 0);
    }

    @Override
    public int getBonus() {
        return BonusConstants.GUTTER_BONUS;
    }

    @Override
    public void displayMessage(Player player) {
        DisplayMessage.displayGutterMessage(player, setNumber);
    }

    @Override
    public Turn getNextTurn() {
        return turn.next();
    }

    @Override
    public TurnHelper getNextTurnHelper() {
        return (turnHelper == TurnHelper.STRIKE_ELIGIBLE) ? TurnHelper.SPARE_ELIGIBLE : null;
    }
}
