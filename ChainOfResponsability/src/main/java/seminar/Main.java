package seminar;

import seminar.chain.CallCenterHandler;
import seminar.chain.CallCenterManager;
import seminar.chain.CallCenterOperator;
import seminar.chain.ChiefFinancialOfficer;

public class Main {
    public static void main(String[] args) {
        CallCenterHandler operator = new CallCenterOperator();
        CallCenterHandler manager = new CallCenterManager();
        CallCenterHandler officer = new ChiefFinancialOfficer();

        operator.setNextCenterHandler(manager);
        manager.setNextCenterHandler(officer);

        operator.refund(20000);

    }
}
