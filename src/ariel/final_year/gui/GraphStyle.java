package ariel.final_year.gui;

import java.util.Arrays;

public class GraphStyle {

	public static boolean[][] compliteGraph(int n){
		boolean[][] graph = new boolean[n][n];

		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(graph[i], true);
			graph[i][i]=false;
		}

		return graph;
	}

	public static String[] toString(boolean[][] graphMatrix) {
		String[][] view = new String[graphMatrix.length][graphMatrix.length];
		String ans[] = new String[graphMatrix.length];
		for (int i = 0; i < graphMatrix.length; i++) {
			for (int j = 0; j < graphMatrix.length; j++) {
				if (graphMatrix[i][j]) {
					view[i][j] ="1";
				}
				else
					view[i][j]="-";
			}
		}
		for (int i = 0; i < view.length; i++) {
			ans[i] =  Arrays.toString(view[i]);
		}
		return ans;
	}



}
