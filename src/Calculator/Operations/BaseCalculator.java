package Calculator.Operations;

/**
 * Created by rliu on 4/17/17.
 */
public abstract class BaseCalculator {
    double res;
    public void stdOut(){
        System.out.println(res);
    }

    abstract String getResultString();
}
