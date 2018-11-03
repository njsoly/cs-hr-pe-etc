Jumping Jimmy is back, and he's ready to tackle a new tower!

He has the same goal as before (keep jumping as high as possible until he gets to the top or can't jump any higher), but this tower is a little different from the last one - some of the floors can affect Jimmy's jump height!

More specifically, there are power floors (which increase his jump height by 1), and poison floors (which decrease his jump height by 1). The indices of these floors are represented by the power and poison arrays. Each index is 0-based, and does not include the initial floor that Jimmy begins on.

Given tower (an array representing the gaps between each pair of consecutive floors), as well as power, poison, and jumpHeight, your task is to find the height of the highest floor in the tower that Jimmy will be able to reach.

Notes:

Both power and poison are sorted in ascending order, with no repeat elements.
Elements of power and poison are mutually exclusive - there are no floors that have both attributes.

Example

For tower = [1, 4, 3, 2, 2, 2, 2, 1, 4, 4, 2, 3, 3, 4, 1, 4, 2, 1, 2, 4, 1, 2, 2, 4, 1], power = [1, 3, 11], poison = [2, 4, 5, 7, 12, 20, 22], and jumpHeight = 4, the output should be jumpingJimmy2(tower, power, poison, jumpHeight) = 56.

At first the climb is looking promising for Jimmy, as he lands on some power floors, while avoiding poison floors. But his luck soon runs out, as he then encounters three poison floors, and becomes unable to reach the next floor. The height of the last reachable platform is 56.

Input / Output

[execution time limit] 3 seconds (java)

[input] array.integer tower

An array of integers representing the vertical distances between each pair of consecutive floors of the tower.

Guaranteed constraints:
1 ≤ tower.length ≤ 10^5
1 ≤ tower[i] ≤ 10^6

[input] array.integer power

A sorted array of integers representing the indices of all power floors in the tower (0-based, not including the initial platform that Jimmy starts on).These floors increase Jimmy's jump height by 1.

Guaranteed constraints:
0 ≤ power.length ≤ tower.length
0 ≤ power[i] < tower.length

[input] array.integer poison

A sorted array of integers representing the indices of all poison floors in the tower (0-based, not including the initial platform that Jimmy starts on). These floors decrease Jimmy's jump height by 1.

Guaranteed constraints:
0 ≤ poison .length ≤ tower.length
0 ≤ poison [i] < tower.length

[input] integer jumpHeight

An integer representing the initial vertical distance Jimmy is able to ascend in a single jump (before encountering any power or poison floors).

Guaranteed constraints:
0 ≤ jumpHeight ≤ 10^6

[output] integer

An integer representing the height of the highest floor Jimmy is able to reach (either the top of the tower or the point where he isn't able to complete the next jump).























