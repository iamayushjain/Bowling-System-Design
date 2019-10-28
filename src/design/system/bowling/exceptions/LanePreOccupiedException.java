package design.system.bowling.exceptions;

/**
 * Exception class when concurrency fails in lane booking
 *
 * @todo add concurrency fails logic
 */
@SuppressWarnings("unused")
public class LanePreOccupiedException extends LaneException {
    public LanePreOccupiedException(String s) {
        super(s);
    }
}
