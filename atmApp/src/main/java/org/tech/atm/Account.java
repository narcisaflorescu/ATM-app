package org.tech.atm;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

public class Account {

    @Getter
    private int accountNo;
    protected int pin;
    @Getter @Setter
    private double balance;

    public Account(int a, double b, int p) {
        accountNo = a;
        balance = b;
        pin = p;
    }

    @Override
    public String toString() {
        return "user: " + getAccountNo() + ", balance: " + getBalance();
    }


}
