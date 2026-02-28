package IntresertCalculator;

public class Intrestslababove1cr {
    int min;
    int max;
    double intrestrate;

    public Intrestslababove1cr(int max, int min, double intrestrate) {
        this.max = max;
        this.min = min;
        this.intrestrate = intrestrate;
    }
    public  boolean inRange(int value){
        return value>=min && value<=max;
    }
}
