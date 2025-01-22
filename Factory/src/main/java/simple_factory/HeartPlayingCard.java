package simple_factory;

public class HeartPlayingCard extends PlayingCard {
    HeartPlayingCard(){
    }

    @Override
    public String toString() {
        return getRank() + "H";
    }
}
