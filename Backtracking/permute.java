// Level: medium. 46. Permutations

/*
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]

 */

class Solution {


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(new ArrayList<>(), ans, nums);

        return ans;
        
    }

    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums)
    {

        if(curr.size() == nums.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int num: nums)
        {
            if(!curr.contains(num))
            {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size()-1);
            }
        }
    }
}