package Calculator.Operations;

import Calculator.Operations.BaseCalculator;

/**
 * Created by rliu on 4/17/17.
 */
public class Add extends BaseCalculator {

    public void add(double a, double b) {
        res=a+b;
    }

    public String getResultString(){
        return Double.toString(res);
    }
}
