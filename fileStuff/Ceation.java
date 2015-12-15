package fileStuff;

import java.awt.Point;
import java.io.FileNotFoundException;

public class Ceation {
	public static void main(String[] Args) throws FileNotFoundException{
		TSMP(500, "D:\\Ascent\\TSMP500.txt");
	}
	
	private static final java.util.Random R = new java.util.Random();
	
	/**
	 * Produces a file with the number of point followed by
	 * n none equal points
	 * @param numberOfPoints
	 * @throws FileNotFoundException 
	 */
	public static void TSMP(int numberOfPoints, String fileName) throws FileNotFoundException{
		java.io.PrintStream out = new java.io.PrintStream(fileName);
		out.println(numberOfPoints);
		java.util.HashSet<Point> set = new java.util.HashSet<Point>();
		
		for (int i = 0; i<numberOfPoints; i++) {
			//65536=2^16 
			//chosen as Berlin ran from 5 to 29625 = 2^14.8 in y (tho all x%5=0)
			//try 2^12 = 4096
			Point point = new Point(R.nextInt(4096), R.nextInt(4096));
			if(set.add(point)){
				out.println(point.x+"\t"+point.y);
			}
			else{
				i--; //skip (i.e. repeat for this i)
			}
		}
		out.close();
	}
}
