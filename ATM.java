import java.util.Scanner;  // Import the Scanner class to read input from the user

// Define the ATM class
public class ATM {
    private BankAccount account;  // Declare a private variable to hold the bank account

    // Constructor for the ATM class that takes a BankAccount object as a parameter
    public ATM(BankAccount account) {
        this.account = account;  // Initialize the account variable with the provided bank account
    }

    // Method to start the ATM interface
    public void start() {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to read user input
        while (true) {  // Infinite loop to keep the ATM running until the user chooses to exit
            // Display the options to the user
            System.out.println("Welcome to the ATM. Please choose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();  // Read the user's choice

            // Perform an action based on the user's choice
            switch (choice) {
                case 1:
                    withdraw(scanner);  // Call the withdraw method
                    break;
                case 2:
                    deposit(scanner);  // Call the deposit method
                    break;
                case 3:
                    checkBalance();  // Call the checkBalance method
                    break;
                case 4:
                    // Exit the ATM
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();  // Close the scanner
                    return;  // Exit the method
                default:
                    // If the user enters an invalid option
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to handle withdrawals
    private void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();  // Read the amount to withdraw
        if (amount <= 0) {
            // If the amount is not positive
            System.out.println("Invalid amount. Please enter a positive number.");
        } else if (account.getBalance() >= amount) {
            // If there are sufficient funds
            account.withdraw(amount);  // Withdraw the amount from the account
            System.out.println("You have withdrawn $" + amount + ". Your new balance is $" + account.getBalance() + ".");
        } else {
            // If there are insufficient funds
            System.out.println("Insufficient funds. Your current balance is $" + account.getBalance() + ".");
        }
    }

    // Method to handle deposits
    private void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();  // Read the amount to deposit
        if (amount <= 0) {
            // If the amount is not positive
            System.out.println("Invalid amount. Please enter a positive number.");
        } else {
            account.deposit(amount);  // Deposit the amount into the account
            System.out.println("You have deposited $" + amount + ". Your new balance is $" + account.getBalance() + ".");
        }
    }

    // Method to check the balance
    private void checkBalance() {
        System.out.println("Your current balance is $" + account.getBalance() + ".");  // Display the current balance
    }

    // Main method to run the ATM program
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);  // Create a new bank account with an initial balance of $1000
        ATM atm = new ATM(account);  // Create a new ATM object with the bank account
        atm.start();  // Start the ATM interface
    }
}
