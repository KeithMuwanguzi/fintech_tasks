import java.util.Scanner;

/** Muwanguzi Keith Jonathan
 *  BankAccount class implemented with Java OOP
 * To be able to bundle it, please first rename the file to BankAccount so that it can match with the public class name
 **/
public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private static final double INTEREST_RATE = 0.05; // 5% interest rate

    //Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    //Getters and setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    //Method to deposit money, preventing negative deposits
    public void deposit(double amount) {
        if (amount > 0) {
            double newBalance = balance + amount;
            setBalance(newBalance);
            System.out.println("Deposit of UGX" + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    //Method to withdraw, no withdrawing more than the balance
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            double newBalance = balance - amount;
            setBalance(newBalance);
            System.out.println("Withdrawal of UGX" + amount + " successful.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }


    //Prints the balance of the account
    public void printBalance() {
        System.out.println("Account balance: UGX" + getBalance());
    }

    //Calculating the interest
    public void calculateAndApplyInterest() {
        double interest = balance * INTEREST_RATE;
        double newBalance = balance + interest;
        setBalance(newBalance);
        System.out.println("Interest of UGX" + interest + " applied. New balance: UGX" + getBalance());
    }

    public void runATM() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        String shortName = getAccountHolder().split(" ").length > 1 ? getAccountHolder().split(" ")[1] : getAccountHolder();

        System.out.println("Hello "+shortName+" Welcome to the ATM interface!");
        System.out.println("Account Number: "+getAccountNumber());
        while (running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Apply Interest");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> printBalance();
                case 2 -> {
                    System.out.print("Enter deposit amount: UGX");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                }
                case 3 -> {
                    System.out.print("Enter withdrawal amount: UGX");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                }
                case 4 -> calculateAndApplyInterest();
                case 5 -> {
                    running = false;
                    System.out.println("Thank you for using our ATM. Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        BankAccount accountOne = new BankAccount("RHCEADB:123X321-78","Muwanguzi Keith Jonathan",0);
        accountOne.runATM();
    }
}
