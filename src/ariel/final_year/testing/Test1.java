package ariel.final_year.testing;

import java.io.File;
import java.io.IOException;

import ariel.final_year.expression.SyntaxException;
import ariel.final_year.main_algorithm.Graph;
import ariel.final_year.parsing_in.ParsingIn;
import ariel.final_year.parsing_out.ParsingOut;
import ariel.final_year.utilities.StaticMethods;
import ariel.final_year.utilities.StaticVars;

public class Test1 {
	public static void main(String[] args) {
		
		try {
			
			File f = new File("input.xml");
			ParsingIn pi = new ParsingIn(f);
			Graph g = new Graph(pi.getNumOfVertices(), pi.getCondition());
			ParsingOut po = new ParsingOut(pi.getAdjacencyMat(), g.getVertices());
			String fileName = po.generateOutput();
			
			if(StaticMethods.isWindows())
				new ProcessBuilder(StaticVars.WIN_EXEC, fileName).start();
			else if(StaticMethods.isMac())
				new ProcessBuilder("open", StaticVars.MAC_EXEC, fileName).start();		
			
		} catch (SyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
