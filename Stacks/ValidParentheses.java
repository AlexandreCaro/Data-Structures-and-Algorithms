/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

 

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true
 */

class Solution {
    public boolean isValid(String s) {

        if(s=="") return true;
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();

        Stack<Character> stack = new Stack<Character>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(char c: s.toCharArray())
        {
            if(c=='(' || c=='{' || c == '[') stack.push(c);

            else
            {
                if(stack.isEmpty()) return false;
                
                char current = stack.peek();

                if(map.get(c) == current) stack.pop();

                else return false;
            }
        }

        if(stack.size() >= 1) return false;

        return true;
    }
}