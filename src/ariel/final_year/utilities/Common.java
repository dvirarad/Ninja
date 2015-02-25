package ariel.final_year.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
	
	/**
	 * gets date and time as string
	 * @return
	 */
	public static String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy_HH-mm");
		return formatter.format(new Date());
	}
}
