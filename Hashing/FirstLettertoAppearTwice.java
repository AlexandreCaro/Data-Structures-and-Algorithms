class Solution {
    public char repeatedCharacter(String s) {
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            for(int j = 0; j < i; j++)
            {
                if(s.charAt(j)==c) return c;
            }
        }

        return ' ';
    }
}

class Solution
{
    public char repeatedCharacter(String s)
    {
        HashSet<Character> seen = new HashSet<Character>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if(s.contains(c)) return c;

            seen.add(c);
        }

        return ' ';


    }
}