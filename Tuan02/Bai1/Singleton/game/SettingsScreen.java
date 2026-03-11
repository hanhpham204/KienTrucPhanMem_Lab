package game;

import singleton.GameSettings;

public class SettingsScreen {

    public void changeSettings(){
        GameSettings settings = GameSettings.getInstance();
        settings.setDifficulty("Hard");
    }
}