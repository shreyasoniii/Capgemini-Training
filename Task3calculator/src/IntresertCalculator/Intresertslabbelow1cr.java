package IntresertCalculator;

public class Intresertslabbelow1cr {
    int min;
    double max;
   double generalRate;
   double seniorRate;

    public Intresertslabbelow1cr(int min,  double max,double generalRate, double seniorRate) {
        this.min = min;
        this.generalRate = generalRate;
        this.max = max;
        this.seniorRate = seniorRate;
    }

    public  boolean inRange(int value){
        return value>=min && value<=max;
    }
}
