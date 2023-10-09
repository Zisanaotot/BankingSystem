package BankingSystem;

/**
 *
 * @author Ali Fares
 */
public class Account {
    
    private String accountName;  // Name of account
    private int accountNumber;  // Account number
    private double Balance;  // Balance of account
    
    /**
     *
     * @param name
     * @param number
     * @param initialBalance
     */
    public Account(String name, int number, double initialBalance) {
        this.accountName = name;
        this.accountNumber = number;
        this.Balance = initialBalance;  
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
    public int getNumber(){
        return accountNumber;
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
            System.out.println("Error: please enter a valid number");
            return false;
        }
        else {
            Balance = Balance - amount;
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
            return true;
        }
    }
}
