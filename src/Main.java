public class Main {
   public static void main(String[] args) {
        Date date = new Date(05, 12, 2024);

        Transaction trans = new Transaction(111.207, date, "Food", "Taco Bell");
        //System.out.println(trans);

        Account acct = new Account("Checking");
        acct.addTransaction(trans);

        System.out.println(acct);
    }
}
