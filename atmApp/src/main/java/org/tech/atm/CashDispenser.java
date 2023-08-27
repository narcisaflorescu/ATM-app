package org.tech.atm;

public class CashDispenser {
    private int no_of_bills = 5;
    private final Screen screen = new Screen();

    public boolean verifyDisponibility(double amount) {
        double VALUE_OF_BILL = 20.0;
        if (amount/ VALUE_OF_BILL <= no_of_bills) {
            no_of_bills -= amount/ VALUE_OF_BILL;
            return true;
        }

        screen.showMessage("Insufficient bills");
        return false;
    }
}
