import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

import fileStuff.PostProcessing;
import fileStuff.ProbleFromFile;

import problem.*;
import search.*;


public class Experment1 {

	public static void main(String[] args) throws IOException {
		String[] repeats = {"A","B","C","D","E"};
		int [] starts    = { 1, 20, 50, 70, 90 };
		String prefix = "D:\\Ascent\\TSMP500-10_12\\LAHC_";
		double[][] d = ProbleFromFile.TravelingSalesMan("D:\\Ascent\\TSMP500.txt");
		PrintStream doc = new PrintStream("D:\\Ascent\\doc-10_12.csv");
		for(int r=0;r<repeats.length;r++){
			for(int i= 1;i<=50_000;i+=100){
				Problem p = new problem.TravelingSalesMan(d, new Random());
				String output = prefix+i+"-"+repeats[r]+".txt";
				PrintStream file = new PrintStream(output);
				OnePointIterativeSearch search 
							= new LateAcceptaceHillClimbing(p,file,i,12_500_000);
				search.Search();
				System.out.println(i+"-"+repeats[r]);
				doc.println(i+","+repeats[r]+",_,"+search.toString());				
			}
		}
	}
}
