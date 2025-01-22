package seminar.composite;

import java.util.ArrayList;
import java.util.List;

public class EmailGroup implements EmailReceiver {
    private List<EmailReceiver> receivers = new ArrayList<>();
    private String groupName;

    public EmailGroup(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public void receive(String text) {
        System.out.println(groupName + ": ");
        for (EmailReceiver r : receivers) {
            r.receive(text);
        }
    }

    @Override
    public void addReceiver(EmailReceiver receiver) {
        receivers.add(receiver);
    }

    @Override
    public void deleteReceiver(EmailReceiver receiver) {
        receivers.remove(receiver);
    }

    @Override
    public EmailReceiver getReceiver(int index) {
        if (index < 0 || index > receivers.size()) {
            throw new UnsupportedOperationException();
        }
        return receivers.get(index);
    }
}
