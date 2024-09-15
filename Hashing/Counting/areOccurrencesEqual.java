// Level: easy. 1941: Check if All characters have equal number of occurrences

/*
 * Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).

Example 1:

Input: s = "abacbc"
Output: true
Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.

Example 2:

Input: s = "aaabb"
Output: false
Explanation: The characters that appear in s are 'a' and 'b'.
'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.

 */

class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        Map<Character, Integer> counts = new HashMap<>();

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            counts.put(c, counts.getOrDefault(c, 0)+1);
        }

        for(char element: counts.keySet())
        {
            set.add(counts.get(element));
        }

        return set.size() == 1;
    }
}

