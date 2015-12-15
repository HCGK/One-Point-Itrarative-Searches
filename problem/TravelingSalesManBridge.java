package problem;

import java.util.Random;

public class TravelingSalesManBridge extends TravelingSalesMan{
	
	/*Describing the candidate
     * 
     * int pointAl before first removed link
     * int pointBl before second removed link
     * int pointB  = Bl mod route; Al<B;
     * 
     */
    public TravelingSalesManBridge(double[][] distances, Random r) {
		super(distances, r);
	}
    
    public double sugestMove() {
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
    public void doMove(){
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
}