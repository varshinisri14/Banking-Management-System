import java.util.Scanner;

public class BankConsoleApp {

    public static void main(String[] args) {

        BankService bank = new BankService();
        Scanner sc = new Scanner(System.in);

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
                    bank.createAccount();
                    break;

                case 2:
                    bank.deposit();
                    break;

                case 3:
                    bank.withdraw();
                    break;

                case 4:
                    bank.checkBalance();
                    break;

                case 5:
                    bank.closeAccount();
                    break;

                case 6:
                    System.out.println("Thank You");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}