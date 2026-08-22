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

        int opt = sc.nextInt();
        sc.nextLine();
        if (opt == 2) {
            createAccount();
        }
    }

    public void viewAccounts() {
        System.out.println("\n   Account Viewer   ");
        System.out.println("--------------------");
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
}
