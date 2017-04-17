package Calculator.Operations;

/**
 * Created by rliu on 4/17/17.
 */
public class Multiply extends BaseCalculator {
    public void multiply(double a, double b) {
        res=a*b;
    }

    public String getResultString(){
        return String.format(Double.toString(res));
    }
}
