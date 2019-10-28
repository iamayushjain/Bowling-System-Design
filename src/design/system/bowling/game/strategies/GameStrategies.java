package design.system.bowling.game.strategies;

import com.sun.istack.internal.NotNull;
import design.system.bowling.Constants;
import design.system.bowling.game.Turn;
import design.system.bowling.game.TurnHelper;
import design.system.bowling.pojo.Player;

/**
 * GameStrategies model
 * contains overall logic such as validation, bonus awards, message display, next turn scenario and much more.
 */
public abstract class GameStrategies {
    int setNumber, remainingPins, totalPinDown, currentShotPinDown;
    Turn turn;
    TurnHelper turnHelper;
    boolean isFinalFrame;

    protected GameStrategies(int setNumber,@NotNull Turn turn,@NotNull TurnHelper turnHelper, int remainingPins, int totalPinDown, int currentShotPinDown){
        this.setNumber = setNumber;
        this.turn = turn;
        this.turnHelper = turnHelper;
        this.remainingPins = remainingPins;
        this.totalPinDown = totalPinDown;
        this.currentShotPinDown = currentShotPinDown;
        this.isFinalFrame = (setNumber == Constants.MAX_LANE -1);
    }

    public abstract boolean validate();
    public abstract int getBonus();
    public abstract void displayMessage(Player player);
    public abstract Turn getNextTurn();
    public abstract TurnHelper getNextTurnHelper();
}
