// Level: Medium. 2575: Find the divisibility array of a string.

// My Solution. 

/*
 * Runtime
7ms
Beats 83.84%
*/

class Solution {

    int m;

    public int[] divisibilityArray(String word, int m) {

        int n = word.length();

        this.m = m;

        int[] arr = new int[n];

        long result = 0;

        for(int i = 0; i < n; i++)
        {
            char c = word.charAt(i);
            int digit = c - '0';
            result = (result * 10 + digit);

            if(result % m == 0) arr[i] = 1;
            else arr[i] = 0;

            result = result % m;
        }

        return arr;
    }

    public int parseString(String s)
    {
        int result = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int digit = c - '0';

            result = (result * 10 + digit);
        }

        return result;
    }
}

/*
 * You are given a 0-indexed string word of length n consisting of digits, and a positive integer m.

The divisibility array div of word is an integer array of length n such that:

    div[i] = 1 if the numeric value of word[0,...,i] is divisible by m, or
    div[i] = 0 otherwise.

Return the divisibility array of word.

Example 1:

Input: word = "998244353", m = 3
Output: [1,1,0,0,0,1,1,0,0]
Explanation: There are only 4 prefixes that are divisible by 3: "9", "99", "998244", and "9982443".

Example 2:

Input: word = "1010", m = 10
Output: [0,1,0,1]
Explanation: There are only 2 prefixes that are divisible by 10: "10", and "1010". 

Constraints:

    1 <= n <= 105
    word.length == n
    word consists of digits from 0 to 9
    1 <= m <= 109


 */