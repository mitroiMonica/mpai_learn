import factory_method.AbstractDocument;
import factory_method.AbstractDocumentFactory;
import factory_method.DocumentType;
import factory_method.GoogleDocumentFactory;
import simple_factory.*;

public class Main {
    public static void main(String[] args) {
        AbstractPlayingCardFactory factory = new PlayingCardFactory();
        PlayingCard playingCard = factory.playCard(CardSuit.CLUB);
        System.out.println(playingCard);

        AbstractDocumentFactory documentFactory = new GoogleDocumentFactory();
        AbstractDocument document = documentFactory.getDocument(DocumentType.SPREADSHEET);
        document.setName("doc1");
        document.open();
    }
}
