class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> stack = new Stack<Character>();

        String emptyLiteral = "";

        String finale = "";

        int index = 0;

        for(char c: s.toCharArray())
        {

            if(index == 0)
            {
                stack.push(c);
                index++;
                continue;
            }

            if(stack.isEmpty())
            {
                stack.push(c);
                continue;
            }

            char current = stack.peek();

            System.out.println(current);

            if(current == c) stack.pop();
            else{
                stack.push(c);
            }

            index++;
        }

        while(!stack.isEmpty())
        {
            char cur = stack.pop();

            finale = cur + finale;
        }

        return finale;
    }
}

// Leetcode solution:

class Solution {
    public String removeDuplicates(String s) {
        
        StringBuilder stack = new StringBuilder();

        for(char c: s.toCharArray())
        {
            if(stack.length() > 0 && stack.charAt(stack.length()-1) == c)
            {
                stack.deleteCharAt(stack.length()-1);
            }
            else 
            {
                stack.append(c);
            }
        }

        return stack.toString();
    }
}