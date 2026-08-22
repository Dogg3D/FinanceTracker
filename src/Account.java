import java.util.ArrayList;

public class Account {
    private double balance = 0;
    private double totalIncome = 0;
    private double totalExpenses = 0;
    private String name;
    private int numTransactions = 0;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Account(String name) {
        this.name = name;
    }

    public void checkBalance() {
        System.out.printf("%nCurrent balance: %.2f%n", this.balance);
    }

    public void addTransaction(Transaction trans) {
        double amount = trans.getAmount();
        this.numTransactions++;
        transactions.add(trans);

        this.balance += amount;
        if (amount < 0) {
            this.totalExpenses -= amount;
        } else {
            this.totalIncome += amount;
        }
    }

    public void getTransactionHistory() {
        System.out.println();
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }

    @Override
    public String toString() {
        return String.format("%nAccount Name: %s%nCurrent Balance: %.2f", this.name, this.balance);
    }
}
