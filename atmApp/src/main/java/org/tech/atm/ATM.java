package org.tech.atm;
import org.tech.atm.transactions.Deposit;
import org.tech.atm.transactions.Withdraw;
import org.tech.atm.transactions.Transactions;


public class ATM {
    private final Keypad keypad;
    private final Screen screen;
    private Account currentUser;
    private final BankDatabase bankDatabase;
    private final CashDispenser cashDispenser;

    public ATM() {
        bankDatabase = new BankDatabase();
        keypad = new Keypad();
        screen = new Screen();
        cashDispenser = new CashDispenser();
    }

    public void startActions() {
        while(true) {
            if (currentUser == null) {
                loginAction();
                continue;
            }

            if(!executeAction()) {
                return;
            }
        }


    }

    private boolean executeAction() {
        screen.showOptions();
        screen.showMessage("Insert an option from menu: ");
        int option = keypad.getInteger();
        switch (option) {
            case 1:
                System.out.println("Sold: " + currentUser.getBalance());
                break;
            case 2:
                executeTransaction(new Deposit());
                break;
            case 3:
                executeTransaction(new Withdraw(cashDispenser));
                break;
            case 4:
                currentUser = null;
                break;
            case 5:
                return false;
            default:
                screen.showMessage("Invalid option");
                break;
        }

        return true;

    }

    private void executeTransaction(Transactions transaction) {
        if (transaction instanceof Withdraw)
            screen.showAmountList();
        screen.showMessage("Introduce the amount");
        double amount =  keypad.getAmount();
        transaction.execute(currentUser, amount);

    }
    private void loginAction() {
        screen.showMessage("Insert your account number and pin");
        int accountNo = keypad.getInteger();
        int pin = keypad.getInteger();
        currentUser = bankDatabase.verify_and_get_account(accountNo, pin);
    }





}
