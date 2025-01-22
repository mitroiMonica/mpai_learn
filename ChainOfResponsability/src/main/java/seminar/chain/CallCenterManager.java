package seminar.chain;

public class CallCenterManager extends CallCenterHandler {

    @Override
    public void refund(float sum) {
        if (sum < 10000) {
            System.out.println("Refund approved by Manager [" + sum + "]");
        } else {
            if (nextCenterHandler != null) {
                nextCenterHandler.refund(sum);
            }
        }
    }
}
