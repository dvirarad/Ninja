package ariel.final_year.main_algorithm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

import ariel.final_year.utilities.StaticVars;

public class Vertex {

	public double x,y,z;

	public Vertex(){
		NumberFormat nf = new DecimalFormat(StaticVars.FORMATTER_PATTERN);
		Random r = new Random();
		x = (r.nextDouble()*StaticVars.RANGE)-StaticVars.RANGE/2; x = Double.valueOf(nf.format(x));
		y = (r.nextDouble()*StaticVars.RANGE)-StaticVars.RANGE/2; y = Double.valueOf(nf.format(y));
		z = (r.nextDouble()*StaticVars.RANGE)-StaticVars.RANGE/2; z = Double.valueOf(nf.format(z));
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

	public Vertex(int range) {
		NumberFormat nf = new DecimalFormat(StaticVars.FORMATTER_PATTERN);
		Random r = new Random();
		x = (r.nextDouble()*range)-range/2; x = Double.valueOf(nf.format(x));
		y = (r.nextDouble()*range)-range/2; y = Double.valueOf(nf.format(y));
		z = (r.nextDouble()*range)-range/2; z = Double.valueOf(nf.format(z));
	}

	@Override
	public String toString() {
		return "("+ x +", " + y + ", " + z + ")";
	}
}
