package ariel.final_year.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import ariel.final_year.utilities.StaticMethods;
import ariel.final_year.utilities.StaticVariables;

public class ParserOut {
	
	private boolean[][] 		adjacencyMat;
	private ArrayList<Vertex> 	vertices;
	private StringBuffer 		outputBufferWithAxes;
	private StringBuffer		outputBufferWithoutAxes;

	/**
	 * constructor
	 * @param newAdjacencyMat
	 * @param newVertices
	 */
	public ParserOut(boolean[][] newAdjacencyMat, ArrayList<Vertex> newVertices) {
		adjacencyMat = new boolean[newAdjacencyMat.length][newAdjacencyMat.length];
		for (int i = 0; i < newAdjacencyMat.length; i++) {
			adjacencyMat[i] = Arrays.copyOf(newAdjacencyMat[i], adjacencyMat[i].length);
		}

		vertices = new ArrayList<Vertex>();
		vertices.addAll(newVertices);

		outputBufferWithAxes = new StringBuffer();
		outputBufferWithoutAxes = new StringBuffer();
		
		initBuffer(outputBufferWithAxes, StaticVariables.TEMPLATE_W_AXES);
		initBuffer(outputBufferWithoutAxes, StaticVariables.TEMPLATE_WO_AXES);
		
		addExtrusions();
		addVertices();
		
	}
	
	private static void initBuffer(StringBuffer buffer, String template) {
		
		File f = new File(template);
		BufferedReader br;
		String line;
		try {
			br = new BufferedReader(new FileReader(f));
			
			while((line = br.readLine()) != null) {
				buffer.append(line + "\n");
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * adds all edges to wrl file
	 */
	private void addExtrusions() {
		outputBufferWithAxes.append("# -----START EDGES-----\n");
		outputBufferWithoutAxes.append("# -----START EDGES-----\n");
		
		for (int i = 0; i < adjacencyMat.length; i++) {
			for (int j = i + 1; j < adjacencyMat.length; j++) {
				if (adjacencyMat[i][j]) {
					Vertex vertexI = vertices.get(i), vertexJ = vertices.get(j);
					addExtrusion(outputBufferWithAxes, vertexI, vertexJ);
					addExtrusion(outputBufferWithoutAxes, vertexI, vertexJ);
				}
			}
		}
		
		outputBufferWithAxes.append("# -----END EDGES-----\n");
		outputBufferWithoutAxes.append("# -----END EDGES-----\n");
	}
	/**
	 * adds single edge to wrl file
	 * @param vertexI
	 * @param vertexJ
	 */
	private static void addExtrusion(StringBuffer buffer, Vertex vertexI, Vertex vertexJ) {
		String spineContent = vertexI.x + " " + vertexI.y + " " + vertexI.z + ", " + vertexJ.x + " " + vertexJ.y + " " + vertexJ.z;
		String spine = StaticVariables.E_SPINE + spineContent;
		
		buffer.append(StaticVariables.E_START + spine + StaticVariables.E_END);
	}
	
	/**
	 * adds all vertices to wrl file
	 */
	private void addVertices() {
		outputBufferWithAxes.append("# -----START VERTICES-----\n");
		outputBufferWithoutAxes.append("# -----START VERTICES-----\n");
		
		for (Vertex v : vertices) {
			addVertex(outputBufferWithAxes, v);
			addVertex(outputBufferWithoutAxes, v);
		}
		
		outputBufferWithAxes.append("# -----END VERTICES-----\n");
		outputBufferWithoutAxes.append("# -----END VERTICES-----\n");
	}
	/**
	 * adds single vertex to wrl file
	 * @param v
	 */
	private static void addVertex(StringBuffer buffer, Vertex v) {
		String translationContent = v.x + " " + v.y + " " + v.z;
		String translation = StaticVariables.V_TRANSLATION + translationContent;
		
		buffer.append(StaticVariables.V_START + translation + StaticVariables.V_END);
	}
	
	/**
	 * generates the wrl file into the project folder
	 */
	public String generateOutput() {
		File folder = new File("generated wrls");
		String curDate = StaticMethods.getDate();
		String fileNameWithAxes = folder.getPath() + File.separator + curDate + "_output_with_axes.wrl";
		String fileNameWithoutAxes = folder.getPath() + File.separator + curDate + "_output_without_axes.wrl";
		
		File fAxes = new File(fileNameWithAxes);
		File fWithoutAxes = new File(fileNameWithoutAxes);
		
		BufferedWriter bwa, bwwa;
		try {
			if (!folder.exists())
				folder.mkdir();
			fAxes.createNewFile();
			bwa = new BufferedWriter(new FileWriter(fAxes));
			bwwa = new BufferedWriter(new FileWriter(fWithoutAxes));
			
			bwa.write(outputBufferWithAxes.toString());
			bwwa.write(outputBufferWithoutAxes.toString());
			
			bwa.flush(); bwwa.flush();
			bwa.close(); bwwa.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileNameWithAxes;
	}
}