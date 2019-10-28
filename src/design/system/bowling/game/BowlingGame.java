package design.system.bowling.game;

import com.sun.istack.internal.NotNull;
import design.system.bowling.Constants;
import design.system.bowling.pojo.Player;
import design.system.bowling.exceptions.MinPlayerRequiredException;
import design.system.bowling.game.bo.SetUtility;
import design.system.bowling.pojo.GameLane;

import java.util.List;

/**
 * Bowling game logic File
 */
public class BowlingGame {
    private GameLane gameLane;
    private int counter = 0;

    public BowlingGame(@NotNull GameLane lane) throws Exception {
        this.gameLane = lane;
        if (gameLane.getPlayersCount() < Constants.MIN_PLAYER_PER_LANE)
            throw new MinPlayerRequiredException("Player not set in the game");
    }

    /**
     * Start the game
     */
    public void start() {
        List<Player> players = gameLane.getPlayers();
        while (counter < GameConstants.GAME_SETS) {
            for (Player player : players) {
                SetUtility frame = new SetUtility(player, counter);
                frame.takeTurn();
            }
            counter++;
            DisplayMessage.displayOnEachSetComplete();
        }
    }

    /**
     * declare winner with max score
     * O(n)
     *
     * @return string
     * @// TODO: 13/10/19 handle multiple winners
     */
    public String getWinner() {
        int maxScore = -1, score;
        String name = null;
        for (Player player : gameLane.getPlayers()) {
            score = player.getTotalScore();
            if (score > maxScore) {
                maxScore = player.getTotalScore();
                name = player.getPlayerName();
            }
        }
        return name;
    }
}
