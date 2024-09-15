public in t findLongestSubstring(String s, int k)
{
    int left = 0, ans = 0;

    Map<Character, Integer> counts = new HashMap<>();

    for(int right = 0; right < s.length(); right++)
    {
        char c = s.charAt(right);

        couts.put(c, counts.getOrDefault(c, 0)+1);

        while(counts.size() > k)
        {
            char remove = s.charAt(left);

            counts.put(remove, counts.getOrDefault(remove, 0) - 1);

            if(counts.get(remove) == 0)
            {
                counts.remove(remove);
            }

            left++;
        }

        ans = Math.max(ans, right - left + 1);
    }

    return ans;
}