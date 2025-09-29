import java.util.ArrayList;
import java.util.Scanner;

// Account class
class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
            System.out.println(" Deposited " + amount);
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " | Balance: " + balance);
            System.out.println("Withdrew " + amount);
        } else if (amount > balance) {
            System.out.println(" Insufficient balance.");
        } else {
            System.out.println(" Invalid withdraw amount.");
        }
    }

    // Display balance
    public void displayBalance() {
        System.out.println(" Current Balance: " + balance);
    }

    // Display transaction history
    public void displayTransactionHistory() {
        System.out.println("\n Transaction History:");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
}

// Main class
public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating account
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Account account = new Account(name, balance);
        int choice;

        // Menu-driven simulation
        do {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    account.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    account.withdraw(sc.nextDouble());
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    account.displayTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using our bank!");
                    break;
                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
