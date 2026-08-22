public class Main {
   public static void main(String[] args) {
        Date date1 = new Date(05, 12, 2024);
        Date date2 = new Date(02, 17, 2025);

        Transaction trans1 = new Transaction(111.207, date1, "Food", "Taco Bell");
        Transaction trans2 = new Transaction(30.44, date2, "Gas", "Kwik Trip");

        Account acct = new Account("Checking");
        acct.addTransaction(trans1);
        acct.checkBalance();

        acct.addTransaction(trans2);
        acct.checkBalance();
        acct.getTransactionHistory();

    }
}
