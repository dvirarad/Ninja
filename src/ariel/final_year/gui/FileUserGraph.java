package ariel.final_year.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

import ariel.final_year.expression.SyntaxException;
import ariel.final_year.main_algorithm.ExprCondition;

public class FileUserGraph {

	int numOfVertices;
	boolean[][] adjacencyMat; 
	final File folder = new File("graphUserInput");

	public FileUserGraph(JFileChooser aChooser) {

		JFileChooser fileChooser = aChooser;
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String name = selectedFile.getAbsolutePath();
			readGraph(name);


		}
	}





public void readGraph(String  name) {
	BufferedReader br ;
	String line;

	try {
		br = new BufferedReader(new FileReader(name));
		numOfVertices = Integer.parseInt(br.readLine());
		adjacencyMat = new boolean[numOfVertices][numOfVertices];
		int counterLine =0;
		while((line = br.readLine()) != null) {
			String yay ="";
			StringTokenizer st = new StringTokenizer(line, " ,[]");
			for (int i = 0; i < adjacencyMat.length; i++) {
				if ((yay = st.nextToken())!=null) {
					if (yay.charAt(0)=='t') {
						adjacencyMat[counterLine][i] =true;
					}				
				}
			}
			counterLine++;
		}
		for (int i = 0; i < adjacencyMat.length; i++) {
			System.out.println(Arrays.toString(adjacencyMat[i]));
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

}
