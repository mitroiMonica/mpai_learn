package seminar.chain;

public abstract class CallCenterHandler {
    protected CallCenterHandler nextCenterHandler;

    public void setNextCenterHandler(CallCenterHandler nextCenterHandler) {
        this.nextCenterHandler = nextCenterHandler;
    }

    public abstract void refund(float sum);
}
