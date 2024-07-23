// Level: Easy. 746. Min Cost Climbing Stairs.

// Recursive solution: 259/284 test casses passed

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        return dp(cost.length, cost);
    }

    public int dp(int i, int[] cost)
    {
        if(i==0 || i == 1) return 0;

        return Math.min(dp(i-1, cost) + cost[i-1], dp(i-2, cost) + cost[i-2]);
    }

}

// Iterative bottom-up version: complete success 284/284 test casses passed

class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        
        int[] arr = new int[n+1];

        for(int i = 2; i <= n; i++)
        {
            arr[i] = Math.min(arr[i-1] + cost[i-1], arr[i-2] + cost[i-2]);
        }

        return arr[n];
    }

}

// Recurisve top-down: accepted

class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        
        return dp(cost.length, cost);
    }

    public int dp(int i, int[] cost)
    {
        if(i==0 || i == 1) return 0;

        if(memo.containsKey(i)) return memo.get(i);

        memo.put(i, Math.min(dp(i-1, cost) + cost[i-1], dp(i-2, cost) + cost[i-2]));

        return memo.get(i);
    }

}