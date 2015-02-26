package ariel.final_year.utilities;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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
	public static void generateFullGraphText(int numOfVertices) {
		for (int i = 0; i < numOfVertices; i++) {
			System.out.print(i + 1 + ":");
			for (int j = 0; j < numOfVertices; j++) {
				if(j != i)
					System.out.print(j+1 + " ");
			}
			System.out.println();
		}
	}

	public static boolean isWindows() {
		return (StaticVars.OS.indexOf("win") >= 0);
	}
 
	public static boolean isMac() {
		return (StaticVars.OS.indexOf("mac") >= 0);
	}

	public static void main(String[] args) {
		generateFullGraphText(60);
	}
}
