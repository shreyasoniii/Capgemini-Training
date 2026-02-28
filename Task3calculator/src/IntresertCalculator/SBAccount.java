package IntresertCalculator;

public class SBAccount extends Account {

    double interestRate;
    double amount;
    String accountType;



    public SBAccount(double amount,String accountType) {


        this.amount = amount;
        this.accountType=accountType;
    }



    public double calculateInterest() {

        if(this.accountType.equalsIgnoreCase("Normal")){
            interestRate=4;
        }
        else if(this.accountType.equalsIgnoreCase("NRI")) {
            interestRate=6;
        }
        else {
            System.out.print("Enter valid Account type.");
        }
        return (amount*interestRate)/100;
    }

}