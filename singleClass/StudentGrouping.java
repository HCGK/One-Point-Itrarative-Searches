package singleClass;

import java.io.PrintStream;
import java.util.Random;

public class StudentGrouping {
	
    private final int[] cost;
    private int pointer = -1;
	
	//s
	private final Random R;
	private final int[][] disliking;
	private final int[][] groups;
	
	//Search
	protected int cost_current = Integer.MAX_VALUE;
	protected int iter = 0;
	protected int target = 1000;
	private final PrintStream out;
	
	
	public StudentGrouping(int nGroups,int szGroup,int[][] disliking,
			int Lfa, PrintStream out, Random r){
		
		cost = new int[Lfa];
        for(int i =0; i<cost.length;i++){
            cost[i] = Integer.MAX_VALUE;
        }		
		R = r;
		this.out = out;
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
	
	
	public int Search(){
		out.println("time,iter,cost");
		
		for(;iter<target;iter++){
	        pointer = (pointer+1)% cost.length;
	        //suggest move
	        int groupA = R.nextInt(groups.length);
			int positA = R.nextInt(groups[groupA].length);
			int groupB = (R.nextInt(groups.length-1)+groupA+1)%groups.length;
			int positB = R.nextInt(groups[groupB].length);
			
			int cost_cadidate = cost_current;
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
			cost_cadidate-=2*disliking[groups[groupB][positB]][groups[groupA][positA]];	
			//Accept move
	        if(cost_cadidate<=cost[pointer] || cost_cadidate<=cost_current){
	        	if(cost_cadidate < cost_current){
					target = iter+(iter/50)+1000;
				}
	            cost[pointer] = cost_cadidate;
	            cost_current = cost_cadidate;
	            
	            int z = groups[groupA][positA];
	    		groups[groupA][positA] = groups[groupB][positB];
	    		groups[groupB][positB] = z;
	            
	        }
	        else{
	        	cost[pointer] = cost_current;
	        }
			out.println(System.currentTimeMillis()+","+iter+","+cost_current);
		}
		out.println(System.currentTimeMillis()+","
				+iter+","+cost_current);
		return cost_current;
	}
}
