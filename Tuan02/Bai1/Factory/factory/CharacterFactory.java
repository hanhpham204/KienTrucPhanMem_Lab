package factory;

public class CharacterFactory {

    public static Character createCharacter(String type) {

        if(type.equalsIgnoreCase("warrior")){
            return new Warrior();
        }

        if(type.equalsIgnoreCase("mage")){
            return new Mage();
        }

        if(type.equalsIgnoreCase("archer")){
            return new Archer();
        }

        return null;
    }
}