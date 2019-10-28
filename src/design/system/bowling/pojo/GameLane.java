package design.system.bowling.pojo;

import com.sun.istack.internal.NotNull;
import design.system.bowling.Constants;
import design.system.bowling.exceptions.MaxPlayerExceededException;

import java.util.ArrayList;
import java.util.List;

/**
 * Game lane pojo class
 */
public class GameLane extends BowlingLane {

    private List<Player> players = new ArrayList<>();

    GameLane(int id) {
        super(id);
    }

    public GameLane(BowlingLane bowlingLane) {
        super(bowlingLane.getID());
    }

    public GameLane addPlayer(Player player) throws MaxPlayerExceededException {
        if (players.size() >= Constants.MAX_PLAYER_PER_LANE)
            throw new MaxPlayerExceededException("Sorry! lane can't have more than " + Constants.MAX_PLAYER_PER_LANE + " players");
        players.add(player);
        return this;
    }

    @NotNull
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayersCount() {
        return players.size();
    }


}
