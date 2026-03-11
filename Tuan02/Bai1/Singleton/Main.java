import game.Gameplay;
import game.SettingsScreen;

public class Main {

    public static void main(String[] args) {

        SettingsScreen screen = new SettingsScreen();
        screen.changeSettings();

        Gameplay gameplay = new Gameplay();
        gameplay.startGame();
    }
}