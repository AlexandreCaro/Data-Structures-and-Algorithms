// Level: Medium. 77. Combinations

/*
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();

        int[] nums = new int[n+1];

        for(int i = 0; i <= n; i++)
        {
            nums[i] = i;
        }

        backtrack(ans, new ArrayList<>(), 1, k, nums);

        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> curr, int startIndex, int k, int[] nums)
    {
        if(curr.size() == k)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = startIndex; i < nums.length; i++)
        {
            int num = nums[i];

            curr.add(num);
            backtrack(ans, curr, i+1, k, nums);
            curr.remove(curr.size()-1);
        }
    }
}

// Leetcode solution:

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(ans, new ArrayList<>(), 1, k, n);

        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> curr, int startIndex, int k, int n)
    {
        if(curr.size() == k)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = startIndex; i <= n; i++)
        {

            curr.add(i);
            backtrack(ans, curr, i+1, k, n);
            curr.remove(curr.size()-1);
        }
    }
}