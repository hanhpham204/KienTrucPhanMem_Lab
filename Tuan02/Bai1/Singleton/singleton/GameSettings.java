package singleton;

public class GameSettings {

    private static GameSettings instance;

    private String sound;
    private String difficulty;
    private String graphics;

    private GameSettings() {
        sound = "On";
        difficulty = "Normal";
        graphics = "High";
    }

    public static GameSettings getInstance() {
        if(instance == null){
            instance = new GameSettings();
        }
        return instance;
    }

    public void setSound(String sound){
        this.sound = sound;
    }

    public void setDifficulty(String difficulty){
        this.difficulty = difficulty;
    }

    public void setGraphics(String graphics){
        this.graphics = graphics;
    }

    public void showSettings(){
        System.out.println("Sound: " + sound);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Graphics: " + graphics);
    }
}