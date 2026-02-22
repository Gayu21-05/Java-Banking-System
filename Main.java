import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== Banking Management System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    accounts.add(new BankAccount(accNo, name, balance));
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();
                    BankAccount account = findAccount(accounts, accNo);

                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = sc.nextDouble();
                        account.deposit(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();
                    account = findAccount(accounts, accNo);

                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = sc.nextDouble();
                        account.withdraw(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();
                    account = findAccount(accounts, accNo);

                    if (account != null) {
                        account.checkBalance();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();
                    account = findAccount(accounts, accNo);

                    if (account != null) {
                        account.displayDetails();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using Banking System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    public static BankAccount findAccount(ArrayList<BankAccount> accounts, int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }
}
