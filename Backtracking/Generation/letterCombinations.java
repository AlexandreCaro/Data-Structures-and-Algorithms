// Level: Medium. 17. Letter combinations of a phone number.

/*
 * Runtime
1ms
Beats65.36%

 */

class Solution {

    HashMap<Character, String> map = new HashMap<>();

    List<String> ans = new LinkedList<>();

    String digits;

    public List<String> letterCombinations(String digits) {

        if(digits.equals("")) return ans;

        constructMap();

        this.digits = digits;

        backtrack(new StringBuilder(), 0);

        return ans;
        
    }

    public void backtrack(StringBuilder current, int digit_index)
    {
        if(current.length() == digits.length())
        {
            ans.add(new String(current.toString()));
            return;
        }

        String letters = map.get(digits.charAt(digit_index));

        for(char letter: letters.toCharArray())
        {
            current.append(letter);
            backtrack(current, digit_index+1);
            current.deleteCharAt(current.length()-1);
        }

    }

    public void constructMap()
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]

Constraints:

    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].


 */