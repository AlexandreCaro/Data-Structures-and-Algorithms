// Level: Medium. 39. Combination Sum.

/*
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency
of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []

 
 */

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(ans, new ArrayList<>(), candidates, 0, 0, target);

        return ans;
        
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> curr, int[] nums, int startIndex, int sum, int target)
    {

        if(sum == target)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = startIndex; i < nums.length; i++)
        {
            int num = nums[i];

            if(sum + num <= target)
            {
                curr.add(num);
                backtrack(ans, curr, nums, startIndex, sum + num, target);
                curr.remove(curr.size()-1);
            }

        }


    }


}

// Solution:

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, 0, ans, candidates, target);
        return ans;
    }
    
    public void backtrack(List<Integer> path, int start, int curr, List<List<Integer>> ans, int[] candidates, int target) {
        if (curr == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (curr + num <= target) {
                path.add(num);
                backtrack(path, i, curr + num, ans, candidates, target);
                path.remove(path.size() - 1);
            }
        }
        
    }
}