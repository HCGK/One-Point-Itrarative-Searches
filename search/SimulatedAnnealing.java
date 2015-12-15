package search;

public abstract class SimulatedAnnealing extends OnePointIterativeSearch {

    private double temp;
    private double collingfactor;
    
    public SimulatedAnnealing(problem.Problem p, java.io.PrintStream s, 
    		double collingfactor, double intlTemp){
    	super(p,s);
    	this.collingfactor = collingfactor;
    	temp = intlTemp;
    }
    
    protected boolean accept(double profit_cadidate) {
        cool();
        if (profit_cadidate <= cost_current || Math.random() 
        			< Math.exp((profit_cadidate - cost_current) / temp)){
        	if(profit_cadidate != cost_current){
				target = iteration+(iteration/50)+1000;
			}
            cost_current = profit_cadidate;
            return true;
        }
        else{
            return false;
        }
    }
    
    private void cool(){
        temp *= collingfactor;
    }
}