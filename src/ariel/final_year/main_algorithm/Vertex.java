package ariel.final_year.main_algorithm;

import ariel.final_year.utilities.Vars;

public class Vertex {

	public double x,y,z;

	public Vertex(){
		x = Math.floor(Math.random()*Vars.RANGE*Vars.PRECISION)/Vars.PRECISION;
		y = Math.floor(Math.random()*Vars.RANGE*Vars.PRECISION)/Vars.PRECISION;
		z = Math.floor(Math.random()*Vars.RANGE*Vars.PRECISION)/Vars.PRECISION;
	}
	
	public Vertex(double newX, double newY, double newZ) {
		x = newX;
		y = newY;
		z = newZ;
	}
	
	public Vertex(Vertex v) {
		x = v.x;
		y = v.y;
		z = v.z;
	}
	
	public Vertex(int range, int precision) {
		x = Math.floor(Math.random()*range*precision)/precision;
		y = Math.floor(Math.random()*range*precision)/precision;
		z = Math.floor(Math.random()*range*precision)/precision;
	}

	@Override
	public String toString() {
		return "("+ x +", " + y + ", " + z + ")";
	}
}
