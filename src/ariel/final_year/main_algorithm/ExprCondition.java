package ariel.final_year.main_algorithm;

import ariel.final_year.expression.Expr;
import ariel.final_year.expression.Parser;
import ariel.final_year.expression.SyntaxException;
import ariel.final_year.expression.Variable;

public class ExprCondition {
	
	private String stringExpr;
	private Expr expr;
	Variable x, y, z;
	
	public ExprCondition(String newExpr) throws SyntaxException {
		stringExpr = newExpr;
		expr = Parser.parse(stringExpr);
		x = Variable.make("x");
		y = Variable.make("y");
		z = Variable.make("z");
	}

	public ExprCondition(ExprCondition newExpr) throws SyntaxException {
		expr = Parser.parse(newExpr.toString());
		x = Variable.make("x");
		y = Variable.make("y");
		z = Variable.make("z");
	}

	public String toString() {
		return stringExpr;
	}
	
	public boolean isMet(Vertex v) {
		x.setValue(v.x);
		y.setValue(v.y);
		z.setValue(v.z);
		
		return expr.value() < 0;
	}
}