public class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        HashMap<Integer, Integer> dic = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++)
        {
            int num = nums[i];

            int complement = target - num;

            if(dic.containsKey(complement)) return new int[]{i, dic.get(complement)};
        
            dic.put(num, i);
        }

        return new int[]{-1, -1};
    }
}