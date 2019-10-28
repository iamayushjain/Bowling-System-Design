package design.system.bowling;

import design.system.bowling.game.BookingUtility;
import design.system.bowling.game.BowlingGame;
import design.system.bowling.pojo.GameLane;
import design.system.bowling.pojo.Player;

/**
 * main class
 * post booking each game lane is a new thread
 *
 * @implNote 1) book the lane
 * 2) add players
 * 3) Start the game
 * 4) On finish display the winner
 * 5) Free the lane for new users
 */
public class BowlingGameExecutor {
    public static void main(String[] args) throws Exception {

        BookingUtility bookingUtility = new BookingUtility();
        bookingUtility.displayAvailableBowlingLane();
        GameLane gameLane = bookingUtility.bookLane(); //synchronized block

        gameLane
                .addPlayer(new Player(1, "user_1"))
                .addPlayer(new Player(2, "user_2"))
                .addPlayer(new Player(3, "user_3"));
        bookingUtility.displayAvailableBowlingLane();
        BowlingGame bowlingGame = new BowlingGame(gameLane);
        bowlingGame.start();

        System.out.println("Winner => " + bowlingGame.getWinner());

        bookingUtility.resetBowlingLane(gameLane.getID());// free the lane
        bookingUtility.displayAvailableBowlingLane();
    }
}
