package design.system.bowling.game.bo;

import design.system.bowling.Constants;
import design.system.bowling.game.GameConstants;
import design.system.bowling.game.Turn;
import design.system.bowling.game.TurnHelper;
import design.system.bowling.pojo.Player;


/**
 * Each set object
 * Contains a brief snapshot for the game condition
 */
public class SetUtility {
    private int standingPins;
    private int totalPinDown;
    private Player player;
    private Turn turn;
    private TurnHelper turnHelper; // helper object for dealing with logic such as last turn etc.
    private int setNumber;

    public SetUtility(Player player, int setNumber) {
        this.player = player;
        this.setNumber = setNumber;
        init();
    }

    /**
     * load pins
     */
    private void init() {
        standingPins = GameConstants.MAX_PINS;
        totalPinDown = 0;
        turn = Turn.FIRST;
        turnHelper = TurnHelper.STRIKE_ELIGIBLE;
    }

    /**
     * handle extra turn reloading
     */
    public void reloadIfExtraTurn() {
        if (isFinalSet() && turn != null && turnHelper != null && turnHelper == TurnHelper.STRIKE_ELIGIBLE) {
            standingPins = GameConstants.MAX_PINS;
            totalPinDown = 0;
        }
    }

    /**
     * take multiple turn
     */
    public void takeTurn() {
        while (isHasShots()) {
            ShotUtility shotUtility = new ShotUtility(this);
            shotUtility.takeShot();
        }
    }

    /**
     * modify scores
     *
     * @param numPinDown int
     */
    public void onPinDown(int numPinDown) {
        addTotalPinDown(numPinDown);
        reduceStandingPins(numPinDown);
        player.addScore(numPinDown);
    }

    /**
     * generic function to determine whether uses has turn left.. this function will remain unchanged if we add new GameStrategies
     *
     * @return boolean
     */
    private boolean isHasShots() {
        if (turn == null || turnHelper == null)
            return false;
        return (turn.getTurn() < (!isFinalSet() ? GameConstants.CHANCES_PER_TURN : GameConstants.CHANCES_PER_TURN_FINAL_SET))
                && (totalPinDown < GameConstants.MAX_PINS);
    }

    private void addTotalPinDown(int numPinDown) {
        totalPinDown += numPinDown;
    }

    private void reduceStandingPins(int numPinDown) {
        standingPins -= numPinDown;
    }

    private boolean isFinalSet() {
        return (setNumber == Constants.MAX_LANE - 1);
    }

    public int getSetNumber() {
        return setNumber;
    }

    public int getStandingPins() {
        return standingPins;
    }

    public int getTotalPinDown() {
        return totalPinDown;
    }

    public Turn getTurn() {
        return turn;
    }

    public TurnHelper getTurnHelper() {
        return turnHelper;
    }

    public Player getPlayer() {
        return player;
    }

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public void setTurnHelper(TurnHelper turnHelper) {
        this.turnHelper = turnHelper;
    }


}
