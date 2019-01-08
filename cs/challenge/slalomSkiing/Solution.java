// https://app.codesignal.com/challenge/RLhyzdapSvfRXCHHd

/* 
	You love competing in slalom skiing competitions - a form of alpine skiing that involves passing by a series of flags, alternating between left and right.

	To help get more practice, your friends are building a slalom skiing course! You're excited to try it out, but for your safety you'd like to be sure that it's designed within acceptable limits. More specifically, you need to check that there are no areas where you'd need to travel too far horizontally between any two consecutive flags.

	The array flags represents the horizontal position of each flag, in the order they appear; for the sake of simplicity, the flags are vertically spaced at consistent intervals down the hill.

	You can choose to start on the left or the right of the first flag, but you must alternate directions for each consecutive flag after that. You always pass the flag exactly 1 unit to the left or right of it.

	Your task is to determine whether it's possible to complete the course without having to cut across a horizontal distance greater than threshold between consecutive flags. If it's not possible, return the index of the first flag that poses a problem (the furthest one possible). If it is possible to complete the course without exceeding threshold, return -1.

	Example

	For flags = [4, 3, 8, 10] and threshold = 4, the output should be slalomSkiing(flags, threshold) = -1.

	right path
	By starting to the right of the first flag, we'll have a problem with flag 2 - we would need to travel 7 units horizontally, which exceeds the threshold of 4.

	left path
	Taking the left path allows us to complete the whole course! So return -1.

	For flags = [5, 6, 1, 12, 7, 2, 10] and threshold = 8, the output should be slalomSkiing(flags, threshold) = 3.

	In this case, no matter which direction we take, there's no way to get to flag 3 - in the best case, we would need to travel 9 horizontal units, which exceeds the threshold!

	Input / Output

	[execution time limit] 3 seconds (java)

	[input] array.integer flags

	An array of integers representing the horizontal position of each of the flags, in the order in which they appear.

	Guaranteed constraints:
	2 ≤ flags.length ≤ 104
	1 ≤ flags[i] ≤ 106

	[input] integer threshold

	An integer representing the maximum possible horizontal distance you can travel between flags.

	Guaranteed constraints:
	1 ≤ threshold ≤ 106

	[output] integer

	An integer representing the 0-based index of the first flag that's not possible to reach (assuming you choose the route that allows you to go furthest), or -1 if it's possible to clear the whole course. 
 */
	
public class Solution {

	int slalomSkiing(int[] flags, int threshold) {

	}

}
