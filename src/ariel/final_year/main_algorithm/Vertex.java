package ariel.final_year.main_algorithm;

import java.util.Random;

import ariel.final_year.utilities.StaticVars;

public class Vertex {

	public double x,y,z;

	public Vertex(){
		Random r = new Random();
		x = Math.floor((r.nextDouble()*StaticVars.RANGE*StaticVars.PRECISION)-StaticVars.RANGE*StaticVars.PRECISION/2)/StaticVars.PRECISION;
		y = Math.floor((r.nextDouble()*StaticVars.RANGE*StaticVars.PRECISION)-StaticVars.RANGE*StaticVars.PRECISION/2)/StaticVars.PRECISION;
		z = Math.floor((r.nextDouble()*StaticVars.RANGE*StaticVars.PRECISION)-StaticVars.RANGE*StaticVars.PRECISION/2)/StaticVars.PRECISION;
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
		x = Math.floor((r.nextDouble()*range*precision)-range*precision/2)/precision;
		y = Math.floor((r.nextDouble()*range*precision)-range*precision/2)/precision;
		z = Math.floor((r.nextDouble()*range*precision)-range*precision/2)/precision;
	}

	@Override
	public String toString() {
		return "("+ x +", " + y + ", " + z + ")";
	}
}
