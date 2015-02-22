package ariel.final_year.parsing_out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import ariel.final_year.main_algorithm.Vertex;

public class ParsingOut {
	
	private final String TEMPLATE 		= "output_template.wrl";
	
	private final String V_START 		= "Transform {\n";
	private final String V_END 			= "\n\tchildren Shape {\n\t\tgeometry Sphere {\n\t\t\tradius 0.2\n\t\t} # end sphere\n\t} # end shape\n} # end transform\n";
	private final String V_TRANSLATION 	= "\ttranslation ";
	
	private final String E_START 		= "Transform {\n\tchildren Shape {\n\t\tappearance USE look\n\t\tgeometry Extrusion {\n\t\t\tbeginCap FALSE\n\t\t\tendCap FALSE\n\t\t\tsolid FALSE\n\t\t\tcreaseAngle 1.0\n\t\t\tcrossSection [0.10  0.00,0.092 -0.038,0.071 -0.071,0.038 -0.092,0.00 -0.10,-0.038 -0.092,-0.071 -0.071,-0.092 -0.038,-0.10 -0.00,-0.092  0.038,-0.071  0.071,-0.038  0.092,0.00  0.10,0.038  0.092,0.071  0.071,0.092  0.038,0.10  0.00] # end cross section\n";
	private final String E_END 			= "] # end spine\n\t\t} # end extrusion\n\t} # end shape\n} # end transform\n";
	private final String E_SPINE 		= "\t\t\tspine [";
	
	private boolean[][] 		adjacencyMat;
	private ArrayList<Vertex> 	vertices;
	private StringBuffer 		outputBuffer;

	public ParsingOut(boolean[][] newAdjacencyMat, ArrayList<Vertex> newVertices) {
		adjacencyMat = new boolean[newAdjacencyMat.length][newAdjacencyMat.length];
		for (int i = 0; i < newAdjacencyMat.length; i++) {
			adjacencyMat[i] = Arrays.copyOf(newAdjacencyMat[i], adjacencyMat[i].length);
		}

		vertices = new ArrayList<Vertex>();
		vertices.addAll(newVertices);

		outputBuffer = new StringBuffer();
		File f = new File(TEMPLATE);
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
	}

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
	private void addExtrusion(Vertex vertexI, Vertex vertexJ) {
		String spineContent = vertexI.x + " " + vertexI.y + " " + vertexI.z + ", " + vertexJ.x + " " + vertexJ.y + " " + vertexJ.z;
		String spine = E_SPINE + spineContent;
		
		outputBuffer.append(E_START + spine + E_END);
	}
	
	private void addVertices() {
		outputBuffer.append("# -----START VERTICES-----\n");
		
		for (Vertex v : vertices) {
			addVertex(v);
		}
		
		outputBuffer.append("# -----END VERTICES-----\n");
	}
	private void addVertex(Vertex v) {
		String translationContent = v.x + " " + v.y + " " + v.z;
		String translation = V_TRANSLATION + translationContent;
		
		outputBuffer.append(V_START + translation + V_END);
	}
	
	private static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy_HH-mm");
		return formatter.format(new Date());
	}
	
	public void generateOutput() {
		File f = new File(getDate() + "_output.wrl");
		BufferedWriter bw;
		try {
			f.createNewFile();
			bw = new BufferedWriter(new FileWriter(f));
			
			bw.write(outputBuffer.toString());
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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