package seminar;

import seminar.flyweight.CustomCharacterFactory;
import seminar.flyweight.Position;
import seminar.flyweight.TextCharacter;

public class Main {
    public static void main(String[] args) {
        CustomCharacterFactory factory = new CustomCharacterFactory();
        TextCharacter c1 = factory.getChar('a');
        TextCharacter c2 = factory.getChar('b');
        TextCharacter c3 = factory.getChar('a');

        c2.display(new Position(1, 2));
        System.out.println(c1 == c3);
    }
}
