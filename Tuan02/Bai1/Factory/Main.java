import factory.Character;
import factory.CharacterFactory;

public class Main {

    public static void main(String[] args) {

        Character c1 = CharacterFactory.createCharacter("warrior");
        c1.attack();

        Character c2 = CharacterFactory.createCharacter("mage");
        c2.attack();

        Character c3 = CharacterFactory.createCharacter("archer");
        c3.attack();
    }
}