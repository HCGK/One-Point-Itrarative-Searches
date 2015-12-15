package search;

public class GreadyHillCliming extends OnePointIterativeSearch {
	
	public GreadyHillCliming(problem.Problem p, java.io.PrintStream s) {
		super(p,s); 
	}

	protected boolean accept(double cost_cadidate) {
		if (cost_cadidate <= cost_current){
			if(cost_cadidate != cost_current){
				target = iteration+(iteration/50)+1000;
			}
			cost_current = cost_cadidate;
			return true;
		}
		else{
			return false;
		}
	}
}
