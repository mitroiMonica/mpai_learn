package seminar;

import seminar.template.PartMover;
import seminar.template.Worker;

public class Main {
    public static void main(String[] args) {
        PartMover mover = new Worker();
        mover.movePart();
    }
}
