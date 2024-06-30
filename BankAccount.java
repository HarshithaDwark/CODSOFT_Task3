public class BankAccount {
    // This private variable holds the balance of the bank account.
    private double balance;

    // Constructor that initializes the balance with an initial amount.
    public BankAccount(double initialBalance) {
        // Check if the initial balance is negative, and if so, throw an exception.
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        // Set the balance to the initial amount provided.
        this.balance = initialBalance;
    }

    // Method to get the current balance of the bank account.
    public double getBalance() {
        return balance;
    }

    // Method to withdraw an amount from the bank account.
    public void withdraw(double amount) {
        // Check if the amount to be withdrawn is greater than the current balance, and if so, throw an exception.
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        // Subtract the amount from the balance.
        balance -= amount;
    }

    // Method to deposit an amount into the bank account.
    public void deposit(double amount) {
        // Check if the amount to be deposited is less than or equal to zero, and if so, throw an exception.
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        // Add the amount to the balance.
        balance += amount;
    }
}
