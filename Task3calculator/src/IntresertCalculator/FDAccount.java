package IntresertCalculator;
import java.util.*;

public class FDAccount extends Account{
    int noofdays;
    int ageofAcholder;

    static List<Intresertslabbelow1cr> isbl1cr=new ArrayList<>();
    static{
        isbl1cr.add(new Intresertslabbelow1cr(7,14,4.5,5.0));
        isbl1cr.add(new Intresertslabbelow1cr(15,29,4.75,5.25));
        isbl1cr.add(new Intresertslabbelow1cr(30,45,5.5,6.0));
        isbl1cr.add(new Intresertslabbelow1cr(45,60,7,7.5));
        isbl1cr.add(new Intresertslabbelow1cr(61,184,7.5,8.0));
        isbl1cr.add(new Intresertslabbelow1cr(185,365,8.0,8.5));
    }
    static List<Intrestslababove1cr>isab1cr=new ArrayList<>();
    static{
        isab1cr.add(new Intrestslababove1cr(14,7,6.5));
        isab1cr.add(new Intrestslababove1cr(29,15,6.75));
        isab1cr.add(new Intrestslababove1cr(45,30,6.75));
        isab1cr.add(new Intrestslababove1cr(60,45,8));
        isab1cr.add(new Intrestslababove1cr(184,61,8.5));
        isab1cr.add(new Intrestslababove1cr(365,180,10.0));

    }

    public FDAccount(double amount,int noofdays, int ageofAcholder) {
        this.amount=amount;
        this.noofdays = noofdays;
        this.ageofAcholder = ageofAcholder;
    }
    public double calculateInterest() {
        intrestRate = 0;
        if (amount <= 10000000) {
            for (Intresertslabbelow1cr i : isbl1cr) {
                if (i.inRange(noofdays)) {
                    if (ageofAcholder < 60) {
                        intrestRate = i.generalRate;
                        break;

                    } else {
                        intrestRate = i.seniorRate;
                        break;
                    }
                }
            }
            System.out.println("Amount = " + amount);


            return amount * intrestRate * noofdays /(365*100);

        }

        else {
            for (Intrestslababove1cr i : isab1cr) {
                if (i.inRange(noofdays)) {
                    intrestRate=i.intrestrate;
                    break;
                }


            }


            return amount * intrestRate * noofdays/(365*100);


        }

    }
}