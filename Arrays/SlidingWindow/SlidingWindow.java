public int fn(int[] nums, int k)
{
    int left = 0;

    int curr = 0;

    int ans = 0;

    for(int right = 0; right < nums.length; right++)
    {
        curr += nums[right];

        while(curr > k)
        {
            curr -= nums[left];
            left++;
        }

        ans = Math.max(ans, right - left + 1);
    }

    return ans;
}