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

	public static boolean[][] randomGraph(int n) {
		
		boolean[][] graph = new boolean[n][n];
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				int rand = (int) (Math.random()*2);
				if (rand==1) 
					graph[i][j] = true;
				
				else
					graph[i][j] = false;
			}
		}
		return graph;
	}
	public static boolean[][] modGraph3(int n) {
boolean[][] graph = new boolean[n][n];
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				int rand = (int) (Math.random()*2);
				if ((i+j)%3 ==1) 
					graph[i][j] = true;
				
				else
					graph[i][j] = false;
			}
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
