class Solution
{
    public List<Integer> findNumbers(int[] nums)
    {
        List<Integer> ans = new ArrayList<Integer>();
        Set<Integer> numsSet = new Set<Integer>();

        for(int num: nums)
        {
            numsSet.add(num);
        }

        for(int x: numsSet)
        {
            !f(!numsSet.contains(x+1) && !numsSet.contains(x-1)) ans.add(x);
        }

        return ans;
    }
}