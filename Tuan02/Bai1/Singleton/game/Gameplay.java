package game;

import singleton.GameSettings;

public class Gameplay {

    public void startGame(){
        GameSettings settings = GameSettings.getInstance();
        System.out.println("Gameplay using settings:");
        settings.showSettings();
    }
}