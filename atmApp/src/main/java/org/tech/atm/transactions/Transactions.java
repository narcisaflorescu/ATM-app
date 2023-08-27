package org.tech.atm.transactions;

import org.tech.atm.Account;

public interface Transactions {

    //method
    void execute(Account account, double amount);

}
