package ariel.final_year.main_algorithm;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import ariel.final_year.expression.SyntaxException;

public class Graph {

	private int 			numOfVertices;
	private ExprCondition 	condition;

	private ArrayList<SurfaceEquation> 	surfaces;
	private ArrayList<Vertex> 			vertices;
	private int 						precision;
	private int 						maxVertexSearch = 0;

	public Graph(int newNumOfVertices, ExprCondition newCondition) throws SyntaxException {

		numOfVertices 	= newNumOfVertices;
		condition 		= new ExprCondition(newCondition);

		surfaces		= new ArrayList<SurfaceEquation>();
		vertices		= new ArrayList<Vertex>();
		
		doYourThing();
	}
	
	/**
	 * constructor
	 * @param newNumOfVertices number of vertexs
	 * @param newCondition size of edge in square
	 * @param newPrecision aomunt of number after the point
	 * @throws SyntaxException 
	 */
	public Graph(int newNumOfVertices, ExprCondition newCondition, boolean[][] newAdjacencyMat, int newPrecision) throws SyntaxException {

		numOfVertices 	= newNumOfVertices;
		condition 		= new ExprCondition(newCondition);

		surfaces		= new ArrayList<SurfaceEquation>();
		vertices		= new ArrayList<Vertex>();
		precision 		= newPrecision;
		
		doYourThing();
	}

	/**
	 * assign coordinates to vertices
	 */
	public void doYourThing() {
		Vertex temp;

		for (int i = 0; i < numOfVertices; i++) {
			int j =0;
			do {
				temp = new Vertex();
				if (maxVertexSearch < ++j) 
					maxVertexSearch = j;
				if(!condition.isMet(temp)) System.out.println("AGAIN");
			} while (belongsToDefinedPlane(temp) && !condition.isMet(temp));			

			addSufaceEquations(temp);
			vertices.add(new Vertex(temp));
		}
	}
	
	public ArrayList<Vertex> getVertices() {
		return vertices;
	}
	
	/**
	 * Adds all the possible combinations of plane o(n^2)
	 * @param ver Vertex to Add
	 */
	private void addSufaceEquations(Vertex ver) {
		if(vertices.size() >= 2){
			for (int i = 0; i < vertices.size(); i++) {
				for (int j = i+1; j < vertices.size(); j++) {
					surfaces.add(new SurfaceEquation(vertices.get(i), vertices.get(j), ver));
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

	/**
	 * computes number of planes given number of vertices
	 * @param n
	 * @return
	 */
	public static int computeNumOfPlanes(int numOfVertices) {
		int res = 1;
		for (int i = 3; i < numOfVertices; i++) {
			res += (i*(i-1))/2;
		}

		return res;
	}

	@Override
	public String toString() {
		StringBuffer print = new StringBuffer();

		print.append("Graph\n"+"Vertexs\n") ;
		for (int i = 0; i < vertices.size(); i++) {
			print.append((i+1)+") "+vertices.get(i).toString()+"\n");
		}
		print.append("Surfaces\n");
		for (int i = 0; i < surfaces.size(); i++) {
			print.append((i+1)+") "+surfaces.get(i).toString()+"\n");
			if (i%1000 == 0)
				System.out.println("test: " + i);
		}

		return print.toString();
	}

	/**
	 * Create file with results
	 * number of vertex
	 * number of surface
	 * condition, ragne.
	 * max time to find free vertex
	 * @param string file name
	 */
	@SuppressWarnings("unused")
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
			bw.write("Number of vertices: "+ numOfVertices);
			bw.newLine();
			bw.write("Number of Surface: "+ computeNumOfPlanes(numOfVertices));
			bw.newLine();
			bw.write("Condition - Square's edge size: "+ condition);
			bw.newLine();
			bw.write("Range "+ precision);
			bw.newLine();
			bw.write("Max number of points checked: "+ maxVertexSearch);

			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}