// Level: medium. 215: Kth Largest Element in an array.

/*
 * Runtime
71ms
Beats22.63%
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());

        for(int num: nums)
        {
            maxHeap.add(num);
        }

        int remain = k;

        int interest = 0;

        while(remain > 0)
        {
            if(remain == 1) interest = maxHeap.poll();

            maxHeap.poll();

            remain--;
        }
        
        return interest;
    }
}

/*
 * Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:

    1 <= k <= nums.length <= 105
    -104 <= nums[i] <= 104


 */