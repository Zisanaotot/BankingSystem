package BudgetReport;
public class Expense {

String name;
double amount;
int occurence;
double totalamount;

    Expense(String name, double amount, int occurence){
        this.name = name;
        this.amount = amount;
        this.occurence = occurence;
        this.totalamount = (this.amount * this.occurence);
        
    }
    
}
