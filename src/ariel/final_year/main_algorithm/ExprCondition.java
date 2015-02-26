package ariel.final_year.main_algorithm;

import ariel.final_year.expression.Expr;
import ariel.final_year.expression.Parser;
import ariel.final_year.expression.SyntaxException;
import ariel.final_year.expression.Variable;

public class ExprCondition {
	
	private String stringExpr;
	private Expr expr;

	public ExprCondition(String newExpr) throws SyntaxException {
		stringExpr = newExpr;
		expr = Parser.parse(stringExpr);
	}

	public ExprCondition(ExprCondition newExpr) throws SyntaxException {
		expr = Parser.parse(newExpr.toString()); 
	}

	public String toString() {
		return stringExpr;
	}
	
	public boolean isMet(Vertex v) {
		Variable x = Variable.make("x"); x.setValue(v.x);
		Variable y = Variable.make("y"); y.setValue(v.y);
		Variable z = Variable.make("z"); z.setValue(v.z);

		return expr.value() < 0;
	}
}