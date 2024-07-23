// Level: medium. 78: subsets

/*
 * Given an integer array nums of unique elements, return all possible
subsets
(the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(ans, new ArrayList<Integer>(), nums, 0);

        return ans;
        
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] nums, int startIndex)
    {
        if(startIndex > nums.length) return;
        
        ans.add(new ArrayList<>(curr));

        for(int i = startIndex; i < nums.length; i++)
        {
            int num = nums[i];

            curr.add(num);
            backtrack(ans, curr, nums, i+1);
            curr.remove(curr.size()-1);
            
        }
    }
}