package factory;

public class Warrior implements Character {

    @Override
    public void attack() {
        System.out.println("Warrior attacks with sword");
    }
}