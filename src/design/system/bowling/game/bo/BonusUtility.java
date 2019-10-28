package design.system.bowling.game.bo;

import com.sun.istack.internal.NotNull;
import design.system.bowling.game.Turn;
import design.system.bowling.game.TurnHelper;
import design.system.bowling.game.strategies.*;
import cred.assignment.game.strategies.*;
import system.bowling.game.strategies.*;

/**
 * Bonus utility to analyze bonus types.
 * Fallback to multiple pin down roll
 */
//@todo reduce parameter in the constructor
public class BonusUtility {
    private static int setNumber, remainingPins, totalPinDown, currentShotPinDown;
    private static Turn turn;
    private static TurnHelper turnHelper;

    @NotNull
    protected static GameStrategies analyzeBonus(int frame, Turn turn, TurnHelper turnHelper, int remainingPins, int totalPinDown, int currentShotPinDown) {
        BonusUtility.setNumber = frame;
        BonusUtility.turn = turn;
        BonusUtility.turnHelper = turnHelper;
        BonusUtility.remainingPins = remainingPins;
        BonusUtility.totalPinDown = totalPinDown;
        BonusUtility.currentShotPinDown = currentShotPinDown;
        if (turnHelper == TurnHelper.STRIKE_ELIGIBLE) {
            return onFirstTurnHelperBonusAvailable();
        } else {
            return onSecondTurnHelperBonusAvailable();
        }
    }

    //@todo gutter and pin down can be easily combined to a single object
    @NotNull
    private static GameStrategies onFirstTurnHelperBonusAvailable() {

        StrikeRoll strikeRoll = new StrikeRoll(setNumber, turn, turnHelper, remainingPins, totalPinDown, currentShotPinDown);
        if (strikeRoll.validate()) {
            return strikeRoll;
        }
        GutterRoll gutterRoll = new GutterRoll(setNumber, turn, turnHelper, remainingPins, totalPinDown, currentShotPinDown);
        if (gutterRoll.validate()) {
            return gutterRoll;
        }
        return new PinDownRoll(setNumber, turn, turnHelper, remainingPins, totalPinDown, currentShotPinDown);
    }

    @NotNull
    private static GameStrategies onSecondTurnHelperBonusAvailable() {
        SpareRoll spareRoll = new SpareRoll(setNumber, turn, turnHelper, remainingPins, totalPinDown, currentShotPinDown);
        if (spareRoll.validate()) {
            return spareRoll;
        }
        GutterRoll gutterRoll = new GutterRoll(setNumber, turn, turnHelper, remainingPins, totalPinDown, currentShotPinDown);
        if (gutterRoll.validate()) {
            return gutterRoll;
        }
        return new PinDownRoll(setNumber, turn, turnHelper, remainingPins, totalPinDown, currentShotPinDown);
    }
}
