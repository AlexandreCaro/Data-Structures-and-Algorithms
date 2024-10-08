// Level: Easy. 1544: Make the String Great

// 318: 335 test cases passed

class Solution {
    public String makeGood(String s) {

        StringBuilder string = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        int index = 0;

        Character previous = null;

        for(char character: s.toCharArray())
        {

            // System.out.println(character + " " + index);

            if(!stack.isEmpty()) previous = stack.peek();

            stack.push(character);

            if(previous == null) continue;

            boolean isSame = previous == character;

            boolean isUpperCase1 = Character.toUpperCase(previous) == character;

            boolean isUpperCase2 = Character.toUpperCase(character) == previous;

            boolean isLowerCase1 = Character.toLowerCase(character) == previous;

            boolean isLowerCase2 = Character.toLowerCase(previous) == character;

            boolean isLowerCase = isLowerCase1 || isLowerCase2;

            boolean isUpperCase = isUpperCase1 || isUpperCase2;

            if(isSame) continue;

            if(isUpperCase || isLowerCase)
            {
                System.out.println("HERE");

                //System.out.println(stack.peek());

                if(!stack.isEmpty()) stack.pop();

                // System.out.println(stack.peek());

                if(!stack.isEmpty()) stack.pop();
            }


            index++;
        }

        for(char character: stack)
        {
            string.append(character);
        }

        return string.toString();
        
    }
}

// 2nd attempt:

class Solution {
    public String makeGood(String s) {

        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray())
        {
            if(sb.length() > 0 && Math.abs(sb.charAt(sb.length()- 1) - c) == 32) sb.deleteCharAt(sb.length()-1);

            else sb.append(c);
        }

        return sb.toString();
    }
}

/*
 * Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

    0 <= i <= s.length - 2
    s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.

To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.

Example 1:

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".

Example 2:

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""

Example 3:

Input: s = "s"
Output: "s"

Constraints:

    1 <= s.length <= 100
    s contains only lower and upper case English letters.


 */