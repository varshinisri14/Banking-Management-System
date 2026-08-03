import java.util.*;

class Account {
    int id;
    String customerName;
    double balance;

    Account(int id, String customerName) {
        this.id = id;
        this.customerName = customerName;
        this.balance = 0;
    }
}

public class BankConsoleApp {

    static HashMap<Integer, Account> accounts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void createAccount() {
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

    public static void deposit() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        if (!accounts.containsKey(id)) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        Account acc = accounts.get(id);
        acc.balance += amount;

        System.out.println("Deposit Successful.");
        System.out.println("Account Holder: " + acc.customerName);
        System.out.println("Current Balance: ₹" + acc.balance);
    }

    public static void withdraw() {
        System.out.print("Enter Account ID: ");
        int id = sc.nextInt();

        if (!accounts.containsKey(id)) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        Account acc = accounts.get(id);

        if (amount > acc.balance) {
            System.out.println("Insufficient Balance.");
            return;
        }

        acc.balance -= amount;

        System.out.println("Withdrawal Successful.");
        System.out.println("Account Holder: " + acc.customerName);
        System.out.println("Current Balance: ₹" + acc.balance);
    }

    public static void checkBalance() {
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

    public static void closeAccount() {
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

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== SecureBank =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Close Account");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    closeAccount();
                    break;

                case 6:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}