package cs.challenge;

public class JumpingJimmy {

	static final boolean DEBUG = false;
	static long START_TIME, END_TIME;

	
	int jumpingJimmy(int[] tower, int jumpHeight) {

	    int y = 0;
	    int level = 0;
	    boolean stuck = false;
	    while (level + 1< tower.length && stuck == false){
	    	String s = "height: " + y + ", level " + level;
	        System.out.println(s);
	        if(tower[level+1] > jumpHeight){
	            stuck = true;
	            return y;
	        }
	        else {
	            int j = level + 1;
	            while (j < tower.length && tower[j] - tower[level] <= jumpHeight){
	                j++;
	            }
	            y += tower[j];
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
