// Level: Medium. 22. Generate Parentheses

// My Solution.

/*
 * Runtime
2ms
Beats55.27%
 */

class Solution {

    List<String> ans = new LinkedList<>();

    HashMap<Character, Integer> counts = new HashMap<>();

    int lgt;

    public List<String> generateParenthesis(int n) {

        lgt = n;

        counts.put('(', 0);
        counts.put(')', 0);

        backtrack(new StringBuilder(""));

        return ans;
        
    }

    public void backtrack(StringBuilder current)
    {
        if(current.length() == 2*lgt)
        {
            ans.add(new String(current));
        }

        if(counts.get('(') < lgt)
        {
            current.append('(');
            counts.put('(', counts.get('(') + 1);

            backtrack(current);

            current.deleteCharAt(current.length()-1);
            counts.put('(', counts.get('(') - 1);
        }

        if(counts.get(')') < counts.get('('))
        {
            counts.put(')', counts.get(')')+1);
            current.append(')');
            backtrack(current);

            current.deleteCharAt(current.length()-1);
            counts.put(')', counts.get(')') - 1);
        }


    }
}

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

Constraints:

    1 <= n <= 8


 */