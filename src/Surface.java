import java.util.Vector;

// referance 
//http://www.maplesoft.com/support/help/maple/view.aspx?path=MathApps%2FEquationofaPlane3Points
public class Surface {
	private final int RANGE =10;
	private final int AFTER_DOT=100;//3 number after dot 
	double a,b,c,d;

	Surface(Vertex v1,Vertex v2, Vertex v3){

		Vector<Double> v1_v2 = new Vector<Double>(3);

		v1_v2.add(0, v2.x-v1.x);
		v1_v2.add( 1,v2.y-v1.y);
		v1_v2.add(2,v2.z-v1.z);

		Vector<Double> v1_v3 = new Vector<Double>(3);
		v1_v3.add(0,v3.x-v1.x);
		v1_v3.add(1,v3.y-v1.y);
		v1_v3.add(2,v3.z-v1.z);

		this.a = v1_v2.get(1)*v1_v3.get(2) - v1_v2.get(2)*v1_v3.get(1);
		this.b = v1_v2.get(2)*v1_v3.get(0) - v1_v2.get(0)*v1_v3.get(2);
		this.c = v1_v2.get(0)*v1_v3.get(1) - v1_v2.get(1)*v1_v3.get(0);
		this.d = -(a*v1.x +b*v1.y + c*v1.z);		
		this.a =  Math.floor(a*AFTER_DOT)/AFTER_DOT;
		this.b =  Math.floor(b*AFTER_DOT)/AFTER_DOT;
		this.c =  Math.floor(c*AFTER_DOT)/AFTER_DOT;
		this.d =  Math.floor(d*AFTER_DOT)/AFTER_DOT;
		
	}
/**
 * 
 * @param ver
 * @return if Vertex ver on the surface
 */
	public boolean onSurface(Vertex ver){
		if(0==a*ver.x +b*ver.y + c*ver.z+d) return true;
		else return false;
	}

	@Override
	public String toString() {
		return " [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	}


}
