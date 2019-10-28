package design.system.bowling.pojo;

/**
 * Game lane pojo class
 */
public class BowlingLane {

    private final int id;
    private boolean isOccupied;

    protected BowlingLane(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public boolean isLaneOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
