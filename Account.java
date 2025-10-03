import java.util.*;

public class Account {
    private String name;
    private int pin;
    private double balance;
    private List<String> transactions;

    public Account(String name, int pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public boolean authenticate(String name, int pin) {
        return this.name.equalsIgnoreCase(name) && this.pin == pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited ₹" + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add("Withdrew ₹" + amount);
            return true;
        }
        return false;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }
}
