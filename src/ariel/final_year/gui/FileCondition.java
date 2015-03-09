package ariel.final_year.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class FileCondition {


	ArrayList<Node> conditionList;
	final File folder = new File("condition");

	public FileCondition() {
		conditionList = new ArrayList<Node>();

		listFilesForFolder(folder);

		for (int i = 0; i < conditionList.size(); i++) {
			System.out.println(conditionList.get(i));
		}
	}



	public void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				getFormola(fileEntry.getName());

			}
		}
	}



	private void getFormola(String name) {
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(folder.getPath()+File.separator+name));
			if((sCurrentLine = br.readLine()) != null){
				conditionList.add(new Node(name,sCurrentLine));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}






	public String[] getConditionName() {

		String[] name = new String[conditionList.size()];
		for (int i = 0; i < name.length; i++) {
			name[i] = conditionList.get(i).name;
		}
		return name;
	}



	public void writeCondition(String formola,JFileChooser aChooser) {
		System.out.println(formola);

		JFileChooser chooser = aChooser;
		chooser.setCurrentDirectory(new File(folder.getName()));
		int retrival = chooser.showSaveDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			try {
				FileWriter fw = new FileWriter(chooser.getSelectedFile());
				fw.write(formola);

				fw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}



	public String[] ReadCondition(JFileChooser aChooser) {

		JFileChooser fileChooser = aChooser;
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String name = selectedFile.getName();
			String formula ="";
			try {
				FileReader fr = new FileReader(selectedFile);
				BufferedReader br = new BufferedReader(fr); 
				

				if((formula = br.readLine()) != null) { 
					


					fr.close(); 

				}
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			String[] temp  =  {name,formula};
			return  temp;
		}
		return null;
	}
}

class Node {

	String name, formula;

	public Node(String aName, String form) {
		this.name = aName;
		this.formula = form;
	}

	public String toString(){
		return name +", "+ formula;
	}

}