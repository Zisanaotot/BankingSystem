package BankingSystem;
import java.util.Scanner;
/**
 *
 * @author Ali Fares
 */
public class BankingSystem {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("How many banks are you managing:  ");
        int n = scanner.nextInt();
        
        for(int i=0; i<n; i++){
            Bank.addBank();
        }
        Bank.showMainMenu();
    }
}