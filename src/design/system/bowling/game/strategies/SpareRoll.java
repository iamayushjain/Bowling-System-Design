package design.system.bowling.game.strategies;

import design.system.bowling.game.DisplayMessage;
import design.system.bowling.game.Turn;
import design.system.bowling.game.TurnHelper;
import design.system.bowling.pojo.Player;


/**
 * GameStrategies model for Spare
 * contains overall logic such as validation, bonus awards, message display, next turn scenario and much more.
 */
public class SpareRoll extends GameStrategies {

    public SpareRoll(int setNumber, Turn turn, TurnHelper turnHelper, int remainingPins, int totalPinDown, int currentShotPinDown) {
        super(setNumber, turn, turnHelper, remainingPins, totalPinDown, currentShotPinDown);
    }

    @Override
    public boolean validate() {
        return (turnHelper == TurnHelper.SPARE_ELIGIBLE && remainingPins == 0);
    }

    @Override
    public int getBonus() {
        return BonusConstants.SPARE_BONUS;
    }

    @Override
    public void displayMessage(Player player) {
        DisplayMessage.displaySpareMessage(player, setNumber);
    }

    @Override
    public Turn getNextTurn() {
        return (isFinalFrame) ? turn.next() : null;
    }

    @Override
    public TurnHelper getNextTurnHelper() {
        return (isFinalFrame) ? TurnHelper.STRIKE_ELIGIBLE : null;
    }
}
