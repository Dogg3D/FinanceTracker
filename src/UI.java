import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class UI {
    private final Scanner sc = new Scanner(System.in);
    private int numAccounts = 0;
    private ArrayList<Account> accounts = new ArrayList<>();

    public void mainMenu () {
        while (true) {
            System.out.println("\nDON Finance Manager");
            System.out.println("-------------------");
            System.out.println(" Select an option: \n");
            System.out.println("1. View Accounts (" + numAccounts + ")");
            System.out.println("2. Create Account");
            System.out.println("3. Delete Account");
            System.out.println("4. Add Transaction");
            System.out.println("5. Exit Program");

            int opt = 0;
            try {
                opt = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Please enter a valid number!");
                continue;
            }
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
                    return;
                default:
                    System.out.println("Please enter a valid number!");
            }
        }
    }

    private void hasAccounts() {
        if (numAccounts == 0) {
            System.out.println("No accounts found! Please create an account.");
            System.out.println("1. Return to main menu");
            sc.nextLine();
            mainMenu();
        }
    }

    private void listAccounts() {
        for (int i = 1; i <= accounts.size(); i++) {
            System.out.printf("%n%d. %s", i, accounts.get(i - 1));
        }
        System.out.printf("%n%d. Return to main menu%n", accounts.size() + 1);
    }

    private void viewAccounts() {
        while (true) {
            System.out.println("\n   Account Viewer   ");
            System.out.println("--------------------");
            hasAccounts();

            System.out.println(" Select an account:");
            listAccounts();
            int opt = 0;
            try {
                opt = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();
            if (opt == accounts.size() + 1) {
                return;
            } else if (opt < 0 || opt > accounts.size() + 1) {
                System.out.println("Invalid input! Please try again.");
            } else {
                accountDetails(accounts.get(opt - 1));
            }
        }
    }

    private void accountDetails(Account account) {
        while (true) {
            System.out.printf("%n\"%s\" Account Details%n", account);
            System.out.println("------------------------");
            account.getBalance();

            System.out.println("\nSelect an option;");
            System.out.println("1. View transaction history");
            System.out.println("2. See total income");
            System.out.println("3. See total expenses");
            System.out.println("4. Back");

            int opt;
            try {
                opt = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();
            switch (opt) {
                case 1:
                    account.getTransactionHistory();
                    System.out.println("\n1. Back");
                    sc.nextLine();
                    continue;
                case 2:
                    account.getIncome();
                    System.out.println("\n1. Back");
                    sc.nextLine();
                    continue;
                case 3:
                    account.getExpenses();
                    System.out.println("\n1. Back");
                    sc.nextLine();
                    continue;
                case 4:
                    return;
                default:
                    System.out.println("Invalid input! Please try again.");
                    sc.nextLine();
            }
        }
    }

    private void createAccount() {
        while (true) {
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
            return;
        }
    }

    private void deleteAccount() {
        while (true) {
            System.out.println("Account Manager");
            System.out.println("---------------");

            hasAccounts();

            System.out.println("Choose an account to delete:");

            listAccounts();
            int opt;
            try {
                opt = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again.");
                sc.nextLine();
                continue;
            }
            if (opt == accounts.size() + 1) {
                sc.nextLine();
                return;
            } else if (opt < 1 || opt > accounts.size() + 1) {
                System.out.println("Invalid input! Please try again!");
                continue;
            }
            sc.nextLine();


            System.out.println("\n\"" + accounts.get(opt - 1) + "\" Account deleted successfully!");
            accounts.remove(opt - 1);
            numAccounts--;
            System.out.println("1. Return to main menu");
            sc.nextLine();
            return;
        }
    }

    private void makeTransaction() {
        while (true) {
            System.out.println("Create Transaction");
            System.out.println("------------------");

            hasAccounts();

            System.out.println("Select an account:");
            listAccounts();
            int opt;
            try {
                opt = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please try again.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();

            if (opt == accounts.size() + 1) {
                return;
            } else if (opt > accounts.size() + 1 || opt < 1) {
                System.out.println("Invalid input! Please try again.");
                sc.nextLine();
            } else {
                System.out.println("\nFirst, please enter a date (mm/dd/yyyy): ");
                int month;
                int day;
                int year;
                Date date;
                while (true) {
                    System.out.print("Enter month (mm): ");
                    try {
                        month = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please try again.");
                        sc.nextLine();
                        continue;
                    }
                    if (month < 1 || month > 12) {
                        System.out.println("Please enter a valid month! (01-12)");
                        sc.nextLine();
                        continue;
                    }
                    sc.nextLine();
                    break;
                }
                while (true) {
                    System.out.println("Enter day (dd): ");
                    try {
                        day = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please try again.");
                        sc.nextLine();
                        continue;
                    }
                    if (day < 1 || day > 31) {
                        System.out.println("Please enter a valid day! (1-31)");
                        sc.nextLine();
                        continue;
                    }
                    sc.nextLine();
                    break;
                }
                while (true) {
                    System.out.println("Enter year (yyyy): ");
                    try {
                        year = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please try again.");
                        sc.nextLine();
                        continue;
                    }
                    if (year < 1900 || year > 2026) {
                        System.out.println("Please enter a valid year! (1900-2026)");
                        sc.nextLine();
                        continue;
                    }
                    sc.nextLine();
                    date = new Date(month, day, year);
                    System.out.println("\nEntered date: " + date);
                    break;
                }

                boolean isIncome;
                System.out.println("Next, is this transaction income or an expense?");
                while (true) {
                    System.out.println("1. Income");
                    System.out.println("2. Expense");
                    isIncome = false;
                    int incOpt;
                    try {
                        incOpt = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please try again.");
                        sc.nextLine();
                        continue;
                    }

                    if (incOpt == 1) {
                        isIncome = true;
                        break;
                    } else if (incOpt < 1 || incOpt > 2) {
                        System.out.println("Invalid input! Please try again.");
                        sc.nextLine();
                        continue;
                    }
                    sc.nextLine();
                    break;
                }

                double amount;
                while (true) {
                    System.out.println("Enter an amount for this transaction: ");
                    try {
                        amount = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please try again.");
                        sc.nextLine();
                        continue;
                    }
                    sc.nextLine();
                    if (amount < 0 && isIncome) {
                        System.out.println("Please enter a positive number!");
                    } else if (amount < 0 && !isIncome) {
                        break;
                    } else if (amount > 0 && isIncome) {
                        break;
                    } else {
                        amount *= -1;
                        break;
                    }
                }

                System.out.println("\nGive a short description of this transaction (EX: Business, Website, etc.): ");
                String desc = sc.nextLine();

                String cat;
                while (true) {
                    System.out.println("\nFinally, select a category: ");
                    System.out.println("1. Groceries");
                    System.out.println("2. Food & Dining");
                    System.out.println("3. Transportation");
                    System.out.println("4. Shopping");
                    System.out.println("5. Entertainment");
                    System.out.println("6. Salary & Wages");
                    System.out.println("7. Bills & Rent");
                    System.out.println("8. Misc Income");
                    System.out.println("9. Misc Expense");

                    int choice;
                    try {
                        choice = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please try again.");
                        sc.nextLine();
                        continue;
                    }

                    switch (choice) {
                        case 1:
                            cat = "Groceries";
                            sc.nextLine();
                            break;
                        case 2:
                            cat = "Food & Dining";
                            sc.nextLine();
                            break;
                        case 3:
                            cat = "Transportation";
                            sc.nextLine();
                            break;
                        case 4:
                            cat = "Shopping";
                            sc.nextLine();
                            break;
                        case 5:
                            cat = "Entertainment";
                            sc.nextLine();
                            break;
                        case 6:
                            cat = "Salary & Wages";
                            sc.nextLine();
                            break;
                        case 7:
                            cat = "Bills & Rent";
                            sc.nextLine();
                            break;
                        case 8:
                            cat = "Misc Income";
                            sc.nextLine();
                            break;
                        case 9:
                            cat = "Misc Expense";
                            sc.nextLine();
                            break;
                        default:
                            System.out.println("Please select one of the options!");
                            sc.nextLine();
                            continue;
                    }
                    break;
                }

                Transaction trans = new Transaction(amount, date, cat, desc);
                accounts.get(opt - 1).addTransaction(trans);

                System.out.println("\nTransaction added successfully!");
                while (true) {
                    System.out.println("1. Add another transaction");
                    System.out.println("2. Return to main menu");

                    int backOpt;
                    try {
                        backOpt = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please try again.");
                        sc.nextLine();
                        continue;
                    }
                    if (backOpt == 1) {
                        sc.nextLine();
                        break;
                    } else if (backOpt < 0 || backOpt > 2) {
                        sc.nextLine();
                        System.out.println("Please enter one of the options!");
                    } else {
                        sc.nextLine();
                        return;
                    }
                }
            }
        }
    }
}
