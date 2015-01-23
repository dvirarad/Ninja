import java.util.ArrayList;
import java.util.logging.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Graph_Static_M {




	static int counterSurface =0;
	
	Vertex[] vertex;
	Surface[]	surfaces;


	/*public Graph(ArrayList<Vertex> _vertex) {

		vertex = new ArrayList<Vertex>();
		surfaces = new ArrayList<Surface>();
		Vertex temp;

		for (Vertex ver : _vertex) {	
			do {
				temp = new Vertex(ver);
			} while (isContainsOnSurface(temp));
			addPlains(temp);
			vertex.add(new Vertex(temp));
		}
	}*/

	public Graph_Static_M(int n){

		vertex = new Vertex[n];
		surfaces = new Surface[(getNumOfPlanes(n))];
		Vertex temp;

		for (int i = 0; i < n; i++) {

			do {
				temp = new Vertex();

			} while (isContainsOnSurface(temp));//Checks if a point is on an existing plane
			addPlains(temp);//Adds all the possible combinations of plane

			vertex[i]= new Vertex(temp);

		}
	}

	/**
	 *  Adds all the possible combinations of plane o(n^2)
	 * @param ver Vertex to Add
	 */
	private void addPlains(Vertex ver) {
		if(vertex.length>=2){
			for (int i = 0; i < vertex.length; i++) {
				for (int j = i+1; j < vertex.length; j++) {
					surfaces[counterSurface] =new Surface(vertex[i], vertex[j], ver);
					counterSurface++;
				}
			}
		}
	}
	/**
	 *  Checks if a point is on an existing plane o(n^4)
	 * @param ver
	 * @return true if a point is on an existing plane 
	 */
	private boolean isContainsOnSurface(Vertex ver) {
		for (Surface surface : surfaces) 
			if (surface.onSurface(ver)) 
				return true;

		return false;
	}
	public static int getNumOfPlanes(int n) {
		int res = 1;
		for (int i = 3; i < n; i++) {
			res += (i*(i-1))/2;
		}
		System.out.println(res);
		return res;
	}
	@Override
	public String toString() {
		String print = "Graph\n"+"Vertexs\n" ;
		for (int i = 0; i < vertex.length; i++) {
			print+=(i+1)+") "+vertex[i].toString()+"\n";
		}
		print+="Surfaces\n";
		for (int i = 0; i < surfaces.length; i++) {
			print+=(i+1)+") "+surfaces[i].toString()+"\n";
			if (i%1000 == 0)
				System.out.println("test: " + i);
		}
		return print;
	}

	public static void main(String[] args) {
		ArrayList<Vertex> vertex = new ArrayList<Vertex>();
		int n =100;
		/*Graph g = new Graph(n);
		System.out.println(g.toString());
*/
		Surface[] test = new Surface[getNumOfPlanes(n)];
		for (int i = 0; i < test.length; i++) {
			test[i] = new Surface(new Vertex(i,i+2,i-3),new Vertex(i,i-3,i),new Vertex(i+4,i,i));
			if (i%1000 == 0)
				System.out.println("test: " + i);
		}
		/*try{
			String content =g.toString();
			 System.out.println("toString done !!");
			File file = new File("filename.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}*/




		/*Vertex v1 = new Vertex(1,1,1);
			Vertex v2= new Vertex(-1,1,0);
			Vertex v3 = new Vertex(2,0,3);
			vertex.add(v1);
			vertex.add(v2);
			vertex.add(v3);*/


		/*Vertex v1 = new Vertex(1,-2,0);
			Vertex v2= new Vertex(3,1,4);
			Vertex v3 = new Vertex(0,-1,2);
			vertex.add(v1);
			vertex.add(v2);
			vertex.add(v3);*/

		/*Graph g = new Graph(vertex);
			System.out.println(g.toString());*/
	}










}
