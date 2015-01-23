
public class Vertex {

	private final int RANGE =10;
	private final int AFTER_DOT=100;//3 number after dot 
	double x,y,z;

	public Vertex(){
		this.x = Math.floor((Math.random()*RANGE)*AFTER_DOT)/AFTER_DOT;
		this.y = Math.floor((Math.random()*RANGE)*AFTER_DOT)/AFTER_DOT;
		this.z =  Math.floor((Math.random()*RANGE)*AFTER_DOT)/AFTER_DOT;
		
	}
	
	public Vertex(double x, double y, double z) {
	
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vertex(Vertex v) {
		
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}
	
	@Override
	public String toString() {
		return "("+x+", "+y+", "+z+")";
	}

	/*public static void main(String[] args) {
		
		Vertex v1 = new Vertex();
		System.out.println(v1.toString());
		
		
	}*/
	
}
