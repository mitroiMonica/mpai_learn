package seminar.chain;

public class CallCenterOperator extends CallCenterHandler {
    @Override
    public void refund(float sum) {
        if (sum < 1000) {
            System.out.println("Refund approved by Operator [" + sum + "]");
        } else {
            if (nextCenterHandler != null) {
                nextCenterHandler.refund(sum);
            }
        }
    }
}
