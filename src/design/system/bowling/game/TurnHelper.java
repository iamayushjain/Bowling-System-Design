package design.system.bowling.game;

/**
 * TurnHelper types for the game
 * help us determine the eligibility of bonus type in each throw
 * STRIKE_ELIGIBLE(0), SPARE_ELIGIBLE(1)
 */

public enum TurnHelper {
    STRIKE_ELIGIBLE(0), SPARE_ELIGIBLE(1){
        @Override
        public TurnHelper next() {
            return null; // see below for options for this line throw exception
        };

    };
    private int turn;

    TurnHelper(int turn) {
        this.turn = turn;
    }

    public TurnHelper next() {
        // No bounds checking required here, because the last instance overrides
        return values()[ordinal() + 1];
    };

    public int getTurn() {
        return this.turn;
    }
}
