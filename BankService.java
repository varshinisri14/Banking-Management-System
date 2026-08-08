import java.util.HashMap;
import java.util.Scanner;

public class BankService {

    HashMap<Integer, Account> accounts = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (accounts.containsKey(id)) {
            System.out.println("Account ID already exists.");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        accounts.put(id, new Account(id, name));

        System.out.println("Account Created Successfully.");
        System.out.println("Account ID: " + id);
        System.out.println("Customer Name: " + name);
    }

    public void deposit() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        if (!accounts.containsKey(id)) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        Account acc = accounts.get(id);
        acc.balance += amount;

        System.out.println("Deposit Successful.");
        System.out.println("Current Balance: ₹" + acc.balance);
    }

    public void withdraw() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        if (!accounts.containsKey(id)) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        Account acc = accounts.get(id);

        if (amount > acc.balance) {
            System.out.println("Insufficient Balance.");
            return;
        }

        acc.balance -= amount;

        System.out.println("Withdrawal Successful.");
        System.out.println("Current Balance: ₹" + acc.balance);
    }

    public void checkBalance() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        if (!accounts.containsKey(id)) {
            System.out.println("Account Not Found.");
            return;
        }

        Account acc = accounts.get(id);

        System.out.println("========== Account Details ==========");
        System.out.println("Account ID      : " + acc.id);
        System.out.println("Customer Name   : " + acc.customerName);
        System.out.println("Current Balance : ₹" + acc.balance);
        System.out.println("=====================================");
    }
    public void viewAllAccounts() {
    if (accounts.isEmpty()) {
        System.out.println("No accounts available.");
        return;
    }

    System.out.println("===== All Accounts =====");

    for (Account acc : accounts.values()) {
        System.out.println("ID: " + acc.id
                + " | Name: " + acc.customerName
                + " | Balance: ₹" + acc.balance);
    }
   }

    public void closeAccount() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        if (!accounts.containsKey(id)) {
            System.out.println("Account Not Found.");
            return;
        }

        Account acc = accounts.get(id);
        accounts.remove(id);

        System.out.println("Account of " + acc.customerName + " closed successfully.");
    }
}