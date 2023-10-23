package BankingSystem;

/**
 *
 * @author Ali Fares
 */
public class Account {
    
    private String accountName;  // Name of account
    private long accountNumber;  // Account number
    private double Balance;  // Balance of account
    private double previousTransaction;
    
        /**
     *
     * @param name
     * @param number
     * @param initialBalance
     */
    public Account(String name, Long number, double initialBalance) {
        this.accountName = name;
        this.accountNumber = number;
        this.Balance = initialBalance;  
    }
    
    void getPreviousTransaction(){
        if (previousTransaction > 0.00){
            System.out.println("Deposited: $" + getTransaction() + " into account number " + getNumber());
        }
        else if (previousTransaction < 0.00){
            System.out.println("Withdrawn: $" + Math.abs(getTransaction()) + " from account number " + getNumber());
        }
        else {
            System.out.println("No transaction occurred");
        }
    }

    /**
     *
     * @return previous transaction made
     */
    public double getTransaction(){
        return previousTransaction;
    }
    
    /**
     * Getter for account name
     * @return
     */
    public String getName(){
        return accountName;
    }

    /**
     * Getter for account number
     * @return
     */
    public long getNumber(){
        return this.accountNumber;
    }

    /**
     * Getter for account balance
     * @return
     */
    public double getBalance(){
        return this.Balance;
    }
    
/**
     * Withdraw method
     * does not allow to withdraw a zero or negative value,
     * as well as a value greater than balance of account
     * @param amount
     * @return true if successful
     */
    boolean withdraw(double amount){
        if (amount <= 0 || amount > Balance) {
            System.out.println("Error: Insufficient funds available.");
            return false;
        }
        else {
            Balance = Balance - amount;
            previousTransaction = -amount;
            return true;
        }
    }
    
    /**
     * Deposit method
     * does not allow to deposit a zero or negative value
     * @param amount
     * @return 
     */
    boolean deposit(double amount){
        if (amount <= 0){
            System.out.println("Error: please enter a valid number");
            return false;
        }
        else {
            this.Balance = Balance + amount;
            previousTransaction = amount;
            return true;
        }
    }
}
