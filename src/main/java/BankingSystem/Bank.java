package BankingSystem;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Bank class, crucial part of Banking System contains methods for managing banks and accounts
 *
 * @author Ali Fares
 */
public class Bank {

    private String name; // name of bank
    private int numAccounts;    //number of active accounts
    private static final ArrayList<Bank> banks = new ArrayList<>(); //arraylist containing all banks created
    private ArrayList<Account> accounts = new ArrayList<>(); //arraylist of accounts for each individual bank

    /**
     *
     * @param name
     * @param numberAccounts
     */
    public Bank(String name, int numberAccounts) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public boolean addAccount(Account account) {
        if (!hasAccountNumber(account.getNumber())) {
            accounts.add(account);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @return name of bank
     */
    public String getName() {
        return name;  //Fix this
    }

    /**
     *
     * @param name
     * @method for changing name of a bank
     */
    public void changeName(String name) {
        this.name = name;
    }

    /**
     * Getter for account of a bank at certain index
     *
     * @param index
     * @return account variables
     */
    public String getAccounts(int index) {
        return "[" + accounts.get(index).getName() + ", " + accounts.get(index).getNumber() + ", $" + accounts.get(index).getBalance() + "]";
    }
    

    /**
     * Returns true if the Bank already has an account with input number
     * checks if index is null first in order to avoid comparison between null and real number
     * otherwise false.
     *
     * @param accountNumber
     * @return 
     */
    public boolean hasAccountNumber(long accountNumber) {
        for (Account account : accounts) {
            if (account != null && account.getNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds the input account to the Bank if possible: If the counter for
     * current accounts does not exceed the max amount of accounts initialized
     * to the bank, and the input account number does not exist for any other
     * account in the bank, then the account is added to the bank. Otherwise,
     * the account is not added, and returns false.
     *
     * @param account
     * @return true if successful
     */
    public boolean add(Account account) {
        if (!hasAccountNumber(account.getNumber())) {
            accounts.add(account);
            numAccounts++;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @method Edit bank name method
     */
    public void editBankName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new name: ");
        changeName(scanner.nextLine());
    }

    /**
     * @method Main Menu display
     */
    public static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMain Menu: Which bank would you like to edit: \n");
            for (int j = 1; j <= banks.size(); j++) {
                System.out.println(j + ". " + banks.get(j - 1).getName());
            }
            System.out.println("");
            System.out.println("A. Add new bank");
            System.out.println("B. Exit program");

            System.out.println("\nEnter bank number to edit (1 - " + (banks.size()) + "), or 'A' to add a new bank, and 'B' to exit the program: \t");
            String option = scanner.next();

            if (option.equalsIgnoreCase("B")) {
                exit = true;
            } else if (option.equalsIgnoreCase("A")) {
                addBank();
            } else {
                int choice = Integer.parseInt(option);
                if (choice > 0 && choice <= banks.size()) {
                    banks.get(choice - 1).showBankMenu();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

     /**
     * @method Bank Menu display
     */
    void showBankMenu() {
        char optionBankMenu = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBank Menu: ");
        System.out.println("");

        do {
            boolean exit = false;
            System.out.println("A. Edit bank name");
            System.out.println("B. Remove bank");
            System.out.println("C. Add account");
            System.out.println("D. Manage accounts");
            System.out.println("E. Return to main menu");
            System.out.println("\nEnter an option: ");
            optionBankMenu = Character.toUpperCase(scanner.next().charAt(0));
            System.out.println("");

            switch (optionBankMenu) {

                case 'A':
                    scanner.nextLine();
                    System.out.println("Enter new bank name: ");
                    String newName = (scanner.nextLine());
                    changeName(newName);
                    optionBankMenu = 'M';
                    break;

                case 'B':
                    boolean removed = banks.remove(this);
                    if (removed) {
                        System.out.println("Bank successfully removed.\n");
                    }
                    optionBankMenu = 'M';
                    break;

                case 'C':
                    scanner.nextLine();
                    accountsToAdd = 1;
                    addAccountTo(this);
                    accountsToAdd = 0;
                    optionBankMenu = 'M';
                    break;

                case 'D':
                    System.out.println("Account Menu:");
                    for (int j = 1; j <= this.accounts.size(); j++) {
                        System.out.println(j + "." + getAccounts(j-1));   // testing -- works
                    }
                    System.out.println("");
                    System.out.println("\nEnter account number to edit (1 - " + (accounts.size()) + "), or 'A' to return to main menu: \t");
                    System.out.println("A. Return to main menu");

                    String option = scanner.next();

                    if (option.equalsIgnoreCase("A")) {
                        exit = true;
                    } else {
                        int choice = Integer.parseInt(option);
                        if (choice > 0 && choice <= accounts.size()) {
                            showAccountMenu(accounts.get(choice - 1));
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
                    }

                case 'E':
                    optionBankMenu = 'M';
                    break;
            }
        } while (optionBankMenu != 'M');
    }
    
    /**
     *
     * @param account
     * @method Account Menu display
     */
    public void showAccountMenu(Account account){
        char optionAccountMenu = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAccount Menu: ");
        System.out.println("");

        do {
            System.out.println("A. Withdraw");
            System.out.println("B. Deposit");
            System.out.println("C. Previous transaction");
            System.out.println("D. Remove account");
            System.out.println("E. Return to main menu");
            System.out.println("\nEnter an option: ");
            optionAccountMenu = Character.toUpperCase(scanner.next().charAt(0));
            System.out.println("");

            switch (optionAccountMenu) {
                case 'A': 
                    System.out.println("Enter amount to withdraw:\t");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                    optionAccountMenu = 'M';
                    break;
                    
                case 'B':
                    System.out.println("Enter amount to deposit:\t");
                    double amount1 = scanner.nextDouble();
                    account.deposit(amount1);
                    optionAccountMenu = 'M';
                    break;
                    
                case 'C':
                    account.getPreviousTransaction();
                    optionAccountMenu = 'M';
                    break;
                    
                case 'D':
                    accounts.remove(account);
                    optionAccountMenu = 'M';
                    break;
                    
                case 'E':
                    optionAccountMenu = 'M';
                    break;
            }
                
        } while (optionAccountMenu != 'M');
    }

    static int bankCounter = 0;
    static int accountsToAdd = 0;

    /**
     * @method to add a bank
     */
    public static void addBank() {
        bankCounter++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter name of bank " + bankCounter + ":\t\t");
        String bankName = scanner.nextLine();

        System.out.println("\nHow many accounts would you currently like to add to '" + bankName + "':\t");
        accountsToAdd = scanner.nextInt();
        
        System.out.println("");

        Bank bank = new Bank(bankName, accountsToAdd);
        banks.add(bank);
        
        addAccountTo(bank);           // working now
        accountsToAdd = 0;
    }

    /**
     *
     * @param bank
     * @method Add account to bank
     */
    public static void addAccountTo(Bank bank) {
        Scanner scanner = new Scanner(System.in);
        
        for (int j = 0; j < accountsToAdd; j++) {

            System.out.println("Enter name of account " + (j+1) + ":\t\t");
            String accountName = scanner.nextLine();

            System.out.println("\nEnter account number:\t\t");
            long accountNumber = scanner.nextLong();

            System.out.println("\nEnter account balance:\t\t");
            double accountBalance = scanner.nextDouble();
            scanner.nextLine();

            Account account = new Account(accountName, accountNumber, accountBalance);

            boolean added = bank.addAccount(account);

            if (added) {
            System.out.println("");
            System.out.println("Account successfully added!");
            } else {
            System.out.println("");
            System.out.println("Unable to add account: check if account number already exists.");
            }
        }
    }
}
