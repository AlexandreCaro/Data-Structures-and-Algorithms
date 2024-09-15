// Level: Medium. 64. Minimum Path Sum.

/*
 * Runtime
1ms
Beats92.33%

 */

class Solution {

    int[][] memo;

    int[][] globalGrid;

    public int minPathSum(int[][] grid) {

        globalGrid = grid;

        int m = grid.length;

        int n = grid[0].length;

        memo = new int[m][n];

        for(int i = 0; i < m; i++)
        {
            Arrays.fill(memo[i], -1);
        }

        return dp(m-1, n-1);
    }

    public int dp(int row, int col)
    {
        if(row + col == 0) return globalGrid[row][col];

        if(memo[row][col] != -1) return memo[row][col];

        int ways = globalGrid[row][col];

        if(row > 0 && col == 0)
        {
            ways += dp(row-1, col);
        }

        if(row == 0 && col > 0)
        {
            ways += dp(row, col-1);
        }

        if(row > 0 && col > 0)
        {
            ways += Math.min(dp(row-1, col), dp(row, col-1));
        }

        memo[row][col] = ways;

        return memo[row][col];
    }

}

// Alternative:

class Solution {

    int[][] memo;

    int[][] globalGrid;

    public int minPathSum(int[][] grid) {

        globalGrid = grid;

        int m = grid.length;

        int n = grid[0].length;

        memo = new int[m][n];

        for(int i = 0; i < m; i++)
        {
            Arrays.fill(memo[i], -1);
        }

        return dp(m-1, n-1);
    }

    public int dp(int row, int col)
    {
        if(row + col == 0) return globalGrid[row][col];

        if(memo[row][col] != -1) return memo[row][col];

        int ans = Integer.MAX_VALUE;

        if(row > 0)
        {
            ans = Math.min(ans, dp(row-1, col));
        }

        if(col > 0)
        {
            ans = Math.min(ans, dp(row, col-1));
        }

        memo[row][col] = globalGrid[row][col] + ans;

        return memo[row][col];
    }


}

// Iterative version(less efficient):

class Solution {

    int[][] dp;

    int[][] globalGrid;

    public int minPathSum(int[][] grid) {

        globalGrid = grid;

        int m = grid.length;

        int n = grid[0].length;

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
                    dp[row][col] = globalGrid[0][0];
                    continue;
                }

                int ans = Integer.MAX_VALUE;

                if(row > 0)
                {
                    ans = Math.min(ans, dp[row-1][col]);
                }

                if(col > 0)
                {
                    ans = Math.min(ans, dp[row][col-1]);
                }

                dp[row][col] = globalGrid[row][col] + ans;
            }
        }

        return dp[m-1][n-1];
    }

}

/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 200
    0 <= grid[i][j] <= 200


 */

// Better space complexity:

class Solution {

    int[] dp;

    int[][] globalGrid;

    public int minPathSum(int[][] grid) {

        globalGrid = grid;

        int m = grid.length;

        int n = grid[0].length;

        dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int row = 0; row < m; row++)
        {
            int[] nextRow = new int[n];

            for(int col = 0; col < n; col++)
            {
                nextRow[col] = dp[col];

                if(col > 0)
                {
                    nextRow[col] = Math.min(nextRow[col], nextRow[col-1]);
                }

                nextRow[col] += grid[row][col];
            }

            dp = nextRow;
        }

        return dp[n-1];
    }

}