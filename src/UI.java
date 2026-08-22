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
        System.out.println("4. Exit Program");

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
        int acct = sc.nextInt();
        sc.nextLine();

        System.out.println("\n\"" + accounts.get(acct - 1) + "\" Account deleted successfully!");
        accounts.remove(acct - 1);
        numAccounts--;
        System.out.println("1. Return to main menu");
        sc.nextLine();
        mainMenu();
    }
}
