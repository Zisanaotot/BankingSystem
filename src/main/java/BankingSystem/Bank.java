package BankingSystem;

/**
 * Bank class, Part of Banking System
 * contains methods for managing accounts
 * @author Ali Fares
 */
public class Bank {
    
    private String name; // name of bank
    private Account [] accounts; // An array of Accounts managed by this bank.
    private int numAccounts;    //number of active accounts

    /**
     *
     * @param name
     * @param maxNumberAccounts
     */
    public Bank(String name, int maxNumberAccounts) {
        this.name = name;
        accounts = new Account[maxNumberAccounts];
        numAccounts = 0; 
    }

    /**
     * @return name of bank
     */
    public String getName() {
        return name;  //Fix this
    }

    /**
     * @return the number of accounts in bank
     */
    public int getNumAccounts() {
        return numAccounts; 
    }

    /**
     * Getter for accounts of a bank
     * @return
     */
    public Account[] getAccounts() {
        return accounts; 
    }

    /**
     * Returns true if the Bank already has an account
     * with input number; otherwise false.
     * @param accountNumber
     * @return
     */
    public boolean hasAccountNumber(int accountNumber) {
        for (int i=0; i<accounts.length; i++){
            if (accounts[i] != null){
                if (accounts[i].getNumber() == accountNumber){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Adds the input account to the Bank if possible:
     * If the counter for current accounts does not exceed the max amount 
     * of accounts initialized to the bank, and the input account number 
     * does not exist for any other account in the bank,
     * then the account is added to the bank.
     * Otherwise, the account is not added, and returns false.
     * @param account
     * @return true if successful
     */
    public boolean add(Account account) {
        if (numAccounts<accounts.length && !hasAccountNumber(account.getNumber())){
            for (int i=0; i<accounts.length; i++){
                if (accounts[i] == null){
                    accounts[i] = account;
                    numAccounts++;
                    return true;
                }
            }
        }
        return false;
    }
}