// Level: Easy. 70. Climbing Stairs

class Solution {

    int n;

    HashMap<Integer, Integer> memo = new HashMap<>();


    public int climbStairs(int n) {

        this.n = n;

        return dp(n);

    }

    public int dp(int i)
    {
        if(i == n+1) return 0;

        if(i==1) return 1;

        if(i==2) return 2;

        if(memo.containsKey(i)) return memo.get(i);

        int skip = dp(i-2);

        int take = dp(i-1);

        memo.put(i, skip+take);

        return skip+take;
    }
    
}

// Iterative version:

class Solution {

    public int climbStairs(int n) {

        if(n==0) return 0;

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        if(n <= 1) return 1;

        dp[2] = 2;

        if(n <= 2) return dp[n];

        for(int i = 3; i <= n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    
    }
    
}

/*
 * You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:

    1 <= n <= 45


 */