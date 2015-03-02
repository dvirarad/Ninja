package ariel.final_year.gui;

import java.io.IOException;

import ariel.final_year.expression.SyntaxException;
import ariel.final_year.main_algorithm.ExprCondition;
import ariel.final_year.main_algorithm.Graph;
import ariel.final_year.parsing_out.ParsingOut;
import ariel.final_year.utilities.StaticMethods;
import ariel.final_year.utilities.StaticVars;

public class GraphApplication {

	private int vertexSize;
	private ExprCondition exCondition;
	private GraphStyle[] graphStyle;
	private boolean[][] adjacencyMatrix;

	public GraphApplication(int vs, String expration) {
		
		
		this.vertexSize = vs;
		
		try {

			this.exCondition = new ExprCondition(expration);
			
			fillMatrix();
			
			Graph graph = new Graph(vertexSize, exCondition);
			ParsingOut po = new ParsingOut(adjacencyMatrix,graph.getVertices());
			String fileName = po.generateOutput();
			
			if(StaticMethods.isWindows()) {
				new ProcessBuilder(StaticVars.WIN_EXEC, fileName).start();
			} else if(StaticMethods.isMac()) {
				new ProcessBuilder("open", StaticVars.MAC_EXEC, fileName).start();
			}
			
		} catch (SyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public int getVertexSize() {
		return vertexSize;
	}

	public void setVertexSize(int vertexSize) {
		this.vertexSize = vertexSize;
	}

	public ExprCondition getExCondition() {
		return exCondition;
	}

	public void setExCondition(ExprCondition exCondition) {
		this.exCondition = exCondition;
	}

	public boolean[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(boolean[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	private void fillMatrix() {
	
		adjacencyMatrix = GraphStyle.compliteGraph(vertexSize);
		
	}
	
	

	public static void main(String[] args) {

		int vs = 10;
		String expration = "x^2 + y^2 + z^2 - 10";
		GraphApplication ga = new GraphApplication(vs, expration);
	}
}
