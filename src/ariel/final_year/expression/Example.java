// Put the expression evaluator through its paces.

// Sample usage:

// $ java expr.Example '3.14159 * x^2' 0 4 1
// 0
// 3.14159
// 12.5664
// 28.2743
// 50.2654
//
// $ java expr.Example 'sin (pi/4 * x)' 0 4 1
// 0
// 0.707107
// 1
// 0.707107
// 1.22461e-16
//
// $ java expr.Example 'sin (pi/4 x)' 0 4 1
// I don't understand your formula "sin (pi/4 x)".
// 
// I got as far as "sin (pi/4" and then saw "x".
// I expected ")" at that point, instead.
// An example of a formula I can parse is "sin (pi/4 + x)".

package ariel.final_year.expression;

/**
 * A simple example of parsing and evaluating an expression.
 */
public class Example {
	public static void main(String[] args) {

		Expr expr;
		try {
			//expr = Parser.parse("(x^2 + 9/4*y^2 + z^2 - 1)^3 - x^2*z^3 - 9/80*y^2*z^3");
			expr = Parser.parse("x^2 + y^2 + z^2 - 1"); 
		} catch (SyntaxException e) {
			System.err.println(e.explain());
			return;
		}

		double low  = Double.valueOf(-1).doubleValue();
		double high = Double.valueOf(1).doubleValue();
		double step = Double.valueOf(0.01).doubleValue();

		Variable x = Variable.make("x");
		Variable y = Variable.make("y");
		Variable z = Variable.make("z");
		for (double xval = low; xval <= high; xval += step) {
			x.setValue(xval);
			y.setValue(xval);
			z.setValue(xval);
			System.out.println("x = " + x.value() + "; --> " + expr.value());
		}
	}
}
