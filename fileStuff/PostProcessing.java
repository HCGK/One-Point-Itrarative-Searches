package fileStuff;
import java.io.*;
import java.util.Scanner;


public class PostProcessing{
	
	public static void main(String[] args) throws IOException { 
		endOfFile(490_0000,"D:\\Ascent\\TSMP500-07_12\\LAHC_1001-C.txt","D:\\Ascent\\TSMP500-07_12\\Post2\\LAHC_1001-C.txt");
	}
	
	public static void secondFile(String sourseFile, String outputFile) throws IOException{
		BufferedReader reader = null;
		Scanner sc = null;
		PrintStream stream = new PrintStream(outputFile);
		try {
			FileInputStream inputStream = new FileInputStream(sourseFile);
			sc = new Scanner(inputStream);
			stream.println(sc.nextLine());//header
			char charAt10 = 'a';
			
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        if(line.charAt(10) != charAt10 ){
		        	
		        	charAt10 = line.charAt(10);
		        	stream.println(line);
		        }
		    }
		    
		    if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		}
		catch (IOException e) {
			throw e;
		}
		finally{
			stream.close();
			if(sc != null){
				sc.close();
			}
			if (reader != null) {
	            reader.close();
			}
		}
	}
	
	public static void entryFile(int lenth,String sourseFile, String outputFile) throws IOException{
		BufferedReader reader = null;
		Scanner sc = null;
		PrintStream stream = new PrintStream(outputFile);
		try {
			FileInputStream inputStream = new FileInputStream(sourseFile);
			sc = new Scanner(inputStream);
			stream.println(sc.nextLine());//header
			
			whileLoop:
		    while (sc.hasNextLine()) {
		    	stream.println(sc.nextLine());
		    	for(int i=1;i<lenth;i++){
		    		try{
		    			sc.nextLine();
		    		}catch(java.util.NoSuchElementException e){
		    			break whileLoop;
		    		}
		    	}	
		    }
		    
		    if (sc.ioException() != null) {
		    	throw sc.ioException();
		    	
		    }
		}
		catch (IOException e) {
			throw e;
		}
		finally{
			stream.close();
			if(sc != null){
				sc.close();
			}
			if (reader != null) {
	            reader.close();
			}
		}
	}
	
	public static void endOfFile(int offset,String sourseFile, String outputFile) throws IOException{
		BufferedReader reader = null;
		Scanner sc = null;
		PrintStream stream = new PrintStream(outputFile);
		try {
			FileInputStream inputStream = new FileInputStream(sourseFile);
			sc = new Scanner(inputStream);
			stream.println(sc.nextLine());//header
			stream.println(sc.nextLine());//line 0
			
			forLoop:
			for(int i=1;i<offset;i++){
				System.out.println(i);
		    	try{
		    		sc.nextLine();
		    	}catch(java.util.NoSuchElementException e){
		    		break forLoop;
		    	}
		    }
			
		    while (sc.hasNextLine()) {
		    	stream.println(sc.nextLine());
		    		
		    }
		    
		    if (sc.ioException() != null) {
		    	throw sc.ioException();
		    }
		}
		catch (IOException e) {
			throw e;
		}
		finally{
			stream.close();
			if(sc != null){
				sc.close();
			}
			if (reader != null){
	            reader.close();
			}
		}
	}
}