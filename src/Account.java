public class Account {
    private double balance = 0;
    private double totalIncome = 0;
    private double totalExpenses = 0;
    private String name;
    private int numTransactions = 0;

    public Account(String name) {
        this.name = name;
    }

    public void checkBalance() {
        System.out.println("Current balance: " + this.balance);
    }

    public void addTransaction(Transaction trans) {
        double amount = trans.getAmount();
        this.numTransactions++;

        this.balance += amount;
        if (amount < 0) {
            this.totalExpenses -= amount;
        } else {
            this.totalIncome += amount;
        }
    }

    @Override
    public String toString() {
        return String.format("%nAccount Name: %s%nCurrent Balance: %.2f", this.name, this.balance);
    }
}
