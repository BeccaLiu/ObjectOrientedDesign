package Calculator.Operations;

/**
 * Created by rliu on 4/17/17.
 */
public class OneDivideBy extends BaseCalculator {
    public void oneDivideBy(double b) {
        if(b==0)
            throw new IllegalArgumentException("Divisor is 0");
        res=1/b;
    }

    public String getResultString(){
        return String.format(Double.toString(res));
    }
}
