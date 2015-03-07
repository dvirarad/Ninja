package ariel.final_year.gui;

public class StaticData {

	public static String[] numberOfVertex() {
		int size = 40;
		String[] ans = new String[size];
		for (int i = 0; i < size; i++) {
			ans[i]= "" + (i+1);
		}
		return ans;
	}

	public static String[] ListOfEquation() {
		int size = 2;
		String[] condition = new String[size];
		
		condition[0] = "x^2 + y^2 + z^2 -9 ";
		condition[1] = "x + y + z -50"; 
		
		String[] name = new String[size];
		name[0]= "Cyrcle r - 3";
		name [1] = "YaY";
		
		Equation[] temp = new  Equation[size];
		
		
		return condition;
	}

}
