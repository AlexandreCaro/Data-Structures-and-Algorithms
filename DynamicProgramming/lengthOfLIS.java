// Level: Medium. 300. Longest Increasing Subsequence

/*
 * Given an integer array nums, return the length of the longest strictly increasing
subsequence.

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

 */

 // Top-down implementation

class Solution {

    HashMap<Integer, Integer> memo = new HashMap<>();

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int ans = 1;

        for(int i = 0; i < n; i++)
        {
            ans = Math.max(ans, dp(i, nums));
        }

        return ans;
        
    }

    public int dp(int i, int[] nums)
    {
        if(memo.containsKey(i)) return memo.get(i);

        int ans = 1;

        for(int j = 0; j < i; j++)
        {
            if(nums[i] > nums[j])
            {
                ans = Math.max(ans, dp(j, nums)+1);
            }
        }

        memo.put(i, ans);

        return ans;
    }
}

// Bottom-up approach

class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int ans = 1;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        return ans;
        
    }

}