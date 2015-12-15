package problem;

import java.util.Random;

public class TravelingSalesManInsert extends TravelingSalesMan {
	
	/*Describing the candidate
	 * 
	 * pointA moved point
	 * pointBl point before inserted point
	 * pointB = Bl mod N 
	 */

	
	public TravelingSalesManInsert(double[][] distances, Random r) {
		super(distances, r);
	}
	
    public double sugestMove() {
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

    public void doMove(){  	  	
    	cost_current = cost_cadidate;
    	
    	int a = route[pointA] ;
    	for(;pointA<pointB;pointA++){
            route[pointA%length] = route[(pointA+1)%length];
        }
    	route[pointBl] = a;
    }
}
