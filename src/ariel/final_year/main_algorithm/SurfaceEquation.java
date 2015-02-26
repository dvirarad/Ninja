package ariel.final_year.main_algorithm;
import java.util.Vector;

import ariel.final_year.utilities.StaticVars;

// reference 
// http://www.maplesoft.com/support/help/maple/view.aspx?path=MathApps%2FEquationofaPlane3Points

public class SurfaceEquation {
	
	private double a,b,c,d;

	public SurfaceEquation(Vertex v1,Vertex v2, Vertex v3){

		Vector<Double> v1_v2 = new Vector<Double>(3);

		v1_v2.add(0, v2.x-v1.x);
		v1_v2.add(1, v2.y-v1.y);
		v1_v2.add(2, v2.z-v1.z);

		Vector<Double> v1_v3 = new Vector<Double>(3);
		v1_v3.add(0,v3.x-v1.x);
		v1_v3.add(1,v3.y-v1.y);
		v1_v3.add(2,v3.z-v1.z);

		a = v1_v2.get(1)*v1_v3.get(2) - v1_v2.get(2)*v1_v3.get(1);
		a =  Math.floor(a*StaticVars.AFTER_DOT)/StaticVars.AFTER_DOT;
		
		b = v1_v2.get(2)*v1_v3.get(0) - v1_v2.get(0)*v1_v3.get(2);
		b =  Math.floor(b*StaticVars.AFTER_DOT)/StaticVars.AFTER_DOT;
		
		c = v1_v2.get(0)*v1_v3.get(1) - v1_v2.get(1)*v1_v3.get(0);
		c =  Math.floor(c*StaticVars.AFTER_DOT)/StaticVars.AFTER_DOT;
		
		d = -(a*v1.x +b*v1.y + c*v1.z);		
		d =  Math.floor(d*StaticVars.AFTER_DOT)/StaticVars.AFTER_DOT;
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
