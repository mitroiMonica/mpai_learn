package curs.flyweight;

import java.util.HashMap;
import java.util.Map;

public class SolitaireCardFactory {
    private Map<String, AbstractSolitairePlayingCard> cards = new HashMap<>();

    public AbstractSolitairePlayingCard getCard(String card) {
        if (!cards.containsKey(card)) {
            cards.put(card, new SolitairePlayingCard(card, new byte[]{1, 2, 3}));
        }
        return cards.get(card);
    }
}
