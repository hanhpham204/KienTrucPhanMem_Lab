package factory;

public class Mage implements Character {

    @Override
    public void attack() {
        System.out.println("Mage casts a spell");
    }
}