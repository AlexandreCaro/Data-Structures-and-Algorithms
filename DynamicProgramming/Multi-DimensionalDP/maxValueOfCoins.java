// Level: Hard. 2218: Maximum Value of K Coins from Piles

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        int n = piles.size();

        int[][] dp = new int[n][k];

        for(int pile = n-1; pile >= 0; pile--)
        {
            for(int remain = 0; remain < k; remain++)
            {

                if(pile == n-1 || remain == 0)
                {
                    dp[pile][remain] = 0;
                    continue;
                }

                int skip = dp[pile+1][remain];

                int take = 0;

                for(int j = 0; j < Math.min(remain, piles.get(pile).size()); j++)
                {
                    take = Math.max(take, somme(piles.get(pile), j) + dp[pile+1][remain - j - 1]);
                }

                dp[pile][remain] = Math.max(skip, take);
            }
        }

        return dp[0][k-1];
        
    }

    public int somme(List<Integer> piles, int index)
    {
        int sum = 0;

        for(int j = 0; j < index; j++)
        {
            sum += piles.get(j);
        }

        return sum;
    }
}

// 2nd attempt

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        int n = piles.size();

        int[][] dp = new int[n+1][k+1];

        for(int pile = n; pile >= 0; pile--)
        {
            for(int remain = 0; remain <= k; remain++)
            {

                if(pile == n || remain == 0)
                {
                    dp[pile][remain] = 0;
                    continue;
                }

                int skip = dp[pile+1][remain];

                int take = 0;
                int sum = 0;

                for(int j = 0; j < Math.min(remain, piles.get(pile).size()); j++)
                {
                    sum += piles.get(pile).get(j);
                    take = Math.max(take, sum + dp[pile+1][remain - (j + 1)]);
                }

                dp[pile][remain] = Math.max(skip, take);
            }
        }

        return dp[0][k];
        
    }

    public int somme(List<Integer> piles, int index)
    {
        int sum = 0;

        for(int j = 0; j < index; j++)
        {
            sum += piles.get(j);
        }

        return sum;
    }
}

/*
 * There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.

In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.

Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to bottom, and a positive integer k, return the maximum total value of coins you can have in your wallet if you choose exactly k coins optimally.

Example 1:

Input: piles = [[1,100,3],[7,8,9]], k = 2
Output: 101
Explanation:
The above diagram shows the different ways we can choose k coins.
The maximum total we can obtain is 101.

Example 2:

Input: piles = [[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]], k = 7
Output: 706
Explanation:
The maximum total can be obtained if we choose all coins from the last pile.

Constraints:

    n == piles.length
    1 <= n <= 1000
    1 <= piles[i][j] <= 105
    1 <= k <= sum(piles[i].length) <= 2000


 */

// Leetcode solution:

class Solution {

    int n;

    int[][] memo;

    List<List<Integer>> piles;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        n = piles.size();

        memo = new int[n][k+1];

        for(int i = 0; i < n; i++)
        {
            Arrays.fill(memo[i], -1);
        }

        this.piles = piles;

        return dp(0, k);
        
    }

    public int dp(int i, int remain)
    {
        if(i == n || remain == 0)
        {
            return 0;
        }

        if(memo[i][remain] != - 1)
        {
            return memo[i][remain];
        }

        int ans = dp(i+1, remain);

        int curr = 0;

        for(int j = 0; j < Math.min(remain, piles.get(i).size()); j++)
        {
            curr += piles.get(i).get(j);
            ans = Math.max(ans, curr + dp(i+1, remain-j-1));
        }

        memo[i][remain] = ans;
        
        return ans;
    }
}