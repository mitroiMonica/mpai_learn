package curs.chain;

public class Player extends AbstractPlayer {
    private String cardToBePlayed;

    public void setCardToBePlayed(String cardToBePlayed) {
        this.cardToBePlayed = cardToBePlayed;
    }

    @Override
    public void playCard(String currentCard) {
        boolean isSameNumber = currentCard.charAt(0) == cardToBePlayed.charAt(0);
        boolean isSameType = currentCard.charAt(1) == cardToBePlayed.charAt(1);
        if (isSameNumber || isSameType) {
            System.out.println(cardToBePlayed + " has been played ");
        } else {
            if (nextPlayer != null) {
                nextPlayer.playCard(currentCard);
            }
        }
    }
}
