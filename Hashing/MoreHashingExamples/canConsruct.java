// Level: Easy. 383: Ransom Note.

// My Solution

class Solution {

    HashMap<Character, Integer> ransom = new HashMap<>();

    HashMap<Character, Integer> magaz = new HashMap<>();

    public boolean canConstruct(String ransomNote, String magazine) {
        
        for(int i = 0; i < ransomNote.length(); i++)
        {
            char letter = ransomNote.charAt(i);

            ransom.put(letter, ransom.getOrDefault(letter, 0)+1);
        }

        for(int i = 0; i < magazine.length(); i++)
        {
            char letter = magazine.charAt(i);

            magaz.put(letter, magaz.getOrDefault(letter, 0)+1);
        }

        for(Character letter: ransom.keySet())
        {
            if(magaz.get(letter) == null) return false;

            if(magaz.get(letter) < ransom.get(letter)) return false;
        }

        return true;
    }
}

/*
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:

    1 <= ransomNote.length, magazine.length <= 105
    ransomNote and magazine consist of lowercase English letters.


 */