package ariel.final_year.main_algorithm;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {

	private ArrayList<Vertex> vertex;
	private ArrayList<SurfaceEquation> surfaces;

	private int maxVertexSearch = 0;
	private int vSize, range, condition;
	
	public Graph(ArrayList<Vertex> _vertex) {
		vertex = new ArrayList<Vertex>();
		surfaces = new ArrayList<SurfaceEquation>();
		Vertex temp;

		for (Vertex ver : _vertex) {	
			do {
				temp = new Vertex(ver);
			} while (belongsToDefinedPlane(temp));
			
			addSufaceEquations(temp);
			vertex.add(new Vertex(temp));
		}
	}

	public Graph(int n){
		vertex = new ArrayList<Vertex>();
		surfaces = new ArrayList<SurfaceEquation>(getNumOfPlanes(n));
		Vertex temp;

		for (int i = 0; i < n; i++) {
			do {
				temp = new Vertex();
			} while (belongsToDefinedPlane(temp));
			
			addSufaceEquations(temp);
			vertex.add(new Vertex(temp));
		}
	}

	/**
	 * 
	 * @param vSize number of vertexs
	 * @param boxSize size of edge in square
	 * @param range aomunt of number after the point
	 */
	public Graph(int vSize, int boxSize, int range) {
		
		this.vSize =vSize;
		this.condition = boxSize;
		this.range =range;
		
		vertex = new ArrayList<Vertex>();
		surfaces = new ArrayList<SurfaceEquation>(getNumOfPlanes(vSize));
		Vertex temp;

		for (int i = 0; i < vSize; i++) {
			int j =0;
			do {
				temp = new Vertex(condition,range);
				if (maxVertexSearch < ++j) 
					maxVertexSearch =j;
			} while (belongsToDefinedPlane(temp));			
			
			addSufaceEquations(temp);
			vertex.add(new Vertex(temp));
		}
	}

	/**
	 * Adds all the possible combinations of plane o(n^2)
	 * @param ver Vertex to Add
	 */
	private void addSufaceEquations(Vertex ver) {
		if(vertex.size() >= 2){
			for (int i = 0; i < vertex.size(); i++) {
				for (int j = i+1; j < vertex.size(); j++) {
					surfaces.add(new SurfaceEquation(vertex.get(i), vertex.get(j), ver));
				}
			}
		}
	}
	
	/**
	 * Checks if a point belongs to an already defined plane o(n^3)
	 * @param ver
	 * @return true if ver belongs to an already defined plane
	 */
	private boolean belongsToDefinedPlane(Vertex ver) {
		for (SurfaceEquation surface : surfaces) 
			if (surface.includesVertex(ver)) 
				return true;

		return false;
	}
	
	public static int getNumOfPlanes(int n) {
		int res = 1;
		for (int i = 3; i < n; i++) {
			res += (i*(i-1))/2;
		}
		
		return res;
	}
	
	@Override
	public String toString() {
		StringBuffer print = new StringBuffer();
		
		print.append("Graph\n"+"Vertexs\n") ;
		for (int i = 0; i < vertex.size(); i++) {
			print.append((i+1)+") "+vertex.get(i).toString()+"\n");
		}
		print.append("Surfaces\n");
		for (int i = 0; i < surfaces.size(); i++) {
			print.append((i+1)+") "+surfaces.get(i).toString()+"\n");
			if (i%1000 == 0)
				System.out.println("test: " + i);
		}
	
		return print.toString();
	}

	public static void main(String[] args) {
		ArrayList<Vertex> vertex = new ArrayList<Vertex>();
		int vSize =74;
		int boxSize =4;
		int range=10;

		//int n=100;
		Graph g = new Graph(vSize,boxSize,range);
	//	Graph g1 = new Graph(n);
		g.resultLog("Test5");
		//System.out.println(g.toString());
		//System.out.println(g.testToString());
		
		/*	Surface[] test = new Surface[getNumOfPlanes(n)];
		for (int i = 0; i < test.length; i++) {
			test[i] = new Surface(new Vertex(i,i+2,i-3),new Vertex(i,i-3,i),new Vertex(i+4,i,i));
			if (i%1000 == 0)
				System.out.println("test: " + i);
		}*/

		/*Vertex v1 = new Vertex(1,1,1);
		Vertex v2= new Vertex(-1,1,0);
		Vertex v3 = new Vertex(2,0,3);
		vertex.add(v1);
		vertex.add(v2);
		vertex.add(v3);*/


		/*Vertex v1 = new Vertex(1,-2,0);
		Vertex v2= new Vertex(3,1,4);
		Vertex v3 = new Vertex(0,-1,2);
		vertex.add(v1);
		vertex.add(v2);
		vertex.add(v3);*/

		/*Graph g = new Graph(vertex);
		System.out.println(g.toString());*/
	}

	/**
	 * Create file with results
	 * number of vertex
	 * number of surface
	 * condition, ragne.
	 * max time to find free vertex
	 * @param string file name
	 */
	private void resultLog(String filename) {
		try{
			String fileName =filename;
			
			File file = new File(fileName+".txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Graph 3D");
			bw.newLine();
			bw.write("Number of vertices: "+ vSize);
			bw.newLine();
			bw.write("Number of Surface: "+ getNumOfPlanes(vSize));
			bw.newLine();
			bw.write("Condition - Square's edge size: "+ condition);
			bw.newLine();
			bw.write("Range "+ range);
			bw.newLine();
			bw.write("Max number of points checked: "+ maxVertexSearch);
			
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}