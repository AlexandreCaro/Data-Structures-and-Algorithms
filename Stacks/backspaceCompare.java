/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".


*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> stackS = new Stack<Character>();

        Stack<Character> stackT = new Stack<Character>();

        for(char c: s.toCharArray())
        {
            if(stackS.isEmpty())
            {
                if(c!='#')
                {
                    stackS.push(c);
                }
                
                continue;
            }

            if(c == '#')
            {
                stackS.pop();
                continue;
            }

            stackS.push(c);
        }

        for(char c: t.toCharArray())
        {
            if(stackT.isEmpty())
            {
                if(c!='#')
                {
                    stackT.push(c);
                }
                continue;
            }

            if(c=='#')
            {
                stackT.pop();
                continue;
            }

            stackT.push(c);
        }

        char ch1, ch2;

        System.out.println(stackS.size() + " " + stackT.size());

        if(stackS.size() != stackT.size()) return false;

        while(!stackS.isEmpty() && !stackT.isEmpty())
        {
            ch1 = stackS.pop();

            ch2 = stackT.pop();

            System.out.println(ch1 + " " + ch2);

            if(ch1 != ch2) return false;
        }

        return true;
    }
}

// Leetcode solution

class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        return build(s).equals(build(t));
    }

    public String build(String s)
    {
        StringBuilder stack = new StringBuilder();

        for(char c: s.toCharArray())
        {
            if(c!='#')
            {
                stack.append(c);
            }
            else if(stack.length() > 0)
            {
                stack.deleteCharAt(stack.length()-1);
            }
        }

        return stack.toString();
    }
}