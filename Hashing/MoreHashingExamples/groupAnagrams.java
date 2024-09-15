// Level: Medium. 49. Group Anagrams

/*
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]

 */

class Solution {

    HashMap<String, List<String>> map = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        
        for(String word: strs)
        {
            char[] charArray = word.toCharArray();

            Arrays.sort(charArray);

            String ordered = new String(charArray);

            if(!map.containsKey(ordered)) map.put(ordered, new ArrayList<>());

            List<String> current = map.get(ordered);

            current.add(word);
        }

        List<List<String>> ans = new ArrayList<>();

        for(List<String> value: map.values())
        {
            ans.add(value);
        }

        return ans;
    }
}

// Another solution:

class Solution {

    HashMap<String, List<String>> map = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        
        for(String word: strs)
        {
            char[] charArray = word.toCharArray();

            Arrays.sort(charArray);

            String ordered = new String(charArray);

            if(!map.containsKey(ordered)) map.put(ordered, new ArrayList<>());

            map.get(ordered).add(word);
        }

        return new ArrayList(map.values());
    }
}