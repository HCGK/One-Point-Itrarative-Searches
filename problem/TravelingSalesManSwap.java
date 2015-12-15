package problem;

import java.util.Random;

public class TravelingSalesManSwap extends TravelingSalesMan{
       
    //Describing the candidate
    //Swapping pointA with pointB 
    //with Al being the point be for A and At the point after;
    
        
    public TravelingSalesManSwap(double[][] distances, Random r) {
		super(distances, r);
	}

    public double sugestMove(){
        pointAl = R.nextInt(length);
        pointA  = (pointAl+1)%length;
        pointAt = (pointAl+2)%length;
        //point A and B non 
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
    public void doMove(){
        cost_current = cost_cadidate;
        int a = route[pointA];
        route[pointA] = route[pointB];
        route[pointB] = a;
    }
}