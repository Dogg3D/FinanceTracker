public class Transaction {
    private double amount;
    private Date date;
    private String category;
    private String description;

    public Transaction(double amount, Date date, String cat, String desc) {
        this.amount = amount;
        this.date = date;
        this.category = cat;
        this.description = desc;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return String.format("Date: %s%nAmount: %.2f%nCategory: %s%nDescription: %s%n", this.date, this.amount, this.category, this.description);
    }
}

