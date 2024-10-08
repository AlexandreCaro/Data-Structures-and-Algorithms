public boolean[] answerQueries(int[] nums, int[][] queries, int limit)
{
    int[] prefix = new int[nums.length];

    prefix[0] = nums[0];

    for(int i = 1; i < prefix.length; i++)
    {
        prefix[i] = prefix[i-1] + nums[i];
    }

    boolean[] isValid = new boolean[queries.length];

    for(int i = 0; i < queries.length; i++)
    {
        int x = queries[i][0], y = queries[i][1];

        int curr = prefix[y] - prefix[x] + nums[x];

        isValid[i] = curr < limit;
    }

    return isValid;
}