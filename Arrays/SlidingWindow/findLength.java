public int findLength(String s)
{
    int left = 0, ans = 0, curr = 0;

    for(int right = 0; right < s.length(); right++)
    {
        if(s.charAt(right) == "0") curr++;

        while(curr > 1)
        {
            if(s.charAt(left) == "0") curr--;

            left++;
        }

        ans = Math.max(ans, right - left + 1);
    }

    return ans;
}