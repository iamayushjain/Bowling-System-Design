package design.system.bowling.exceptions;

/**
 * Exception when max player exceeded in a game lane
 */
@SuppressWarnings("unused")
public class MinPlayerRequiredException extends Exception {
    public MinPlayerRequiredException(String s) {
        super(s);
    }
}
