package ariel.final_year.parsing_out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import ariel.final_year.main_algorithm.Vertex;
import ariel.final_year.utilities.StaticMethods;
import ariel.final_year.utilities.Vars;

public class ParsingOut {
	
	private boolean[][] 		adjacencyMat;
	private ArrayList<Vertex> 	vertices;
	private StringBuffer 		outputBuffer;

	/**
	 * constructor
	 * @param newAdjacencyMat
	 * @param newVertices
	 */
	public ParsingOut(boolean[][] newAdjacencyMat, ArrayList<Vertex> newVertices) {
		adjacencyMat = new boolean[newAdjacencyMat.length][newAdjacencyMat.length];
		for (int i = 0; i < newAdjacencyMat.length; i++) {
			adjacencyMat[i] = Arrays.copyOf(newAdjacencyMat[i], adjacencyMat[i].length);
		}

		vertices = new ArrayList<Vertex>();
		vertices.addAll(newVertices);

		outputBuffer = new StringBuffer();
		File f = new File(Vars.TEMPLATE);
		BufferedReader br;
		String line;
		try {
			br = new BufferedReader(new FileReader(f));
			
			while((line = br.readLine()) != null) {
				outputBuffer.append(line + "\n");
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addExtrusions();
		addVertices();
	}

	/**
	 * adds all edges to wrl file
	 */
	private void addExtrusions() {
		outputBuffer.append("# -----START EDGES-----\n");
		
		for (int i = 0; i < adjacencyMat.length; i++) {
			for (int j = i + 1; j < adjacencyMat.length; j++) {
				if (adjacencyMat[i][j]) {
					Vertex vertexI = vertices.get(i), vertexJ = vertices.get(j);
					addExtrusion(vertexI, vertexJ);
				}
			}
		}
		
		outputBuffer.append("# -----END EDGES-----\n");
	}
	/**
	 * adds single edge to wrl file
	 * @param vertexI
	 * @param vertexJ
	 */
	private void addExtrusion(Vertex vertexI, Vertex vertexJ) {
		String spineContent = vertexI.x + " " + vertexI.y + " " + vertexI.z + ", " + vertexJ.x + " " + vertexJ.y + " " + vertexJ.z;
		String spine = Vars.E_SPINE + spineContent;
		
		outputBuffer.append(Vars.E_START + spine + Vars.E_END);
	}
	
	/**
	 * adds all vertices to wrl file
	 */
	private void addVertices() {
		outputBuffer.append("# -----START VERTICES-----\n");
		
		for (Vertex v : vertices) {
			addVertex(v);
		}
		
		outputBuffer.append("# -----END VERTICES-----\n");
	}
	/**
	 * adds single vertex to wrl file
	 * @param v
	 */
	private void addVertex(Vertex v) {
		String translationContent = v.x + " " + v.y + " " + v.z;
		String translation = Vars.V_TRANSLATION + translationContent;
		
		outputBuffer.append(Vars.V_START + translation + Vars.V_END);
	}
	
	/**
	 * generates the wrl file into the project folder
	 */
	public String generateOutput() {
		File folder = new File("generated wrls");
		String fileName = folder.getPath() + File.separator + StaticMethods.getDate() + "_output.wrl";
		File f = new File(fileName);
		BufferedWriter bw;
		try {
			if (!folder.exists())
				folder.mkdir();
			f.createNewFile();
			bw = new BufferedWriter(new FileWriter(f));
			
			bw.write(outputBuffer.toString());
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}

	public static void main(String[] args) {
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(new Vertex(1, 2, 3));
		vertices.add(new Vertex(1, 3, 4));
		vertices.add(new Vertex(-1, -2, -3));
		
		boolean[][] adjacencyMat = new boolean[][]{
				{false, true, true},
				{true, false, false},
				{true, false, false}
		};
		
		ParsingOut po = new ParsingOut(adjacencyMat,vertices);
		po.addExtrusions();
		po.addVertices();
		po.generateOutput();
	}
}