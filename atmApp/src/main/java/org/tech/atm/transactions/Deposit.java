package org.tech.atm.transactions;

import org.tech.atm.Account;

public class Deposit implements Transactions {
    @Override
    public void execute(Account account, double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Sold: " + account.getBalance());
    }
}
