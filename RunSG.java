import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import fileStuff.ProbleFromFile;

import problem.Problem;
import search.GreadyHillCliming;
import search.LateAcceptaceHillClimbing;
import search.OnePointIterativeSearch;

public class RunSG {
	public static void main(String[] args) throws IOException{
		Problem p = ProbleFromFile.StudentGrouping("D:\\Ascent\\SG\\p2\\p2.txt");
		File file = new File("D:\\Ascent\\SG\\p2\\GHC_1.txt");
		PrintStream steam = new PrintStream(file);
		OnePointIterativeSearch seach = new GreadyHillCliming(p,steam);
		seach.Search();
		System.out.println("1");
		
		file = new File("D:\\Ascent\\SG\\p2\\SC1_1.txt");
		steam = new PrintStream(file);
		singleClass.StudentGrouping sc = ProbleFromFile.SingleClassSG("D:\\Ascent\\SG\\p2\\p2.txt", 1,steam);
		sc.Search();
		System.out.println("2");
		
		
		p = ProbleFromFile.StudentGrouping("D:\\Ascent\\SG\\p2\\p2.txt");
		file = new File("D:\\Ascent\\SG\\p2\\LAHC100_1.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 100);
		seach.Search();
		System.out.println("3");
		
		file = new File("D:\\Ascent\\SG\\p2\\SC100_1.txt");
		steam = new PrintStream(file);
		sc = ProbleFromFile.SingleClassSG("D:\\Ascent\\SG\\p2\\p2.txt", 100,steam);
		sc.Search();
		System.out.println("4");
		
		p = ProbleFromFile.StudentGrouping("D:\\Ascent\\SG\\p2\\p2.txt");
		file = new File("D:\\Ascent\\SG\\p2\\LAHC500_1.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 500);
		seach.Search();
		System.out.println("5");
		
		file = new File("D:\\Ascent\\SG\\p2\\SC500_1.txt");
		steam = new PrintStream(file);
		sc = ProbleFromFile.SingleClassSG("D:\\Ascent\\SG\\p2\\p2.txt", 500,steam);
		sc.Search();
		System.out.println("6");
		
		p = ProbleFromFile.StudentGrouping("D:\\Ascent\\SG\\p2\\p2.txt");
		file = new File("D:\\Ascent\\SG\\p2\\LAHC1k_1.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 1_000);
		seach.Search();
		System.out.println("7");
		
		file = new File("D:\\Ascent\\SG\\p2\\SC1k_1.txt");
		steam = new PrintStream(file);
		sc = ProbleFromFile.SingleClassSG("D:\\Ascent\\SG\\p2\\p2.txt", 1_000,steam);
		sc.Search();
		System.out.println("8");
		
		p = ProbleFromFile.StudentGrouping("D:\\Ascent\\SG\\p2\\p2.txt");
		file = new File("D:\\Ascent\\SG\\p2\\LAHC2k_1.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 2_000);
		seach.Search();
		System.out.println("9");
		
		file = new File("D:\\Ascent\\SG\\p2\\SC2K_1.txt");
		steam = new PrintStream(file);
		sc = ProbleFromFile.SingleClassSG("D:\\Ascent\\SG\\p2\\p2.txt", 2_000,steam);
		sc.Search();
		System.out.println("10");
		
		p = ProbleFromFile.StudentGrouping("D:\\Ascent\\SG\\p2\\p2.txt");
		file = new File("D:\\Ascent\\SG\\p2\\LAHC5k_1.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 5_000);
		seach.Search();
		System.out.println("11");
		
		file = new File("D:\\Ascent\\SG\\p2\\SC5k_1.txt");
		steam = new PrintStream(file);
		sc = ProbleFromFile.SingleClassSG("D:\\Ascent\\SG\\p2\\p2.txt", 5_000,steam);
		sc.Search();
		System.out.println("12");
		
		p = ProbleFromFile.StudentGrouping("D:\\Ascent\\SG\\p2\\p2.txt");
		file = new File("D:\\Ascent\\SG\\p2\\LAHC10k_1.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 10_000);
		seach.Search();
		System.out.println("13");
		
		file = new File("D:\\Ascent\\SG\\p2\\SC10k_1.txt");
		steam = new PrintStream(file);
		sc = ProbleFromFile.SingleClassSG("D:\\Ascent\\SG\\p2\\p2.txt", 10_000,steam);
		sc.Search();
		System.out.println("14");
		
		p = ProbleFromFile.StudentGrouping("D:\\Ascent\\SG\\p2\\p2.txt");
		file = new File("D:\\Ascent\\SG\\p2\\LAHC15k_1.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 15_000);
		seach.Search();
		System.out.println("15");
		
		file = new File("D:\\Ascent\\SG\\p2\\SC15k_1.txt");
		steam = new PrintStream(file);
		sc = ProbleFromFile.SingleClassSG("D:\\Ascent\\SG\\p2\\p2.txt", 15_000,steam);
		sc.Search();
		System.out.println("16");
		
		p = ProbleFromFile.StudentGrouping("D:\\Ascent\\SG\\p2\\p2.txt");
		file = new File("D:\\Ascent\\SG\\p2\\LAHC30k_1.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 30_000);
		seach.Search();
		System.out.println("17");
		
		file = new File("D:\\Ascent\\SG\\p2\\SC30k_1.txt");
		steam = new PrintStream(file);
		sc = ProbleFromFile.SingleClassSG("D:\\Ascent\\SG\\p2\\p2.txt", 30_000,steam);
		sc.Search();
		System.out.println("18");
	}
}
