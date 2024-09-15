/*
 * Example 4: Given an integer array nums and an integer k, find the sum of the subarray with the largest sum whose length is k.
 */

public int findBestSubarray(int[] nums, int k)
{
    int curr = 0;

    for(int i = 0; i < k; i++)
    {
        curr += nums[i];
    }

    int ans = curr;

    for(int i = k; nums.length; i++)
    {
        curr += nums[i] - nums[i-k];
        ans = Math.max(ans, curr);
    }

    return ans;
}