
public class Vertex {

	private final int RANGE = 10;
	private final int AFTER_DOT = 100;//3 number after dot 
	public double x,y,z;

	public Vertex(){
		x = Math.floor((Math.random()*RANGE)*AFTER_DOT)/AFTER_DOT;
		y = Math.floor((Math.random()*RANGE)*AFTER_DOT)/AFTER_DOT;
		z = Math.floor((Math.random()*RANGE)*AFTER_DOT)/AFTER_DOT;
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
	
	public Vertex(int boxSize, int range) {
		x = Math.floor(Math.random()*boxSize*range)/range;
		y = Math.floor(Math.random()*boxSize*range)/range;
		z = Math.floor(Math.random()*boxSize*range)/range;
	}

	@Override
	public String toString() {
		return "("+ x +", " + y + ", " + z + ")";
	}
}
