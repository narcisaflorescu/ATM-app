package org.tech.atm;
import java.util.Scanner;

public class Keypad {

    Scanner myObj = new Scanner(System.in);

    public int getInteger() {
        return myObj.nextInt();
    }

    public double getAmount() {
        return myObj.nextDouble();
    }


}
