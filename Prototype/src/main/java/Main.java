import prototype_curs.SolitairePlayingCard;
import prototype_seminar.BuildingBlock;
import prototype_seminar.PrototypeCollection;
import prototype_seminar.WoodBlock;

public class Main {
    public static void main(String[] args) {
        BuildingBlock block1 = new WoodBlock();
        block1.setX(1);
        block1.setY(2);
        block1.setZ(3);
        block1.render();

        try {
            BuildingBlock block2 = (BuildingBlock) block1.clone();
            block2.setX(5);
            block2.setY(10);
            block2.setZ(15);
            block2.render();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        PrototypeCollection prototypeCollection =
                new PrototypeCollection();
        BuildingBlock block3 =
                prototypeCollection.getCloneBuildingBlock("stone");
        BuildingBlock block4 =
                prototypeCollection.getCloneBuildingBlock("wood");
        block3.render();
        block4.render();

        
        SolitairePlayingCard solitairePlayingCard = new SolitairePlayingCard();
        solitairePlayingCard.setRank(7);
        solitairePlayingCard.setSuit('H');
        solitairePlayingCard.setX(1);
        solitairePlayingCard.setY(1);
        solitairePlayingCard.render();

        try {
            SolitairePlayingCard secondCard = solitairePlayingCard.clone();
            secondCard.setX(2);
            secondCard.setY(2);
            secondCard.render();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}
