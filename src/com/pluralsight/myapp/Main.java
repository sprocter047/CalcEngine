package com.pluralsight.myapp;

import com.pluralsight.calcengine.*;

public class Main {

	public static void main(String[] args) {
		//useMathEquation();
		//useCalulatorBase();

		String[] statements = {
				"add 1.0",
				"add xx 25.0",
				"addX 0.0 0.0",
				"divide 100.0 50.0",
				"add 25.0 92.0",
				"substract 2225.0 17.0",
				"multiply 11.0 3.0"
		};
		CalculateHelper helper = new CalculateHelper();
		for(String statement:statements) {
			try {
				helper.process(statement);
				System.out.println("*********");
				System.out.println(helper);
				System.out.println("***********");

			} catch (InvalidStatementException e) {
				System.out.println(e.getMessage());
				if (e.getCause() != null)
					System.out.println("  Original exception: " + e.getCause().getMessage());
			}
		}


		MathEquation[] equations = new MathEquation[4];
		equations[0] = new MathEquation('d',100.0d, 50.0d );
		equations[1] = new MathEquation('a',25.0d, 92d);
		equations[2] = new MathEquation('s',225.0d, 17.0d);
		equations[3] = new MathEquation('m',11.0d, 3.0d);
		for (MathEquation equation : equations) {
			equation.execute();
			System.out.print("result = ");
			System.out.println(equation.getResult());
		}
		System.out.println();
		System.out.println("Using Overloads");
		System.out.println();

		double leftDouble = 9.0d;
		double rightDouble = 4.0d;

		int leftInt = 9;
		int rightInt = 4;

		MathEquation equationOverload = new MathEquation('d');

		equationOverload.execute(leftDouble, rightDouble);
		System.out.print("result=");
		System.out.println(equationOverload.getResult());


		equationOverload.execute(leftInt, rightInt);
		System.out.print("result=");
		System.out.println(equationOverload.getResult());

		equationOverload.execute((double)leftInt, rightInt);
		System.out.print("result=");
		System.out.println(equationOverload.getResult());

		System.out.println();
		System.out.println("Using Inheritance");
		System.out.println();

		CalculateBase[] calculators = {
				new Divider(100.0d, 50.0d),
				new Adder(25.0d, 92.0d),
				new Subtracter(225.0d, 17.0d),
				new Multiplier(11.0d, 3.0d)
		};
		for(CalculateBase calculator:calculators) {
			calculator.calculate();
			System.out.print("result=");
			System.out.println(calculator.getResult());
		}

	}

//	public static MathEquation create(double leftVal, double rightVal, char opCode) {
//		MathEquation equation = new MathEquation();
//		equation.setLeftVal(leftVal);
//		equation.setRightVal(rightVal);
//		equation.setOpCode(opCode);
//		return equation;
//	}
}

