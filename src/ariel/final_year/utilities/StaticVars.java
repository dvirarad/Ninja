package ariel.final_year.utilities;

public class StaticVars {
	public static final int AFTER_DOT 			= 100;
	public static final int RANGE 				= 10; // range to set the coordinates in
	public static final int PRECISION 			= 100; // numbers after dot
	
	public static final String TEMPLATE 		= "output_template.wrl";
	
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

	public static final String RADIUS_XL 		= "1.5";
	public static final String RADIUS_L 		= "0.2";
	public static final String RADIUS_M 		= "0.1";
	public static final String RADIUS_S 		= "0.04";
	public static final String RADIUS_XS 		= "0.02";
	
	public static final String V_START 			= "Transform {\n";
	public static final String V_END 			= "\n\tchildren Shape {\n\t\tappearance USE lookV\n\t\tgeometry Sphere {\n\t\t\tradius " + RADIUS_XS + "\n\t\t} # end sphere\n\t} # end shape\n} # end transform\n";
	public static final String V_TRANSLATION 	= "\ttranslation ";
	
	public static final String E_START 			= "Transform {\n\tchildren Shape {\n\t\tappearance USE lookE\n\t\tgeometry Extrusion {\n\t\t\tbeginCap FALSE\n\t\t\tendCap FALSE\n\t\t\tsolid FALSE\n\t\t\tcreaseAngle 1.0\n\t\t\tcrossSection ["
			+ X_SECTION_XS + "] # end cross section\n";
	public static final String E_END 			= "] # end spine\n\t\t} # end extrusion\n\t} # end shape\n} # end transform\n";
	public static final String E_SPINE 			= "\t\t\tspine [";
	
	public static String OS 					= System.getProperty("os.name").toLowerCase();
	public static String WIN_EXEC				= "FreeWRL-WIN/freeWRL.exe";
	public static String MAC_EXEC				= "FreeWRL-MAC/FreeWRL.app";
	
}
