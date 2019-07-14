/** 
 *  https://app.codesignal.com/arcade/code-arcade/well-of-integration/QmK8kHTyKqh8xDoZk
 *  */
public class Solution {
	
	int threeSplit(int[] a) {
		int solns = 0;
		int x = 0, y = 0, z = 0;
		int yToX = 0, yToZ = 0; // the sums of what to transfer
		int i = 1, j = 2; // the beginning indices of y and z
		
		// initial setup
		x = a[0];
		y = a[1];
		for(int k = 2; k < a.length; k++){
			z += a[k];
		}
		// if(x == z && x == y) solns++;
		
		int li = i, lj = j;     
		
		while(j < a.length && i < j){
			if(j < a.length - 1){ // increment j and contract z
				j++;
				z -= a[j-1];
				y += a[j-1];
			}
			else if(i < j && j < a.length){ //increment i, expand x, y shrinks to size 1, z expands to include prev y
				i++;
				j = i + 1;
				x += a[i-1];
				y = a[i];
				for(int k = j; k < a.length - 1; k++){
					z += a[k];
				}
			}
			else {
				break;
			}
			
			if(x == y && x == z) solns++;
		}
		
		return solns;
	}

}