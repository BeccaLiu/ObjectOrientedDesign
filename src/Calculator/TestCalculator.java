package Calculator;

import Calculator.Operations.*;

import java.util.ArrayList;

/**
 * Created by rliu on 4/17/17.
 * Write a program that can perform the following operations.  Build the program in the order specified.
 * 1. Create an interface with a method that can add two numbers
 * 2. Implement a class that adds two numbers
 * 3. Calculator.Operations.Add a feature that returns the mathematical result as a string
 * 4. Implement classes that subtract and multiply two numbers
 * 5. Calculator.Operations.Add a feature to output the calculation to the command line
 * Hint: consider implementing a base class
 * 6. Create a list containing at least one of each of these three classes
 * 7. Iterate and output the results to standard out
 * 8. Write a method to read values from an array of strings in a specific format and do the specified calculation. Use the follow values in your array:
 * +;1;2
 * -;3;4
 * ;5;-6
 * 9.Output the results to  standard out
 * 10. Calculator.Operations.Add the following string to the array in step 9 and implement a class that can do the calculation:
 * /;8;2
 * 11. Calculator.Operations.Add any additional values for testing purposes
 * 12. Implement a class that performs the 1/x calculator operation
 * 13. Calculator.Operations.Add the new operation to the list in step 7 and output the operation results to standard out.
 */
public class TestCalculator {
    //@Test
    public static void main(String[] args) {
        testOperation();
        testDoCalculation();
    }

    public static void testOperation() {
        //test addList
        ArrayList<BaseCalculator> operationList = new ArrayList<>();
        operationList.add(new Add());
        operationList.add(new Subtract());
        operationList.add(new Multiply());
        operationList.add(new Divide());
        operationList.add(new OneDivideBy());

        int a=5;int b=2;
        for (BaseCalculator process : operationList) {
            if (process.getClass().getName().equals("Calculator.Operations.Add")) {
                Add curr = (Add) process;
                curr.add(a, b);
            }
            if (process.getClass().getName().equals("Calculator.Operations.Subtract")) {
                Subtract curr = (Subtract) process;
                curr.subtract(a, b);
            }
            if (process.getClass().getName().equals("Calculator.Operations.Multiply")) {
                Multiply curr = (Multiply) process;
                curr.multiply(a, b);
            }
            if (process.getClass().getName().equals("Calculator.Operations.Divide")) {
                Divide curr = (Divide) process;
                curr.divide(a, b);
            }
            if (process.getClass().getName().equals("Calculator.Operations.OneDivideBy")) {
                OneDivideBy curr = (OneDivideBy) process;
                curr.oneDivideBy(b);
            }
            process.stdOut();
        }
    }

    //@Test
    public static void testDoCalculation() {
        //test do Calculation
        String[] arr = new String[]{"+;1;2", "-;3;4", "*;5;-6","/;16;-4"};
        doCalculation(arr);
    }

    public static void doCalculation(String[] arr) {
        for (String s : arr) {
            String[] contents = s.split(";");
            if (contents[0].equals("+")) {
                Add addNow = new Add();
                addNow.add(Integer.parseInt(contents[1]), Integer.parseInt(contents[2]));
                System.out.println(contents[1] + contents[0] + contents[2] + "=" + addNow.getResultString());
            } else if (contents[0].equals("-")) {
                Subtract sub = new Subtract();
                sub.subtract(Integer.parseInt(contents[1]), Integer.parseInt(contents[2]));
                System.out.println(contents[1] + contents[0] + contents[2] + "=" + sub.getResultString());
            } else if (contents[0].equals("*")) {
                Multiply multi = new Multiply();
                multi.multiply(Integer.parseInt(contents[1]), Integer.parseInt(contents[2]));
                System.out.println(contents[1] + contents[0] + contents[2] + "=" + multi.getResultString());
            } else if (contents[0].equals("/")) {
                Divide div = new Divide();
                div.divide(Integer.parseInt(contents[1]), Integer.parseInt(contents[2]));
                System.out.println(contents[1] + contents[0] + contents[2] + "=" + div.getResultString());
            }
        }
    }
}
