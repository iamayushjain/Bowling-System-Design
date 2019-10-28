package design.system.bowling.game;

import design.system.bowling.exceptions.AllLaneOccupiedException;
import design.system.bowling.exceptions.LaneException;
import design.system.bowling.Constants;
import design.system.bowling.exceptions.LaneNotFoundException;
import design.system.bowling.pojo.BowlingAlley;
import design.system.bowling.pojo.BowlingLane;
import design.system.bowling.pojo.GameLane;

import java.util.ArrayList;
import java.util.List;

/**
 * Concurrent class to book a lane
 * after the game reset the lane and remove players
 */
public class BookingUtility {
    private BowlingAlley bowlingAlley;

    public BookingUtility() {
        this.bowlingAlley = BowlingAlley.getInstance();
    }

    /**
     * maintain concurrency
     * pick the first available lane
     *
     * @return GameLane
     * @throws LaneException laneException
     * @// TODO: 13/10/19  add to choose lane by Lane number
     */
    public synchronized GameLane bookLane() throws LaneException {
        for (BowlingLane lane : bowlingAlley.getBowlingLanes()) {
            if (!lane.isLaneOccupied()) {

                lane.setOccupied(true);
                return (GameLane) lane;
            }
        }
        throw new AllLaneOccupiedException(Constants.NO_LANE_FREE);
    }

    // get free lanes
    private List<BowlingLane> availableBowlingLane() {
        List<BowlingLane> availableLanes = new ArrayList<>();
        for (BowlingLane lane : bowlingAlley.getBowlingLanes()) {
            if (!lane.isLaneOccupied()) {
                availableLanes.add(lane);
            }
        }
        return availableLanes;
    }

    // to print free lanes
    public void displayAvailableBowlingLane() {
        StringBuilder s = new StringBuilder();
        for (BowlingLane lane : availableBowlingLane()) {
            s.append(lane.getID()).append(", ");
        }
        System.out.println("Available lanes: " + s);
    }

    // reset the lane once the game is done
    public void resetBowlingLane(int id) throws LaneException {
        GameLane gameLane = getBowlingLaneById(id);
        gameLane.setOccupied(false);
        gameLane.setPlayers(new ArrayList<>());
    }

    private GameLane getBowlingLaneById(int id) throws LaneException {
        for (BowlingLane l : bowlingAlley.getBowlingLanes()) {
            if (l.getID() == id) {
                return (GameLane) l;
            }
        }
        throw new LaneNotFoundException("Entered lane id is invalid.");
    }
}
