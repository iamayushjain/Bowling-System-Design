package design.system.bowling.game;

/**
 * Turn types for the game
 * FIRST(0), SECOND(1), EXTRA_TURN(2)(special case)
 */
public enum Turn {
    FIRST(0), SECOND(1), EXTRA_TURN(2){
        @Override
        public Turn next() {
            return null; // see below for options for this line throw exception

        };

    };
    private int turn;

    Turn(int turn) {
        this.turn = turn;
    }

    public Turn next() {
        // No bounds checking required here, because the last instance overrides
        return values()[ordinal() + 1];
    };

    public int getTurn() {
        return this.turn;
    }
}
