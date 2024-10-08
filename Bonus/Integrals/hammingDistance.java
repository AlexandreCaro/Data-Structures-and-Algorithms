// Level: Easy. 461: Hamming Distance

/*
 * Runtime
0ms
Beats100.00%

 */

class Solution {
    public int hammingDistance(int x, int y) {

        int count = 0;

        int xor = x ^ y;

        while(xor != 0)
        {
            count += xor & 1;
            xor = xor >> 1;
        }

        return count;
        
    }
}

/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.

Example 2:

Input: x = 3, y = 1
Output: 1

Constraints:

    0 <= x, y <= 231 - 1


 */