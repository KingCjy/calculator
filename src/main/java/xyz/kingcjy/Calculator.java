package xyz.kingcjy;

import xyz.kingcjy.listener.CalculatorButtonListener;
import xyz.kingcjy.listener.CalculatorKeyListener;
import xyz.kingcjy.operator.Operator;
import xyz.kingcjy.operator.factory.OperatorFactory;
import xyz.kingcjy.view.CalculatorFrame;

public class Calculator {
    private int number = 0;
    private int number2 = 0;
    private Operator operator;

    private CalculatorFrame calculatorFrame;
    private OperatorFactory operatorFactory;

    public Calculator() {
        CalculatorKeyListener calculatorKeyListener = new CalculatorKeyListener(this);
        CalculatorButtonListener calculatorButtonListener = new CalculatorButtonListener(this);
        calculatorFrame = new CalculatorFrame(calculatorKeyListener, calculatorButtonListener);

        operatorFactory = new OperatorFactory();
    }

    public void onRequest(String value) {
        initializeNumber(value);
        addNumber(value);
        calculateResult(value);
        setOperatorByValue(value);

        calculatorFrame.updateLabelValue(number);
    }

    private void initializeNumber(String value) {
        if((isNumber(value) && number2 != 0 && operator == null) == false && "C".equals(value) == false) {
            return;
        }
        number2 = 0;
        number = 0;
    }

    private void addNumber(String value) {
        if(isNumber(value) == false || (new Long(number)*10) + Long.valueOf(value) > Integer.MAX_VALUE) {
            return;
        }

        int num = Integer.valueOf(value);

        if(isPositive(num)) {
            number = (number * 10) + num;
        } else {
            number = (number * 10) - num;
        }
    }

    private void setOperatorByValue(String value) {
        if(isOperator(value) == false) {
            return;
        }

        this.operator = operatorFactory.createOperator(value);
        number2 = number;
        number = 0;
    }

    private void calculateResult(String value) {
        if((isEquals(value) == false && isOperator(value) == false)  || operator == null) {
            return;
        }

        number = operator.process(number2, number);
        operator = null;
    }

    private boolean isOperator(String value) {
        return value.matches("[+|\\-|/|*|x]");
    }

    private boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean isPositive(int value) {
        return value >= 0;
    }

    private boolean isEquals(String value) {
        return "\n".equals(value) || "=".equals(value);
    }
}
