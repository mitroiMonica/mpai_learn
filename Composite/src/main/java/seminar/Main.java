package seminar;

import seminar.composite.EmailAddress;
import seminar.composite.EmailGroup;
import seminar.composite.EmailReceiver;

public class Main {
    public static void main(String[] args) {
        EmailReceiver receiver = new EmailAddress("ana@yahoo.com");
        EmailReceiver receiver2 = new EmailAddress("bogdan@yahoo.com");
        EmailReceiver group = new EmailGroup("group@yahoo.com");
        group.addReceiver(receiver);
        group.addReceiver(receiver2);
        group.receive("You have been poked on Facebook");
    }
}
