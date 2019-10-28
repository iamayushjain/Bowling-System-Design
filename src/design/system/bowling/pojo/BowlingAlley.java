package design.system.bowling.pojo;

import design.system.bowling.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class for alley
 */
public class BowlingAlley {
    private List<BowlingLane> bowlingLanes = new ArrayList<>();
    private static BowlingAlley instance;

    private BowlingAlley() {
        initBowlingLanes();
    }

    private void initBowlingLanes() {
        for (int i = 1; i <= Constants.MAX_LANE; i++) {
            bowlingLanes.add(new GameLane(i));
        }
    }

    public static BowlingAlley getInstance() {
        if (instance == null) {
            synchronized (BowlingAlley.class) {
                if (instance == null) {
                    instance = new BowlingAlley();
                }
            }
        }
        return instance;
    }

    public List<BowlingLane> getBowlingLanes() {
        return bowlingLanes;
    }
}