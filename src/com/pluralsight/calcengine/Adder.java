package com.pluralsight.calcengine;

public class Adder extends CalculateBase {
    public Adder(){}
    public Adder(double leftVal, double rightVal) {

    }

    @Override
    public void calculate() {
        double value = getLeftVal() + getRightVal();
        setResult(value);
    }
}
