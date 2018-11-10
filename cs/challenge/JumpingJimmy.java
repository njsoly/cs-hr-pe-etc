package cs.challenge;
import static util.Helper.sop;

/**
 * Jumping Jimmy.  
 * @author Nate J Solyntjes
 *
 */
public class JumpingJimmy {

	static final boolean DEBUG = false;
	static long START_TIME, END_TIME;

	
	int jumpingJimmy(int[] tower, int jumpHeight) {

	    int y = 0;
	    int level = -1;
	    
	    Jimmy j = new Jimmy(tower, jumpHeight);
	    
	    while(j.isStuck() == false && j.isAtTop() == false){
	    	y = j.jump();
	    }
	    
	    if(DEBUG) sop("Answer: \t" + y);


	    return y;
	}
	
	class Jimmy {
		int[] tower = null;
		int jumpHeight;
		int towerLevel = -1;
		int height = 0;
		
		Jimmy(){
			
		}
		Jimmy(int[] tower, int jumpHeight){
			this();
			this.tower = tower;
			this.jumpHeight = jumpHeight;
			
		}
		boolean isStuck(){
			if(towerLevel == tower.length - 1){ return false; }
			if(tower[towerLevel + 1] <= jumpHeight) return false;
			else return true;
		}
		boolean isAtTop(){
			return (this.towerLevel == this.tower.length - 1);
		}
		
		int jump(){
			if(isStuck() || isAtTop()) return height;
			
			int next = -1;
			int dh = 0;
			
			for(int i = towerLevel + 1; i < tower.length; i++){
				if(dh + tower[i] <= jumpHeight){
					if(DEBUG)
						sop("can jump from [" + towerLevel + "] to [" + i + "], diff: " + dh);
					dh += tower[i];
					next = i;
				}
				else {
					if(DEBUG) 
						sop("can't go to [" + (i+1) + "]; dh < jh (" + dh + " < " + (dh + tower[i]) + ").");
					break;
				}

			}
			this.towerLevel = next;
			this.height += dh;
			if(DEBUG) 
				sop("Now at tower[" + towerLevel + "], at height: " + this.height);
			
			return height;
		}
		
	}
	
	public static void main(String[] args){
		JumpingJimmy jj = new JumpingJimmy();
		int[] tower = {3, 1, 2};
		int jumpHeight = 3;
		int ans = jj.jumpingJimmy(tower, jumpHeight);
		sop("answer: " + ans);
	}

}
