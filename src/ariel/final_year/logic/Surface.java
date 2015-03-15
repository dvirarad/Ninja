package ariel.final_year.logic;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Vector;

import ariel.final_year.utilities.StaticVariables;

// reference 
// http://www.maplesoft.com/support/help/maple/view.aspx?path=MathApps%2FEquationofaPlane3Points

public class Surface {
	
	private double a,b,c,d;

	public Surface(Vertex v1,Vertex v2, Vertex v3){
		NumberFormat nf = new DecimalFormat(StaticVariables.FORMATTER_PATTERN);
		
		Vector<Double> v1_v2 = new Vector<Double>(3);
		v1_v2.add(0, v2.x-v1.x);
		v1_v2.add(1, v2.y-v1.y);
		v1_v2.add(2, v2.z-v1.z);

		Vector<Double> v1_v3 = new Vector<Double>(3);
		v1_v3.add(0,v3.x-v1.x);
		v1_v3.add(1,v3.y-v1.y);
		v1_v3.add(2,v3.z-v1.z);

		a = v1_v2.get(1)*v1_v3.get(2) - v1_v2.get(2)*v1_v3.get(1);
		a = Double.valueOf(nf.format(a));
		
		b = v1_v2.get(2)*v1_v3.get(0) - v1_v2.get(0)*v1_v3.get(2);
		b = Double.valueOf(nf.format(b));
		
		c = v1_v2.get(0)*v1_v3.get(1) - v1_v2.get(1)*v1_v3.get(0);
		c = Double.valueOf(nf.format(c));
		
		d = -(a*v1.x +b*v1.y + c*v1.z);		
		d = Double.valueOf(nf.format(d));
	}
	
	/**
	* 
 	* @param ver
 	* @return if Vertex ver on the surface
 	*/
	public boolean includesVertex(Vertex ver){
		if (a*ver.x + b*ver.y + c*ver.z + d == 0)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "(" + a + ")" + "x + " + "(" + b + ")" + "y + " + "(" + c + ")" + "z + " + "(" + d + ") = 0";
	}
}
