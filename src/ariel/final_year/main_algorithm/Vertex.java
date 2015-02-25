package ariel.final_year.main_algorithm;

import java.util.Random;

import ariel.final_year.utilities.Vars;

public class Vertex {

	public double x,y,z;

	public Vertex(){
		Random r = new Random();
		x = Math.floor((r.nextDouble()*Vars.RANGE*Vars.PRECISION)-Vars.RANGE*Vars.PRECISION/2)/Vars.PRECISION;
		y = Math.floor((r.nextDouble()*Vars.RANGE*Vars.PRECISION)-Vars.RANGE*Vars.PRECISION/2)/Vars.PRECISION;
		z = Math.floor((r.nextDouble()*Vars.RANGE*Vars.PRECISION)-Vars.RANGE*Vars.PRECISION/2)/Vars.PRECISION;
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
		Random r = new Random();
		x = Math.floor(r.nextDouble()*range*precision)/precision;
		y = Math.floor(r.nextDouble()*range*precision)/precision;
		z = Math.floor(r.nextDouble()*range*precision)/precision;
	}

	@Override
	public String toString() {
		return "("+ x +", " + y + ", " + z + ")";
	}
}
