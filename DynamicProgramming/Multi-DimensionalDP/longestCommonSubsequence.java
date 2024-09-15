// Level: Medium. 1143: Longest Common Subsequence

/*
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".

A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

 */

// My solution: 17/47 testcases passed

class Solution {

    String firstText;

    String secondText;

    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        
        firstText = text1;

        secondText = text2;

        // int[][] dp = new int[firstText.length()+1][secondText.length()+1];

        return dp(0, 0);

    }

    public int dp(int i, int j)
    {
        if(i == firstText.length() || j == secondText.length()) return 0;

        if(firstText.charAt(i) == secondText.charAt(j)) return 1 + dp(i+1, j+1);

        else
        {
            return Math.max(dp(i, j+1), dp(i+1, j));
        }

    }
}

// Leetcode:

class Solution {
    int m;
    int n;
    int[][] memo;
    String text1;
    String text2;
    
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        this.text1 = text1;
        this.text2 = text2;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return dp(0, 0);
    }
    
    public int dp(int i, int j) {
        if (i == m || j == n) {
            return 0;
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        int ans = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + dp(i + 1, j + 1);
        } else {
            ans = Math.max(dp(i + 1, j), dp(i, j + 1));
        }
        
        memo[i][j] = ans;
        return ans;
    }
}

// Bottom-up:

class Solution {
    int m;
    int n;
    int[][] memo;
    String text1;
    String text2;
    
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        this.text1 = text1;
        this.text2 = text2;
        memo = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        for(int i = m; i >= 0; i--)
        {
            for(int j = n; j >= 0; j--)
            {
                if(i == m || j == n)
                {
                    memo[i][j] = 0;
                    continue;
                }

                int ans = 0;

                if(text1.charAt(i) == text2.charAt(j))
                {
                    ans = 1 + memo[i+1][j+1];
                }
                else
                {
                    ans = Math.max(memo[i+1][j], memo[i][j+1]);
                }

                memo[i][j] = ans;
            }   
        }

        return memo[0][0];
    }
    
    
}