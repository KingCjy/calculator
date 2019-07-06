package xyz.kingcjy.operator.factory;

import xyz.kingcjy.operator.*;

public class OperatorFactory {
    public Operator createOperator(String value) {
        if("+".equals(value)) {
            return new PlusOperator();
        }

        if("-".equals(value)) {
            return new SubstractOperator();
        }

        if("*".equals(value) || "x".equals(value)) {
            return new MultiplyOperator();
        }

        if("/".equals(value)) {
            return new DivisionOperator();
        }

        return null;
    }
}
