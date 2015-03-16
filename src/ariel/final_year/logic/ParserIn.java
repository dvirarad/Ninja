package ariel.final_year.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import ariel.final_year.utilities.StaticVariables;

public class ParserIn {

	private int numOfVertices;
	private boolean[][] adjacencyMat;

	public ParserIn(File f) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(f));
		String inputType = br.readLine();
		br.close();

		switch(inputType) {
		case StaticVariables.BOOLEAN_HEADER:
			initBooleanInput(f);
			break;
		case StaticVariables.INTEGER_HEADER:
			initIntegerInput(f);
			break;
		}
	}

	public void initBooleanInput(File f) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		br.readLine();
		numOfVertices = Integer.parseInt(br.readLine());
		adjacencyMat = new boolean[numOfVertices][numOfVertices];
		int counterLine = 0;

		while((line = br.readLine()) != null) {
			String token = "";
			StringTokenizer st = new StringTokenizer(line, StaticVariables.BOOLEAN_SEPARATOR);
			for (int i = 0; i < adjacencyMat.length; i++) {
				if ((token = st.nextToken()) != null) {
					if (token.charAt(0) == 't') {
						adjacencyMat[counterLine][i] =true;
					}				
				}
			}
			counterLine++;
		}
		br.close();
	}
	
	public void initIntegerInput(File f) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		br.readLine();
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
		br.close();
	}

	public int getNumOfVertices() {
		return numOfVertices;
	}

	public boolean[][] getAdjacencyMat() {
		return adjacencyMat;
	}
}
