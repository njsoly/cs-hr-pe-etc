package cs.challenge;

public class JumpingJimmy {

	static final boolean DEBUG = false;
	static long START_TIME, END_TIME;

	
	int jumpingJimmy(int[] tower, int jumpHeight) {

	    int y = 0;
	    int level = 0;
	    boolean stuck = false;
	    while (level < tower.length && stuck == false){
	    	String s = "height: " + y + ", level " + level;
	        System.out.println(s);
	        if(level+1 < tower.length && y + tower[level+1] > jumpHeight){
	            stuck = true;
	            return y;
	        }
	        else {
	        	int inc = 0; // current increment.  accumulator for a multi-floor jump
	        	int j = level + 1;
	            System.out.println("before while: level " + level + "; \tinc: " + inc + "; \tj: " + j);
	           
	            while (j < tower.length && tower[j] + inc + y <= jumpHeight){
	            	inc += tower[j];
	                j++;
	            }
	            System.out.println("adding " + inc + " to height; now level " + j);
	            y += inc;
	            level = j;
	        }
	        
	    }
	    
	    return y;
	}
	
	public static void main(String[] args){
		JumpingJimmy jj = new JumpingJimmy();
		int[] tower = {3, 1, 2};
		int jumpHeight = 3;
		int ans = jj.jumpingJimmy(tower, jumpHeight);
		
		System.out.println("Answer: \t" + ans);
	}

}
