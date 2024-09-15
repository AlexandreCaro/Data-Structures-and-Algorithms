// Level: Medium. 62. Unique Paths.

/*
 * Runtime
0ms
Beats100.00%

 */

// Recursive solution

class Solution {

    int[][] memo;

    public int uniquePaths(int m, int n) {

        memo = new int[m][n];

        for(int i = 0; i < m; i++)
        {
            Arrays.fill(memo[i], -1);
        }

        return dp(m-1, n-1);
        
    }

    public int dp(int row, int col)
    {
        if(row + col == 0) return 1;

        if(memo[row][col] != -1)
        {
            return memo[row][col];
        }

        int ways = 0;

        if(row > 0) ways += dp(row-1, col);

        if(col > 0) ways += dp(row, col-1);

        memo[row][col] = ways;

        return memo[row][col];
    }
}

/*
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:

Input: m = 3, n = 7
Output: 28

Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Constraints:

    1 <= m, n <= 100

 */

// Iterative solution

class Solution {

    int[][] dp;

    public int uniquePaths(int m, int n) {

        dp = new int[m][n];

        for(int i = 0; i < m; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        for(int row = 0; row < m; row++)
        {
            for(int col = 0; col < n; col++)
            {
                if(row + col == 0)
                {
                    dp[row][col] = 1;
                    continue;
                }

                int ways = 0;

                if(row > 0) ways += dp[row-1][col];

                if(col > 0) ways += dp[row][col-1];

                dp[row][col] = ways;

            }
        }

        return dp[m-1][n-1];
        
    }

}

// O(n) space complexity

class Solution {

    int[] dp;

    public int uniquePaths(int m, int n) {

        dp = new int[n];

        dp[0] = 1;

        for(int row = 0; row < m; row++)
        {
            int[] nextRow = new int[n];

            for(int col = 0; col < n; col++)
            {
                nextRow[col] += dp[col];

                if(col > 0) nextRow[col] += nextRow[col-1];
            }
            
            dp = nextRow;
        }

        return dp[n-1];
        
    }

}