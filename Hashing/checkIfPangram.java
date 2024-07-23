class Solution {
    public boolean checkIfPangram(String sentence) {
        
        Set<Character> letters = new HashSet<Character>();
        
        for(int i = 0; i < sentence.length(); i++)
        {
            char c = sentence.charAt(i);
            
            letters.add(c);
        }
        
        if(letters.size() == 26) return true;
        
        return false;
    }
}