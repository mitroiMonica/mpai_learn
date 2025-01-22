package curs;

import curs.decorator.AbstractPlayingCard;
import curs.decorator.AdvantagePlayingCard;
import curs.decorator.BonusPlayingCard;
import curs.decorator.PlayingCard;

public class Main {
    public static void main(String[] args) {
        PlayingCard normalCard = new PlayingCard();
        normalCard.setValue(5);
        normalCard.play();

        BonusPlayingCard bonusCard = new BonusPlayingCard(normalCard);
        bonusCard.setBonusPoints(2);

        AdvantagePlayingCard advantageCard = new AdvantagePlayingCard(bonusCard);
        advantageCard.givePenalty("George");
    }
}
