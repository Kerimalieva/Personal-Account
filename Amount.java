import java.util.ArrayList;
class Amount {
    private double amount;
    private String transactionType;

    public Amount(double amount, String transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }
}