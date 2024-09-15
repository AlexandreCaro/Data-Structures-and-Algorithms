// Medium. 1004. Max Consecutive Ones 3

/*
 * Runtime
3ms
Beats86.29%

 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;

        int left = 0;
        int right = 0;
        int count_zeros = 0;

        int ans = 0;

        for(right = 0; right < n; right++)
        {

            if(nums[right] == 0) count_zeros++;

            while(count_zeros > k)
            {
                if(nums[left] == 0) count_zeros--;

                left++;

            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;

    }
}

/*
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Constraints:

    1 <= nums.length <= 105
    nums[i] is either 0 or 1.
    0 <= k <= nums.length


 */