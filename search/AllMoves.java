package search;

public class AllMoves extends OnePointIterativeSearch {
	
	private final int[][][] data;
	
	public AllMoves(problem.Problem p, java.io.PrintStream s, int n){
		super(p,s);
		target = n;
		data = new int[n+1][][];		 
	}

	protected boolean accept(double cost_cadidate) {
		cost_current = cost_cadidate;
		data[iteration]=problem.getdump();
		return true;
	}

	public int[][][] dump(){
		data[target]= problem.getdump();
		return data;
	}
	
}
