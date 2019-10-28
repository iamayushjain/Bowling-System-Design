package design.system.bowling.exceptions;

/**
 * Exception Super Class related to BowlingLane
 * access as private package
 */
@SuppressWarnings("unused")
public class LaneException extends Exception {
    LaneException() {
    }

    LaneException(String s) {
        super(s);
    }
}
