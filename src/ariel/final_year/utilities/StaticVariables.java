package ariel.final_year.utilities;

public class StaticVariables {
	public static final int RANGE 					= 10; // range to set the coordinates in

	public static final int COMPLETE_ID = 0;
	public static final int RANDOM_ID = 1;
	public static final int MOD3_ID = 2;
	
	public static final String FORMATTER_PATTERN 	= "#0.00";
	public static final String BOOLEAN_SEPARATOR	= " ,[]";
	
	public static final String TEMPLATE_W_AXES		= "output_with_axes.template";
	public static final String TEMPLATE_WO_AXES		= "output_without_axes.template";
	public static final String FOLDER_CONDITIONS	= "folder-conditions";
	public static final String FOLDER_USER_GRAPHS	= "folder-user-graphs";
	
	public static final String BOOLEAN_HEADER		= "boolean";
	public static final String INTEGER_HEADER		= "integer";
	
	// radius = 1 --> 100mm || 1' (2,54cm)
	public static final String X_SECTION_XL 	= "1.0 0.00,"
			+ "0.92 	-0.38,"
			+ "0.71 	-0.71,"
			+ "0.38 	-0.92,"
			+ "0.00 	-1.0,"
			+ "-0.38 	-0.92,"
			+ "-0.71 	-0.71,"
			+ "-0.92 	-0.38,"
			+ "-1.0 	-0.00,"
			+ "-0.92  	0.38,"
			+ "-0.71  	0.71,"
			+ "-0.38  	0.92,"
			+ "0.00  	1.0,"
			+ "0.38  	0.92,"
			+ "0.71  	0.71,"
			+ "0.92  	0.38,"
			+ "1.0  	0.00";
	// radius = 1 --> 10mm || 0.1' (0.254cm)
	public static final String X_SECTION_L 		= "0.10 0.00,"
			+ "0.092 	-0.038,"
			+ "0.071 	-0.071,"
			+ "0.038 	-0.092,"
			+ "0.00 	-0.10,"
			+ "-0.038 	-0.092,"
			+ "-0.071 	-0.071,"
			+ "-0.092 	-0.038,"
			+ "-0.10 	-0.00,"
			+ "-0.092  	0.038,"
			+ "-0.071  	0.071,"
			+ "-0.038  	0.092,"
			+ "0.00  	0.10,"
			+ "0.038  	0.092,"
			+ "0.071  	0.071,"
			+ "0.092  	0.038,"
			+ "0.10  	0.00";
	// radius = 1 --> 1mm || 0.01' (0.0254cm)
	public static final String X_SECTION_M 		= "0.010  0.00,"
			+ "0.0092 	-0.0038,"
			+ "0.0071 	-0.0071,"
			+ "0.0038 	-0.0092,"
			+ "0.00 	-0.010,"
			+ "-0.0038 	-0.0092,"
			+ "-0.0071 	-0.0071,"
			+ "-0.0092 	-0.0038,"
			+ "-0.010 	-0.00,"
			+ "-0.0092  0.0038,"
			+ "-0.0071  0.0071,"
			+ "-0.0038  0.0092,"
			+ "0.00  	0.010,"
			+ "0.0038  	0.0092,"
			+ "0.0071  	0.0071,"
			+ "0.0092  	0.0038,"
			+ "0.010  	0.00";
	// TOO SMALL
	public static final String X_SECTION_S 		= "0.0010  0.00,"
			+ "0.00092 		-0.00038,"
			+ "0.00071 		-0.00071,"
			+ "0.00038 		-0.00092,"
			+ "0.00 		-0.0010,"
			+ "-0.00038 	-0.00092,"
			+ "-0.00071 	-0.00071,"
			+ "-0.00092 	-0.00038,"
			+ "-0.0010 		-0.00,"
			+ "-0.00092  	0.00038,"
			+ "-0.00071  	0.00071,"
			+ "-0.00038  	0.00092,"
			+ "0.00  		0.0010,"
			+ "0.00038  	0.00092,"
			+ "0.00071  	0.00071,"
			+ "0.00092  	0.00038,"
			+ "0.0010  		0.000";
	// TOO SMALL
	public static final String X_SECTION_XS		= "0.00150000 0.00000000,"
			+ "0.00121353 	0.00088168,"
			+ "0.00046353 	0.00142658,"
			+ "-0.00046352 	0.00142658,"
			+ "-0.00121353 	0.00088168,"
			+ "-0.00150000 	0.00000000,"
			+ "-0.00121353 	-0.00088168,"
			+ "-0.00046353 	-0.00142658,"
			+ "0.00046352 	-0.00142659,"
			+ "0.00121352 	-0.00088168,"
			+ "0.00150000 	0.00000000";

	// radius = 1.5 --> 150mm || 1.5' (3.81cm)
	public static final String RADIUS_XL 		= "1.5";
	// radius = 0.2 --> 20mm || 0.2' (0.5 cm)
	public static final String RADIUS_L 		= "0.2";
	// radius = 0.1 --> 10mm || 0.1' (0.25 cm)
	public static final String RADIUS_M 		= "0.1";
	// TOO SMALL
	public static final String RADIUS_S 		= "0.04";
	// TOO SMALL
	public static final String RADIUS_XS 		= "0.02";
	
	public static final String V_START 			= "Transform {\n";
	public static final String V_END 			= "\n\tchildren Shape {\n\t\tappearance USE lookV\n\t\tgeometry Sphere {\n\t\t\tradius " + RADIUS_XS + "\n\t\t} # end sphere\n\t} # end shape\n} # end transform\n";
	public static final String V_TRANSLATION 	= "\ttranslation ";
	
	public static final String E_START 			= "Transform {\n\tchildren Shape {\n\t\tappearance USE lookE\n\t\tgeometry Extrusion {\n\t\t\tbeginCap TRUE\n\t\t\tendCap TRUE\n\t\t\tsolid TRUE\n\t\t\tcreaseAngle 1.0\n\t\t\tcrossSection ["
			+ X_SECTION_XS + "] # end cross section\n";
	public static final String E_END 			= "] # end spine\n\t\t} # end extrusion\n\t} # end shape\n} # end transform\n";
	public static final String E_SPINE 			= "\t\t\tspine [";
	
	public static String OS 					= System.getProperty("os.name").toLowerCase();
	public static String WIN_EXEC				= "FreeWRL-WIN/freeWRL.exe";
	public static String MAC_EXEC				= "FreeWRL-MAC/FreeWRL.app";
	
}
