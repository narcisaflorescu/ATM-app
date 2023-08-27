package org.tech.atm;
import lombok.Getter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class BankDatabase {

    @Getter
    private final ArrayList<Account> users = new ArrayList<>();
    private final Screen screen = new Screen();


    public BankDatabase() {
        /*
        users.add(new Account(1, 11, 20));
        users.add(new Account(2, 22, 30));
         */

        loadDataBase();
    }


    private void loadDataBase() {
        String file = "C:\\Users\\ABC\\IdeaProjects\\atmApp\\src\\ExcelReader.csv";
        BufferedReader reader = null;
        String line;
        int accountNo, pin;
        double balance;

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                accountNo = Integer.parseInt(row[1]);
                balance = Double.parseDouble(row[2]);
                pin = Integer.parseInt(row[3]);
                Account a1 = new Account(accountNo, balance, pin);
                users.add(a1);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Account verify_and_get_account(int accountNo, int pin) {
        loadDataBase();
        Account account = null;
        for (Account user : users) {
            if (user.getAccountNo() == accountNo)
                if (user.pin == pin) {
                    screen.showMessage("Successfully login");
                    return user;
                }
        }

        screen.showMessage("Invalid data");
        return account;
    }

}

