package design.system.bowling.exceptions;

/**
 * Exception when no lane is free to book
 */
@SuppressWarnings("unused")
public class AllLaneOccupiedException extends LaneException {
    public AllLaneOccupiedException(String s) {
        super(s);
    }
}
