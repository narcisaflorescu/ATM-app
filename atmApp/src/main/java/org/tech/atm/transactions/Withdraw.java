package org.tech.atm.transactions;
import org.tech.atm.Account;
import org.tech.atm.CashDispenser;
import org.tech.atm.Screen;

import java.util.ArrayList;
import java.util.List;

public class Withdraw implements Transactions {

    private final ArrayList<Double> amountList = new ArrayList<>(List.of(20.0, 40.0, 60.0, 100.0, 200.0));
    private CashDispenser cashDispenser;
    private final Screen screen = new Screen();

    //public Withdraw() {
    //}
    public Withdraw(CashDispenser cashDispenser) {
        this.cashDispenser = cashDispenser;
    }

    @Override
    public void execute(Account account, double amount) {
        if(account.getBalance() < amount) {
            screen.showMessage("Sold insufficient");
            return;
        }

        if (!amountList.contains(amount)) {
            screen.showMessage("Invalid amount, please choose one from list");
            return;
        }

        if (cashDispenser.verifyDisponibility(amount)) {
            account.setBalance(account.getBalance() - amount);
        }
        System.out.println("Sold: " + account.getBalance());

    }
}
