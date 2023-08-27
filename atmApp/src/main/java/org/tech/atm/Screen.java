package org.tech.atm;

public class Screen {

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showOptions() {
        System.out.println("___________________");
        System.out.println("Choose one option:");
        System.out.println("1: View my balance");
        System.out.println("2: Deposit");
        System.out.println("3: Withdraw");
        System.out.println("4: Log out");
        System.out.println("5: Exit");
        System.out.println("___________________");
    }

    public void showAmountList() {
        System.out.println("Choose to withdraw 20$, 40$, 60$, 100$ or 200$");
    }
}
