import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

import fileStuff.PostProcessing;
import fileStuff.ProbleFromFile;

import problem.*;
import search.*;


public class Experment0 {

	public static void main(String[] args) throws IOException {
		String[] repeats = {"A","B","C","D","E"};
		int[] lenghts = {1,100,500,1_000,5_000,10_000,20_000,50_000,100_000};
		String[] names= {"1","100","500","1k","5k","10K","20K","50K","100K"};
		String prefix = "D:\\Ascent\\berlin52_11-23\\LAHC_";
		String post = "D:\\Ascent\\berlin52_11-23\\post\\LAHC_";
		double[][] d = ProbleFromFile.TravelingSalesMan("D:\\Ascent\\berlin52.txt");
		
		for(String r: repeats){
			for(int i= 0;i<lenghts.length;i++){
				Problem p = new problem.TravelingSalesMan(d, new Random());
				String output = prefix+names[i]+"-"+r+".txt";
				String postFile = post+names[i]+"-"+r+".txt";
				PrintStream file = new PrintStream(output);
				OnePointIterativeSearch seach 
							= new LateAcceptaceHillClimbing(p,file,lenghts[i]);
				seach.Search();
				PostProcessing.entryFile(40_000, output, postFile);
				System.out.println(names[i]+"-"+r);
			}
		}
	}
}
