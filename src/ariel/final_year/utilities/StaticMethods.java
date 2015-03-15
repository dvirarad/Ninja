package ariel.final_year.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import ariel.final_year.expression.SyntaxException;

public class StaticMethods {

	/**
	 * print matrix
	 * @param adjacencyMat
	 */
	public static void printMat(boolean[][] adjacencyMat) {
		for (int i = 0; i < adjacencyMat.length; i++) {
			System.out.println(Arrays.toString(adjacencyMat[i]));
		}
	}

	public static boolean[][] copyMat(boolean[][] newMat) {
		boolean[][] returnValue = new boolean[newMat.length][newMat[0].length];
		for (int i = 0; i < newMat.length; i++) {
			returnValue[i] = Arrays.copyOf(newMat[i], newMat[i].length);
		}
		return returnValue;
	}

	/**
	 * gets date and time as string
	 * @return
	 */
	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy_HH-mm");
		return formatter.format(new Date());
	}

	/**
	 * generates the input text for full graphs
	 * @param numOfVertices
	 */
	public static void generateCompleteGraphText(int numOfVertices) {
		for (int i = 0; i < numOfVertices; i++) {
			System.out.print(i + 1 + ":");
			for (int j = 0; j < numOfVertices; j++) {
				if(j != i)
					System.out.print(j+1 + " ");
			}
			System.out.println();
		}
	}

	public static boolean[][] getGraph(int numOfVertices, int graphID) {
		switch(graphID) {
		case StaticVariables.COMPLETE_ID:
			return getCompleteGraph(numOfVertices);
		case StaticVariables.MOD3_ID:
			return getMod3Graph(numOfVertices);
		case StaticVariables.RANDOM_ID:
			return getRandomGraph(numOfVertices);
		default:
			return null;
		}
	}
	
	public static boolean[][] getCompleteGraph(int numOfVertices){
		boolean[][] graph = new boolean[numOfVertices][numOfVertices];

		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(graph[i], true);
			graph[i][i]=false;
		}

		return graph;
	}

	public static boolean[][] getRandomGraph(int numOfVertices) {
		boolean[][] graph = new boolean[numOfVertices][numOfVertices];
		Random r = new Random();

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				int rand = r.nextInt(2);
				if (rand == 1) 
					graph[i][j] = true;

				else
					graph[i][j] = false;
			}
		}
		return graph;
	}

	public static boolean[][] getMod3Graph(int numOfVertices) {
		boolean[][] graph = new boolean[numOfVertices][numOfVertices];

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if ((i+j)%3 == 1) 
					graph[i][j] = true;
				else
					graph[i][j] = false;
			}
		}
		return graph;
	}

	public static String getStringConditionFromFile(File f) throws IOException, SyntaxException {
		BufferedReader br = new BufferedReader(new FileReader(f));
		String strExpr = br.readLine();
		br.close();
		return strExpr;
	}

	public static boolean isWindows() {
		return (StaticVariables.OS.indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (StaticVariables.OS.indexOf("mac") >= 0);
	}

	public static void main(String[] args) {
		generateCompleteGraphText(40);
	}
}
