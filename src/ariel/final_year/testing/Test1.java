package ariel.final_year.testing;

import java.io.File;
import java.io.IOException;

import ariel.final_year.expression.SyntaxException;
import ariel.final_year.main_algorithm.Graph;
import ariel.final_year.parsing_in.ParsingIn;
import ariel.final_year.parsing_out.ParsingOut;

public class Test1 {
	public static void main(String[] args) {
		try {
			File f = new File("input.xml");
			ParsingIn pi = new ParsingIn(f);
			Graph g = new Graph(pi.getNumOfVertices(), pi.getCondition());
			ParsingOut po = new ParsingOut(pi.getAdjacencyMat(), g.getVertices());
			String fileName = po.generateOutput();
			
			new ProcessBuilder("freeWRL.2\\freeWRL.exe", fileName).start();
			
		} catch (SyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
