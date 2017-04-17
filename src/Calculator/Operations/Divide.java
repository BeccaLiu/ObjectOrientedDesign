package Calculator.Operations;

/**
 * Created by rliu on 4/17/17.
 */
public class Divide extends BaseCalculator {
    public void divide(double a, double b) {
        if(b==0)
            throw new IllegalArgumentException("Divisor is 0");
        res=a/b;
    }

    public String getResultString(){
        return String.format(Double.toString(res));
    }
}
