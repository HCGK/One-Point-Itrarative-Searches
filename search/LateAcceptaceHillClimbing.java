package search;
import problem.Problem;
public class LateAcceptaceHillClimbing extends OnePointIterativeSearch {

    private final double[] cost;
    private int pointer = -1;//-1 so 0 on first iteration
	private final int delay;
    
    public LateAcceptaceHillClimbing(Problem p, java.io.PrintStream s, int Lfa, int delay){
    	super(p, s);
        cost = new double[Lfa];
        for(int i =0; i<cost.length;i++){
            cost[i] = Double.POSITIVE_INFINITY;
        }
        this.delay = delay;
    }
    protected boolean accept(double cost_cadidate) {
        pointer = (pointer+1)% cost.length;
        if(cost_cadidate<=cost[pointer] || cost_cadidate<=cost_current){
        	
			target = iteration+delay;

            cost[pointer] = cost_cadidate;
            cost_current = cost_cadidate;
            return true;
        }
        else{
            cost[pointer] = cost_current;
            return false;
        }
    }
}