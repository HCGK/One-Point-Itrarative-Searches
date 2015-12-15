package fileStuff;
import java.io.*;
import java.util.Random;

import problem.GroupBalancingProblem;
import problem.StudentGrouping;

public class ProbleFromFile {
	
	public static GroupBalancingProblem GroupBalancingProblem(String fileName) 
		throws IOException{
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));

			int[] elements = new int[Integer.parseInt(reader.readLine())];
			int nOfGroups = Integer.parseInt(reader.readLine());
			
			for (int i = 0; i < elements.length; i++) {
				elements[i] = Integer.parseInt(reader.readLine());
			}
			return new GroupBalancingProblem(nOfGroups, elements, new Random());
		}
		catch (IOException e) {
			throw e;
		}
		finally{
			if (reader != null) {
	            reader.close();
	        }
		}
	}
	
	
	public static double[][] TravelingSalesMan(String fileName) 
			throws IOException{
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
			int[][] point = new int[Integer.parseInt(reader.readLine())][2];
			
			for(int i = 0; i < point.length; i++){
				String line = reader.readLine();
				String[] words = line.split("\t",2);
				point[i][0] = Integer.parseInt(words[0]);
				point[i][1] = Integer.parseInt(words[1]);
			}			
			double[][] distances = new double[point.length][point.length];
			for(int i= 0;i<point.length;i++){
				for(int j= 0;j<point.length;j++){
					distances[i][j]=Math.sqrt((
							point[i][0]-point[j][0])*(point[i][0]-point[j][0])+
						  +(point[i][1]-point[j][1])*(point[i][1]-point[j][1]));
				}
			}
		return distances;
		}
		catch (IOException e) {
			throw e;
		}
		finally{
			if (reader != null) {
	            reader.close();
	        }
		}
	}
	
	
	public static StudentGrouping StudentGrouping(String fileName) 
			throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
			String line = reader.readLine();
			String[] words = line.split("\t",2);
			int numberStudents = Integer.parseInt(words[0]);
			int nGroups = Integer.parseInt(words[1]);
			int sZGroups = numberStudents/nGroups;
			int[][] disliking = new int[numberStudents][numberStudents];
			for(int i=0;i<numberStudents;i++){
				line = reader.readLine();
				words = line.split("\t");
				for(int j=0;j<numberStudents;j++){
					disliking[i][j]=Integer.parseInt(words[j]);
				}
			}
			return new StudentGrouping(nGroups,sZGroups,disliking,new Random());
		}
		catch (IOException e) {
			throw e;
		}
		finally{
			if (reader != null) {
	            reader.close();
	        }
		}
	}
	
	
	public static singleClass.StudentGrouping SingleClassSG
				(String fileName, int Lfa, PrintStream s) throws IOException{
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
			String line = reader.readLine();
			String[] words = line.split("\t",2);
			int numberStudents = Integer.parseInt(words[0]);
			int nGroups = Integer.parseInt(words[1]);
			int sZGroups = numberStudents/nGroups;
			int[][] disliking = new int[numberStudents][numberStudents];
			for(int i=0;i<numberStudents;i++){
				line = reader.readLine();
				words = line.split("\t");
				for(int j=0;j<numberStudents;j++){
					disliking[i][j]=Integer.parseInt(words[j]);
				}
			}
			return new singleClass.StudentGrouping(nGroups,sZGroups,disliking, 
					Lfa, s, new Random());
		}
		catch (IOException e) {
			throw e;
		}
		finally{
			if (reader != null) {
	            reader.close();
	        }
		}
	}
}
