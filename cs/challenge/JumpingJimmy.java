package cs.challenge;

public class JumpingJimmy {

	static final boolean DEBUG = false;
	static long START_TIME, END_TIME;

	
	int jumpingJimmy(int[] tower, int jumpHeight) {

	    int y = 0;
	    int i = 0;
	    boolean stuck = false;
	    while (i < tower.length && stuck == false){
	        
	        if(tower[i] > jumpHeight){
	            stuck = true;
	            return y;
	        }
	        else {
	            int j = i;
	            while (j < tower.length - 1 && tower[j] <= jumpHeight){
	                j++;
	            }
	            y += tower[j];
	            i = j;
	        }
	        
	    }
	    
	    return y;
	}

}
