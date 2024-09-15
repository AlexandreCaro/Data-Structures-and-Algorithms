// Level: medium. 713. Subarray product less than K

/*
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Example 2:

Input: nums = [1,2,3], k = 0
Output: 0

 
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int left = 0;

        if(k <= 1) return 0;

        int curr = 1;

        int ans = 0;

        for(int right = 0; right < nums.length; right++)
        {
            curr *= nums[right];

            while(curr >= k)
            {
                curr = curr/nums[left];
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}