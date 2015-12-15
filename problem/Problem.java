package problem;
/**
 * Interface to provide a general problem
 * <p>
 * Stores a current solution, the description of a move on that 
 * and the profit/cost.
 * Provides methods for iterating upon the iteration stored
 * 
 * @author Henry Goldsack
 *
 */
public interface Problem {
	
	/**
	 * randomise and describes (in fields) a move on the current solution
	 * (will have to clear previous solution)
	 * @return the cost OR -profit of the candidate solution described
	 */
	public double sugestMove(); //give provisional cost function and save a move
	
	/**
	 * carries out the move described by the last call of sugestMove	 * 
	 */
	public void doMove(); //do saved move
	
	/**
	 * cost of current solution
	 * @return current cost OR -profit of current solution stored
	 */
	public double cost();	//return cost function calculated from definition
	
	/**
	 * to return a description of the current solution. 
	 * (or {{}})
	 * @return a description of the current solution
	 */
	public int[][] getdump();
}