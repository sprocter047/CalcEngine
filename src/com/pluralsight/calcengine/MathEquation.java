package com.pluralsight.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode = 'a';
    private double result;

    public double getLeftVal() {return leftVal;}; //accessor
    public void setLeftVal(double leftVal) {this.leftVal = leftVal;} //mutator
    public double getRightVal() {return rightVal;};
    public void  setRightVal(double rightVal) {this.rightVal = rightVal;}
    public char getOpCode() {return opCode;};
    public void setOpCode(char opCode) {this.opCode = opCode;}

    public double getResult() { return result;}

    public MathEquation() {}

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }
    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    public void execute()  {

            switch (opCode) {
                case 'a':
                    result = leftVal + rightVal;
                    break;
                case 's':
                    result = rightVal - leftVal;
                    break;
                case 'd':
                    result = leftVal != 0.0d ? rightVal / leftVal : 0.0d;
                    break;
                case 'm':
                    result = rightVal * leftVal;
                    break;
                default:
                    System.out.println("Error Invalid opCode");
                    result = 0.0d;
                    break;
            }
    }

}
