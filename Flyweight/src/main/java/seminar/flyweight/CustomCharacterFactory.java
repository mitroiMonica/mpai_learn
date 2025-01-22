package seminar.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CustomCharacterFactory {
    private Map<Character, TextCharacter> chars = new HashMap<>();

    public TextCharacter getChar(Character character) {
        if (!chars.containsKey(character)) {
            chars.put(character, new CustomTextCharacter(character, new byte[]{1, 2, 3}));
        }
        return chars.get(character);
    }
}
