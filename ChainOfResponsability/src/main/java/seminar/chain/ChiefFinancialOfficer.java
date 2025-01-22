package seminar.chain;

public class ChiefFinancialOfficer extends CallCenterHandler {
    @Override
    public void refund(float sum) {
        System.out.println("Refund approved by Chief [" + sum + "]");
    }
}
