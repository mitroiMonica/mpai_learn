package simple_factory;

public class SpadePlatingCard extends PlayingCard {
    SpadePlatingCard(){
    }

    @Override
    public String toString() {
        return getRank() + "S";
    }
}
