// Level: Easy. Maximum Average Subarray 1

/*
 * You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:

Input: nums = [5], k = 1
Output: 5.00000

Constraints:

    n == nums.length
    1 <= k <= n <= 105
    -104 <= nums[i] <= 104


 */

// My Solution: 121/127 test cases passed

 class Solution {
    public double findMaxAverage(int[] nums, int k) {

        if(nums.length == 1) return (double) nums[0];
        
        int left = 0;
        int right = 0;
        long sum = 0;
        
        double average = Double.MIN_VALUE;

        if(k >= nums.length)
        {
            
            for(int num: nums)
            {
                sum += num;
            }

            return (double) sum/nums.length;
        }
        
        for(right = 0; right < nums.length; right++)
        {
            sum += nums[right];

            while(right - left + 1 >= k)
            {
            
                double currAv = (double) sum/k;
                average = Math.max(average, currAv);
                
                sum -= nums[left];
                left++;
            }
             
        }
        
        return average;
        
    }
}

// Leetcode solution:

class Solution {
    public double findMaxAverage(int[] nums, int k) {

        if(nums.length == 1) return (double) nums[0];
        
        int left = 0;
        int right = 0;
        double sum = 0;
        
        double average = Integer.MIN_VALUE;
        
        for(right = 0; right < nums.length; right++)
        {
            sum += nums[right];

            if((right - left + 1) == k)
            {
            
                average = Math.max(average, sum);
                
                sum -= nums[left];
                left++;
            }
             
        }
        
        return average/k;
        
    }
}