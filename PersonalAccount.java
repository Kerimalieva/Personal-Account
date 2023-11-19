import java.util.Scanner;

public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private Amount[] transactions;
    private int transactionCount;

    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new Amount[10]; // maximum transactions
        this.transactionCount = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions[transactionCount++] = new Amount(amount, "Deposit");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Cannot withdraw. Insufficient balance.");
        } else {
            balance -= amount;
            transactions[transactionCount++] = new Amount(amount, "Withdrawal");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for Account Number: " + accountNumber);
        for (int i = 0; i < transactionCount; i++) {
            Amount transaction = transactions[i];
            System.out.println(transaction.getTransactionType() + ": " + transaction.getAmount());
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolder = scanner.nextLine();

        PersonalAccount account = new PersonalAccount(accountNumber, accountHolder);

        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);

        System.out.print("Enter withdrawal amount: ");
        double withdrawalAmount = scanner.nextDouble();

        try {
            account.withdraw(withdrawalAmount);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        account.printTransactionHistory();
        System.out.println("Current Balance: " + account.getBalance());


        scanner.close();
    }
}
