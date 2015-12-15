package problem;

import java.util.Random;

public class GroupBalancingProblem implements Problem {
	private final Random R;
	
	private final double targetGroupSize;
	private final int[] groupSizes; //[Number Of Groups] content changes
	private final int[] elements; // content dose not change
	private final int[] groupAssignments;//[elements.lenght], content changes
	
	private double cost_current;
	private double cost_cadidate;
	//Describing the candidate
	int groupTo;
	int groupFrom;
	final int[] forwardElmts = new int[5];
	int backwardsElmt;
	int groupSizeTo;
	int groupSizeFrom;
	
	
	public GroupBalancingProblem(int numberOfGroups, int[] elementz, Random r){
		R = r;
		groupSizes = new int[numberOfGroups];
		elements = elementz;
		groupAssignments = new int[this.elements.length];
		double elementSum = 0;
		/*for(int s :groupSizes){
		 *	s = 0;
		 *}
		 *   *should be unnecessary*
		 */
		for(int i = 0;i<elements.length;i++){
			groupAssignments[i] = R.nextInt(groupSizes.length);
			groupSizes[groupAssignments[i]] += elements[i];
			elementSum += elements[i];
		}
		targetGroupSize = elementSum/numberOfGroups;
		
		cost_current = 0;
		for(int size: groupSizes){
			cost_current += Math.sqrt(Math.abs(size - targetGroupSize));
		}
	}
	public double cost(){
		return cost_current;
	}

	public double sugestMove() {
		forwardElmts[0] = R.nextInt(elements.length);
		groupFrom = groupAssignments[forwardElmts[0]];
		int sizeForward = elements[forwardElmts[0]];
		int sizeBackwards=0;
		
		loop:
		for(int i=1;i<forwardElmts.length;i++){
			int e = R.nextInt(elements.length);
			if(groupAssignments[e]==groupFrom){
				if(i == forwardElmts.length -1){
					//Always end forwardElmts with -1
					i--;
				}
				else{
					//cheak for repeat
					for(int j=0;j<i;j++){
						if(forwardElmts[j]==e){
							i--;
							continue loop;
						}
					}
					forwardElmts[i]=e;
					sizeForward += elements[e];
				}
			}
			else{
				forwardElmts[i] = -1;
				backwardsElmt = e;
				groupTo = groupAssignments[e];
				sizeBackwards = elements[e];
				break loop;
			}
		}
		groupSizeFrom = groupSizes[groupFrom] - sizeForward + sizeBackwards;
		groupSizeTo   = groupSizes[groupTo]   + sizeForward - sizeBackwards;
		cost_cadidate = cost_current
				          - Math.sqrt(Math.abs(groupSizes[groupTo] - targetGroupSize))
		                  - Math.sqrt(Math.abs(groupSizes[groupFrom] - targetGroupSize))
		                  + Math.sqrt(Math.abs(groupSizeTo - targetGroupSize))
		                  + Math.sqrt(Math.abs(groupSizeFrom - targetGroupSize));
		return cost_cadidate;
	}
	public void doMove() {
		groupSizes[groupTo] = groupSizeTo;
		groupSizes[groupFrom] = groupSizeFrom;
		cost_current = cost_cadidate;
		groupAssignments[backwardsElmt] = groupFrom;
		
		int i =0;
		while(forwardElmts[i]!=-1){
			groupAssignments[forwardElmts[i]] = groupTo;
			i++;
		}
	}
	
	public int[][] getdump(){
		return new int[][] {groupSizes.clone(),groupAssignments.clone()};
	}
}
