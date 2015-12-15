import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import fileStuff.ProbleFromFile;

import problem.*;
import search.*;

public class Run2 {
	public static void main(String[] args) throws IOException{
		TravelingSalesMan p;
		p = ProbleFromFile.TravelingSalesManBridge("D:\\Ascent\\berlin52.txt");
		File file = new File("D:\\Ascent\\TPSB-Berlin\\0.txt");
		PrintStream steam = new PrintStream(file);
		OnePointIterativeSearch seach = new GreadyHillCliming(p,steam);
		seach.Search();
		System.out.println("1/14");
		 
		p = ProbleFromFile.TravelingSalesManBridge("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSB-Berlin\\GHC.txt");
		steam = new PrintStream(file);
		seach = new GreadyHillCliming(p,steam);
		seach.Search();
		System.out.println("2/14");
		/*
		p = FromFile.TravelingSalesManSwap("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSS-Berlin_LAHC100.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 100);
		seach.Search();
		System.out.println("3/14");
		*/
		p = ProbleFromFile.TravelingSalesManBridge("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSB-Berlin\\LAHC100.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 100);
		seach.Search();
		System.out.println("4/14");
		/*
		p = FromFile.TravelingSalesManSwap("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSS-Berlin_LAHC500.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 500);
		seach.Search();
		System.out.println("5/14");
		*/
		p = ProbleFromFile.TravelingSalesManBridge("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSB-Berlin_LAHC500.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 500);
		seach.Search();
		System.out.println("6/14");
		/*
		p = FromFile.TravelingSalesManSwap("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSS-Berlin_LAHC1k.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 1_000);
		seach.Search();
		System.out.println("7/10");
		*/
		p = ProbleFromFile.TravelingSalesManBridge("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSB-Berlin\\LAHC1k.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 1_000);
		seach.Search();
		System.out.println("8/14");
		/*
		p = FromFile.TravelingSalesManSwap("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSS-Berlin_LAHC5k.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 5_000);
		seach.Search();
		System.out.println("9/14");
		*/
		p = ProbleFromFile.TravelingSalesManBridge("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSB-Berlin\\LAHC5k.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 5_000);
		seach.Search();
		System.out.println("10/14");
		/*
		p = FromFile.TravelingSalesManSwap("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSS-Berlin_LAHC10k.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 10_000);
		seach.Search();
		System.out.println("11/14");
		*/
		p = ProbleFromFile.TravelingSalesManBridge("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSB-Berlin\\LAHC10k.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 10_000);
		seach.Search();
		System.out.println("12/14");
		/*
		p = FromFile.TravelingSalesManSwap("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSS-Berlin_LAHC30k.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 30_000);
		seach.Search();
		System.out.println("13/14");
		*/
		p = ProbleFromFile.TravelingSalesManBridge("D:\\Ascent\\berlin52.txt");
		file = new File("D:\\Ascent\\TPSB-Berlin\\LAHC30k.txt");
		steam = new PrintStream(file);
		seach = new LateAcceptaceHillClimbing(p,steam, 30_000);
		seach.Search();
		System.out.println("14/14");
	}
}