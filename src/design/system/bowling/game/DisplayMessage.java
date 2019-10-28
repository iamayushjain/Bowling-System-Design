package design.system.bowling.game;

import design.system.bowling.pojo.Player;

/**
 * display wrapper for each turn
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class DisplayMessage {
    final static String STRIKE_MESSAGE = "Strike !!!!!! by %s";
    final static String SPARE_MESSAGE = "Spare !!!!! by %s";
    final static String MULTIPLE_PIN_DOWN_MESSAGE = "%d pinned down by %s";
    final static String NO_PIN_DOWN_MESSAGE = "GUTTER !!!!! by %s";


    public static void displayStrikeMessage(Player player, int setNumber) {
        System.out.println((setNumber + 1) + "=>" + String.format(DisplayMessage.STRIKE_MESSAGE, player.getPlayerName()));
    }

    public static void displaySpareMessage(Player player, int setNumber) {
        System.out.println((setNumber + 1) + "=>" + String.format(DisplayMessage.SPARE_MESSAGE, player.getPlayerName()));
    }

    public static void displayPinDownMessage(Player player, int pinDowns, int setNumber) {
        System.out.println((setNumber + 1) + "=>" + String.format(DisplayMessage.MULTIPLE_PIN_DOWN_MESSAGE, pinDowns, player.getPlayerName()));
    }

    public static void displayGutterMessage(Player player, int setNumber) {
        System.out.println((setNumber + 1) + "=>" + String.format(DisplayMessage.NO_PIN_DOWN_MESSAGE, player.getPlayerName()));
    }

    public static void displayOnEachSetComplete() {
        System.out.println("---------------------");
    }
}
