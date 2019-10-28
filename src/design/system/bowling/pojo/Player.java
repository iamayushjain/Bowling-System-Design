package design.system.bowling.pojo;

import java.util.LinkedList;
import java.util.Map;

/**
 * Player pojo class
 *
 * @todo maintain history for the user
 */
@SuppressWarnings("unused")
public class Player {

    private final int playerId;
    private final String playerName;
    private int totalScore;
    private Map<Integer, LinkedList<String>> history;

    public Player(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void addScore(int score) {
        this.totalScore += score;
    }

    public void setScore(int score) {
        this.totalScore = score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
