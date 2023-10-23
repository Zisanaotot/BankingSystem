package BudgetReport;
import java.util.ArrayList;
import java.util.Scanner;

public class BudgetReport {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Expected monthly income: ");
        double income = scanner.nextDouble();
        
        System.out.println("Number of unique expenses this month:");
        int numberOfExpenses = scanner.nextInt();
        
        ArrayList<Expense> expensesList = new ArrayList<>();
        
        for(int i=0; i<numberOfExpenses; i++){
            
            scanner.nextLine();
            
            System.out.println("Enter name of expense " + (i+1) + ": ");
            String expenseName = scanner.nextLine();
            
            System.out.println("Enter cost of a single " + "'" + expenseName + "'" + " payment: ");
            double expenseAmount = scanner.nextDouble();
            
            System.out.println("Enter number of " + "'" + expenseName + "'" + " payments: ");
            int expenseOccurence = scanner.nextInt();
            
            Expense expense = new Expense(expenseName, expenseAmount, expenseOccurence);
            expensesList.add(expense);
        }
        
        scanner.close();
        
        System.out.println("\t \t \t  Your monthly budget report:\n");
        System.out.println("Expense:\t    Single Cost:\t # of Occurences:\t Total Amount:");
        System.out.println("-------------------------------------------------------------------------------");
            
        double totalExpense=0;
           
        for (int j=0; j<numberOfExpenses; j++){
            Expense expense = expensesList.get(j);
            System.out.printf("%-22s $%-24.2f %-17d  $%.2f\n", expense.name, expense.amount, expense.occurence, expense.totalamount);
            totalExpense += expense.totalamount;
            }   
            
        double netAmount = income - totalExpense;
            
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("\t \t \t \t \t  Income: $%.2f        Total: $%.2f\n", income, totalExpense);
        System.out.println("\t \t \t \t \t --------------------------------------");
        System.out.printf("\t \t \t \t \t \t Net gain/loss: $%.2f\n", netAmount);
        }
    }