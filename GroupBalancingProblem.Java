public class GroupBalancingProblem{
	final int NumberOfGroups; //
	final int TargetGroupSize; //
	int[] groupSizes//[Number Of Groups]
	final int[] elements;
	int[] CadidatSolotion; //same size as elements
	
	//used to store a move
	
	public int costFunction(){
		int s = 0;
		for(int size: groupSize){
			s += abs(size - TargetGroupSize)
		}
		return s
	}
	
	public int 
}
