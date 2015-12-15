package problem;

import java.util.Random;

public class StudentGrouping implements Problem {
	private final Random R;
	private final int[][] disliking;
	private final int[][] groups;
	
	private int cost_current;
	private int cost_cadidate;
	
    //Describing the candidate
	private int groupA;
	private int positA;
	private int groupB;
	private int positB;

	
	
	public StudentGrouping(int nGroups,int szGroup,int[][] disliking, Random r){
		R = r;
		groups = new int[nGroups][szGroup];
		this.disliking = disliking;
		
		for(int i=0;i<nGroups;i++){
			for(int j=0;j<szGroup;j++){
				groups[i][j] = i*szGroup + j;
			}
		}
		//shuffle
		for (int i = nGroups-1; i >= 0; i--){
        	for (int j = szGroup-1; j >= 0; j--) {
				int index = R.nextInt(i*szGroup+j + 1);
				int a = index/szGroup;
				int b = index%szGroup;				
				int z = groups[a][b];
				groups[a][b] = groups[i][j];
				groups[i][j] = z;
			}
        }
		//cost
		cost_current = 0;
		for(int i=0;i<nGroups;i++){
			for(int j=0;j<szGroup;j++){
				for(int k=0;k<szGroup;k++){
					cost_current += disliking[groups[i][j]][groups[i][k]];
				}
			}	
		}
		cost_current/=2;
	}

	public double sugestMove() {
		groupA = R.nextInt(groups.length);
		positA = R.nextInt(groups[groupA].length);
		groupB = (R.nextInt(groups.length-1)+groupA+1)%groups.length;
		positB = R.nextInt(groups[groupB].length);
		
		cost_cadidate = cost_current;
		for(int k=0;k<groups[0].length;k++){
			//add A
			cost_cadidate+=disliking[groups[groupB][positB]][groups[groupA][k]];
			//add B
			cost_cadidate+=disliking[groups[groupA][positA]][groups[groupB][k]];
			//remove A
			cost_cadidate-=disliking[groups[groupA][positA]][groups[groupA][k]];
			//remove B
			cost_cadidate-=disliking[groups[groupB][positB]][groups[groupB][k]];
			
		}
		cost_cadidate -= 2*disliking[groups[groupB][positB]][groups[groupA][positA]];
		return cost_cadidate;
	}

	public void doMove() {
		cost_current = cost_cadidate;
		
		int z = groups[groupA][positA];
		groups[groupA][positA] = groups[groupB][positB];
		groups[groupB][positB] = z;
	}

	public double cost() {
		//return includes implicit double cast
		return cost_current;
	}

	public int[][] getdump() {
		return groups.clone();
	}
}