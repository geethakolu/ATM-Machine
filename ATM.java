import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private static List<Account> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeAccounts();
        while (true) {
            System.out.println("\n===== ATM Machine =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 5) break;

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Account account = findAccount(name, pin);
            if (account == null) {
                System.out.println("Invalid name or PIN.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Balance: ₹" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Transaction History:");
                    for (String txn : account.getTransactions()) {
                        System.out.println("- " + txn);
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        System.out.println("Thank you for using the ATM.");
    }

    private static Account findAccount(String name, int pin) {
        for (Account acc : accounts) {
            if (acc.authenticate(name, pin)) return acc;
        }
        return null;
    }

    private static void initializeAccounts() {
        accounts.add(new Account("Ravi", 1234, 5000));
        accounts.add(new Account("Priya", 2345, 7000));
        accounts.add(new Account("Suresh", 3456, 10000));
        accounts.add(new Account("Anita", 4567, 3000));
        accounts.add(new Account("Kiran", 5678, 8500));
        accounts.add(new Account("Meena", 6789, 12000));
        accounts.add(new Account("Vamsi", 7890, 4500));
        accounts.add(new Account("Rohit", 8901, 6000));
        accounts.add(new Account("Sonia", 9012, 9000));
        accounts.add(new Account("Neha", 1122, 11000));
    }
}
