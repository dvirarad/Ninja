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
		String[] ans = new String[size];
		
		ans[0] = "x^2 + y^2 + z^2 -10 ";
		ans[1] = "x + y + z -50"; 
		return ans;
	}

}
