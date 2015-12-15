package search;
import java.io.PrintStream;
import problem.Problem;

/**
 * Abstract "One Point Iterative Search skeleton
 * </p>
 * Extending methods need only provide implemtion of accept, 
 * though they should also modify target as part of a stopping condition.
 * 
 * @author Henry Goldsack
 *
 */
public abstract class OnePointIterativeSearch {
	protected double cost_current = Double.POSITIVE_INFINITY;
	protected int iteration = 0;
	protected Problem problem;
	protected int target = 1_000;
	private final PrintStream out;
	private long startTime = 0;
	private long runTime = 0;
	 
	OnePointIterativeSearch(Problem p, PrintStream s){
		problem = p;
		out = s;
	}
	
	/**
	 * Carries out a one point iterative search. 
	 * Whilst doing so builds a CSV table of outputs
	 * @return the final cost
	 */
	public final double Search(){
		out.println("time,iter,cost");
		System.out.println(System.currentTimeMillis());
		
		startTime = System.currentTimeMillis();
		for(;iteration<target;iteration++){
			if(accept(problem.sugestMove())){
				problem.doMove();
			}
			out.println(System.currentTimeMillis()+","
					+iteration+","+cost_current);
		}
		runTime =  System.currentTimeMillis() - startTime;
		
		out.println(System.currentTimeMillis()+","
				+iteration+","+cost_current);
		System.out.println(System.currentTimeMillis()+","
				+iteration+","+cost_current+target);
		return problem.cost();
	}
	
	/**
	 * Test against the condition of a given OPIS. 
	 * Should modify profit_current when returning true.
	 * <p>
	 * may modify target to match end condition.
	 * 
	 * @param cost_cadidate or -profit_cadidate
	 * @return true if the candidate is accepted by the condition;
	 */
	abstract protected boolean accept(double cost_cadidate);
	
	public String toString(){
		return runTime+","+iteration+","+cost_current;
	}
}