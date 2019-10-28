package design.system.bowling.game.bo;

import com.sun.istack.internal.NotNull;
import design.system.bowling.game.Turn;
import design.system.bowling.game.TurnHelper;
import design.system.bowling.game.strategies.GameStrategies;

/**
 * Each shot for each set object
 * Responsible for the every throw
 */
public class ShotUtility {
    private SetUtility set;
    private int standingPins;

    public ShotUtility(@NotNull SetUtility frame) {
        this.set = frame;
        init();
    }

    private void init() {
        this.standingPins = set.getStandingPins();
    }

    /**
     * take shot
     */
    public void takeShot() {
        int numPinDown = randomPinFalls(standingPins);
        set.onPinDown(numPinDown);
        GameStrategies gameStrategies = BonusUtility.analyzeBonus(
                set.getSetNumber(), set.getTurn(), set.getTurnHelper(), set.getStandingPins(), set.getTotalPinDown(), numPinDown);
        onUtilizeShot(gameStrategies);
    }

    /**
     * action to be perform post shot taken
     *
     * @param gameStrategies GameStrategies
     */
    private void onUtilizeShot(GameStrategies gameStrategies) {
        gameStrategies.displayMessage(set.getPlayer());
        set.getPlayer().addScore(gameStrategies.getBonus());
        modifyPointer(gameStrategies.getNextTurn(), gameStrategies.getNextTurnHelper());
    }

    /**
     * set whether the set has shot or not
     * @param nextTurn Turn
     * @param nextTurnHelper TurnHelper
     */
    private void modifyPointer(Turn nextTurn, TurnHelper nextTurnHelper) {
        set.setTurn(nextTurn);
        set.setTurnHelper(nextTurnHelper);
        set.reloadIfExtraTurn();
    }

    /**
     * Random function to choose no of pin to be fall
     *
     * @param standingPins int
     * @return int
     */
    private int randomPinFalls(int standingPins) {
        return (int) (Math.random() * (standingPins + 1));
    }
}
