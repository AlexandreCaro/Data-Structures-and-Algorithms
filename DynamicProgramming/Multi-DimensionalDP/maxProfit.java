// Level: Hard. 188. Best Time to Buy and Sell Stocks 4

/*
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:

Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

Constraints:

    1 <= k <= 100
    1 <= prices.length <= 1000
    0 <= prices[i] <= 1000


 */

class Solution {

    HashMap<Transaction, Integer> memo = new HashMap<>();

    int n;

    int[] prices;

    // int[][][] memo;

    
    public int maxProfit(int k, int[] prices) {

        n = prices.length;

        this.prices = prices;

        return dp(0, false, k);

    }

    public int dp(int day, boolean holding, int remain)
    {
        if(remain == 0 || day == n) return 0;

        Transaction transact = new Transaction(day, holding, remain);

        if(memo.containsKey(transact)) return memo.get(transact);

        int ans = 0;

        int skip = dp(day+1, holding, remain);

        if(holding == false)
        {
            int buy = -prices[day] + dp(day+1, true, remain);

            ans = Math.max(skip, buy);
        }
        else if(holding == true)
        {
            int sell = prices[day] + dp(day+1, false, remain-1);

            ans = Math.max(skip, sell);
        }

        memo.put(transact, ans);

        return ans;
    }


}

class Transaction
{
    int day;
    boolean holding;
    int remain;

    Transaction(int day, boolean holding, int remain)
    {
        this.day = day;
        this.holding = holding;
        this.remain = remain;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;

        if(o == null || getClass() != o.getClass()) return false;

        Transaction transaction = (Transaction) o;

        return this.day == transaction.day && this.holding == transaction.holding && this.remain == transaction.remain;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(day, holding, remain);
    }
}

// By using an array instead of a hashmap:

class Solution {

    int n;

    int[] prices;

    int[][][] memo;

    
    public int maxProfit(int k, int[] prices) {

        n = prices.length;

        this.prices = prices;

        memo = new int[n][2][k+1];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return dp(0, 0, k);

    }

    public int dp(int day, int holding, int remain)
    {
        if(remain == 0 || day == n) return 0;

        if(memo[day][holding][remain] != - 1) return memo[day][holding][remain];

        int ans = dp(day+1, holding, remain);

        if(holding == 1)
        {
            ans = Math.max(ans, prices[day] + dp(day+1, 0, remain-1));
        }
        else
        {
            ans = Math.max(ans, -prices[day] + dp(day+1, 1, remain));
        }

        memo[day][holding][remain] = ans;

        return ans;


    }


}

// Bottom-up strategy(my code):

class Solution {

    int n;

    int[] prices;

    int[][][] memo;

    
    public int maxProfit(int k, int[] prices) {

        n = prices.length;

        this.prices = prices;

        memo = new int[n+1][2][k+1];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                Arrays.fill(memo[i][j], -1);
            }
        }

        for(int day = n; day >= 0; day--)
        {
            for(int holding = 0; holding < 2; holding++)
            {
                for(int remain = 0; remain <= k; remain++)
                {
                    if(remain == 0 || day == n){

                        memo[day][holding][remain] = 0;
                        continue;

                    }

                    int ans = memo[day+1][holding][remain];

                    if(holding == 1)
                    {
                        ans = Math.max(ans, prices[day] + memo[day+1][0][remain-1]);
                    }
                    else
                    {
                        ans = Math.max(ans, -prices[day] + memo[day+1][1][remain]);
                    }

                    memo[day][holding][remain] = ans;
                }
            }
        }

        return memo[0][0][k];

    }


}
