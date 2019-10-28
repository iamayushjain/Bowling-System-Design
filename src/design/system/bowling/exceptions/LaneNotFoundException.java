package design.system.bowling.exceptions;

/**
 * Exception class for invalid lane id
 *
 * @implNote used to reset the game lane after the match is over.
 */
@SuppressWarnings("unused")
public class LaneNotFoundException extends LaneException {
    public LaneNotFoundException(String s) {
        super(s);
    }
}
