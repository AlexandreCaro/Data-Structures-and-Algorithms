// Level: medium. 560. Subarray sums equals K.

/*
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int curr = 0, ans = 0;

        counts.put(0, 1);

        for(int num: nums)
        {
            curr += num;
            ans += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }

        return ans;
    }
}