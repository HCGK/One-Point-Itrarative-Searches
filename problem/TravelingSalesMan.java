package problem;

import java.util.Random;

public class TravelingSalesMan implements Problem{
    protected final Random R;
    public final  double[][] distances;
    protected final  int[] route;
    protected final int length;
    protected double cost_current  = 0.0;
    protected double cost_cadidate = 0.0;
       
    //Describing the candidate
    private int moveType;
    
    protected int pointAl;
    protected int pointA;
    protected int pointAt;
    
    protected int pointBl;
    protected int pointB;
    protected int pointBt;
    
    public TravelingSalesMan(double[][] distances, Random r){
        R = r;
        this.distances = distances;
        length = distances.length;
        route = new int[length];
        
        //Create initial solution
        for(int i=0;i<route.length;i++){
            route[i]=i;
        }
        route[length-1] = R.nextInt(length);
        route[route[length-1]]=length-1;
        
        for (int i = length - 2; i > 0; i--){
        	//shuffle
            int index = R.nextInt(i + 1);
            int a = route[index];
            route[index] = route[i];
            route[i] = a;
            //construct cost
            cost_current += distances[route[i]][route[i+1]];
        }
        cost_current += distances[route[0]][route[1]];
        cost_current += distances[route[length-1]][route[0]];      
    }

    public final double cost(){
    	double cost = distances[route[length-1]][route[0]];
        for(int i=1;i<route.length;i++){
        	cost += distances[route[i-1]][route[i]];
        }
        return cost;
    }
    
    public double sugestMove(){
		moveType = R.nextInt(3);
		
		if(moveType == 1){
			return sugestMoveSwap();
		}
		else if(moveType == 2){
			return sugestMoveBridge();
		}
		else{
			return sugestMoveInsert();
		}
    }
    public void doMove(){
    	if(moveType == 1){
			doMoveSwap();
		}
		else if(moveType == 2){
			doMoveBridge();
		}
		else{
			doMoveInsert();
		}
    }
    

    
    
    /* Swap Move
     * Swap Point A and Point B
     */  
    private double sugestMoveSwap(){
        pointAl = R.nextInt(length);
        pointA  = (pointAl+1)%length;
        pointAt = (pointAl+2)%length;
        //point A and B non neighbour (neighbour done by both other moves)
        pointBl = (R.nextInt(length - 3)+pointAt)%length;
        pointB  = (pointBl+1)%length;
        pointBt = (pointBl+2)%length;
        
        cost_cadidate = cost_current 
        	- distances[route[pointAl]][route[pointA]]
            - distances[route[pointAt]][route[pointA]]
            - distances[route[pointBl]][route[pointB]]
            - distances[route[pointBt]][route[pointB]]
            		
            + distances[route[pointBl]][route[pointA]]
            + distances[route[pointBt]][route[pointA]]
            + distances[route[pointAl]][route[pointB]]
            + distances[route[pointAt]][route[pointB]];

        return  cost_cadidate;
    }
    private void doMoveSwap(){
        cost_current = cost_cadidate;
        int a = route[pointA];
        route[pointA] = route[pointB];
        route[pointB] = a;
    }
    
    /* Bridge move
     * Remove the links Al At and Bl Bt
     * and reamake Al Bl and At Bt
     * Swaping the direction of the part between
     * int pointB  = Bl mod route; Al<B;
     * 
     */
    private double sugestMoveBridge() {
    	pointAl = R.nextInt(length);
        pointAt = (pointAl+1)%length;
        //Bl !={ Al , At Al - 1} <=> Bt != {Al,At At+1}  
        pointB = (R.nextInt(route.length-3)+pointAt+1);
        pointBl = pointB%length;
        pointBt = (pointBl+1)%length;
        
        cost_cadidate = cost_current
        		- distances[route[pointAl]][route[pointAt]]
                - distances[route[pointBl]][route[pointBt]]
                + distances[route[pointAl]][route[pointBl]]
                + distances[route[pointBt]][route[pointAt]];
        
        return cost_cadidate;
    }
    
    private void doMoveBridge(){
    	for(;pointAt<pointB;pointB--){
            int a = route[pointAt%length];
            route[pointAt%length] = route[pointB%length];
            route[pointB%length] = a;
            pointAt++;
        }
        cost_current = cost_cadidate;
        
        for(;pointAt<pointB;pointB--){
            int a = route[pointAt%length];
            route[pointAt%length] = route[pointB%length];
            route[pointB%length] = a;
            pointAt++;
        }
    }
    
    /*Inset
     * Point A moved and placed in the arc Bl Bt
     */
    private double sugestMoveInsert() {
    	pointAl = R.nextInt(length);
    	pointA  = (pointAl+1)%length;
    	pointAt = (pointA+1)%length;
    	
    	pointB = R.nextInt(route.length-2)+pointA+1;
        pointBl = pointB%length;
        pointBt = (pointBl+1)%length;
        
        cost_cadidate = cost_current
        		- distances[route[pointAl]][route[pointA]]
        		- distances[route[pointA]][route[pointAt]]
        		- distances[route[pointBl]][route[pointBt]]
        		+ distances[route[pointAl]][route[pointAt]]
        		+ distances[route[pointBl]][route[pointA]]
        		+ distances[route[pointA]][route[pointBt]];
        
        return cost_cadidate;
    }

    private void doMoveInsert(){  	  	
    	cost_current = cost_cadidate;
    	
    	int a = route[pointA] ;
    	for(;pointA<pointB;pointA++){
            route[pointA%length] = route[(pointA+1)%length];
        }
    	route[pointBl] = a;
    }
    
    
    
    
    
    public final int[][] getdump(){
        return new int[][] {route.clone()};
    }
}