package design.system.bowling.exceptions;

/**
 * Exception when max player exceeded in a game lane
 */
@SuppressWarnings("unused")
public class MaxPlayerExceededException extends Exception {
    public MaxPlayerExceededException(String s) {
        super(s);
    }
}
