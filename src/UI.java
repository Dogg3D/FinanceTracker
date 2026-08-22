import java.util.Scanner;
import java.util.ArrayList;

public class UI {
    private final Scanner sc = new Scanner(System.in);
    private int numAccounts = 0;
    private ArrayList<Account> accounts = new ArrayList<>();

    public void mainMenu () {
        System.out.println("\nDON Finance Manager");
        System.out.println("-------------------");
        System.out.println(" Select an option: \n");
        System.out.println("1. View Accounts (" + numAccounts + ")");
        System.out.println("2. Create Account");
        System.out.println("3. Delete Account");
        System.out.println("4. Add Transaction");
        System.out.println("5. Exit Program");

        int opt = sc.nextInt();
        sc.nextLine();
        switch (opt) {
            case 1:
                viewAccounts();
                break;
            case 2:
                createAccount();
                break;
            case 3:
                deleteAccount();
                break;
            case 4:
                makeTransaction();
                break;
            case 5:
                System.out.println("Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid input, please enter a number shown!");
                mainMenu();
        }
    }

    public void listAccounts() {
        for (int i = 1; i <= accounts.size(); i++) {
            System.out.printf("%n%d. %s", i, accounts.get(i - 1));
        }
        System.out.printf("%n%d. Return to main menu%n", accounts.size() + 1);
    }

    public void viewAccounts() {
        System.out.println("\n   Account Viewer   ");
        System.out.println("--------------------");
        if (numAccounts == 0) {
            System.out.println("No accounts found! Please create an account.");
            System.out.println("1. Return to main menu");
            sc.nextLine();
            mainMenu();
        } else {
            System.out.println(" Select an account:");
            listAccounts();
        }
        int opt = sc.nextInt();
        sc.nextLine();
        if (opt == accounts.size() + 1) {
            mainMenu();
        } else {
            accountDetails(accounts.get(opt - 1));
        }
    }

    public void accountDetails(Account account) {
        System.out.printf("%n%s Account Details%n", account);
        System.out.println("------------------------");
        account.getBalance();

        System.out.println("\nSelect an option;");
        System.out.println("1. View transaction history");
        System.out.println("2. See total income");
        System.out.println("3. See total expenses");
        System.out.println("4. Return to account viewer");
        System.out.println("5. Return to main menu");

        int opt = sc.nextInt();
        sc.nextLine();
        switch (opt) {
            case 1:
                account.getTransactionHistory();
                System.out.println("1. Back");
                sc.nextLine();
                accountDetails(account);
                break;
            case 2:
                account.getIncome();
                System.out.println("1. Back");
                sc.nextLine();
                accountDetails(account);
                break;
            case 3:
                account.getExpenses();
                System.out.println("1. Back");
                sc.nextLine();
                accountDetails(account);
                break;
            case 4:
                viewAccounts();
                break;
            case 5:
                mainMenu();
                break;
            default:
                System.out.println("Please enter a valid input!");
                accountDetails(account);
        }
    }

    public void createAccount() {
        System.out.println("\n  Account Manager  ");
        System.out.println("-------------------");
        System.out.println("Name your new account:");
        String name = sc.nextLine();

        Account acct = new Account(name);
        accounts.add(acct);
        numAccounts++;

        System.out.println("Account \"" + name + "\" created successfully!");
        System.out.println("1. Return to main menu");
        sc.nextLine();

        System.out.println("Returning to main menu...");
        mainMenu();
    }

    public void deleteAccount() {
        System.out.println("Account Deletion");
        System.out.println("----------------");
        System.out.println("Choose an account to delete:");

        listAccounts();
        int opt = sc.nextInt();
        if (opt == accounts.size() + 1) {
            sc.nextLine();
            mainMenu();
        }
        sc.nextLine();


        System.out.println("\n\"" + accounts.get(opt - 1) + "\" Account deleted successfully!");
        accounts.remove(opt - 1);
        numAccounts--;
        System.out.println("1. Return to main menu");
        sc.nextLine();
        mainMenu();
    }

    public void makeTransaction() {
        System.out.println("Create Transaction");
        System.out.println("------------------");
        System.out.println("Select an account:");
        listAccounts();
        int opt = sc.nextInt();
        sc.nextLine();

        if (opt == accounts.size() + 1) {
            mainMenu();
        } else if (opt > accounts.size() + 1) {
            System.out.println("Please enter a valid option!");
            makeTransaction();
        } else {
            System.out.println("\nFirst, please enter a date (mm/dd/yyyy): ");
            System.out.print("Enter month (mm): ");
            int month = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter day (dd): ");
            int day = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter year (yyyy): ");
            int year = sc.nextInt();
            sc.nextLine();
            Date date = new Date(month, day, year);
            System.out.println("Entered date: " + date);

            double amount;
            System.out.println("Next, is this transaction income or an expense?");
            System.out.println("1. Income");
            System.out.println("2. Expense");
            boolean isIncome = false;
            if (sc.nextInt() == 1) {
                isIncome = true;
            }
            sc.nextLine();
            System.out.println("Enter an amount for this transaction: ");
            amount = sc.nextDouble();
            sc.nextLine();
            if (!isIncome) {
                amount *= -1;
            }

            System.out.println("\nGive a short description of this transaction (EX: Business, Website, etc.): ");
            String desc = sc.nextLine();
            System.out.println("\nFinally, enter a category (EX: Groceries, Gas, Fun, etc.: ");
            String cat = sc.nextLine();

            Transaction trans = new Transaction(amount, date, cat, desc);
            accounts.get(opt - 1).addTransaction(trans);

            System.out.println("\nTransaction added successfully!");
            System.out.println("1. Add another transaction");
            System.out.println("2. Return to main menu");
            if (sc.nextInt() == 1) {
                sc.nextLine();
                makeTransaction();
            } else {
                sc.nextLine();
                mainMenu();
            }
        }
    }
}
