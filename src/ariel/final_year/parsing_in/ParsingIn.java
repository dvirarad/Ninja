package ariel.final_year.parsing_in;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ParsingIn {
	private int numOfVertices;
	private boolean[][] adjacencyMat;

	public ParsingIn(File f) {
		BufferedReader br;
		String line;
		
		try {
			br = new BufferedReader(new FileReader(f));
			numOfVertices = Integer.parseInt(br.readLine());
			adjacencyMat = new boolean[numOfVertices][numOfVertices];
			
			while((line = br.readLine()) != null) {
				int indexOfColon = line.indexOf(':');
				int vOnFocus = Integer.parseInt(line.substring(0, indexOfColon));
				
				String adjacencyString = line.substring(indexOfColon + 1);
				StringTokenizer st = new StringTokenizer(adjacencyString, " ");
				while(st.hasMoreTokens()) {
					adjacencyMat[vOnFocus-1][Integer.parseInt(st.nextToken())-1] = true;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getNumOfVertices() {
		return numOfVertices;
	}

	public boolean[][] getAdjacencyMat() {
		return adjacencyMat;
	}
	
	public static void main(String[] args) {
		File f = new File("/Users/Jeremie/Desktop/input.xml");
		new ParsingIn(f);
	}
}
