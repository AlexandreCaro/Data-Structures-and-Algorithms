// Level: medium. 1268: Search Suggestions Systems

/*
 * You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].

 */

class Solution {

    TrieNode root;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        root = buildTrie(products);

        List<List<String>> ans = new LinkedList<>();

        TrieNode node = root;

        for(char c: searchWord.toCharArray())
        {

            if(node.children.containsKey(c))
            {
                node = node.children.get(c);
                ans.add(node.suggestions);
            }
            else
            {
                node.children = new HashMap<>();
                ans.add(new ArrayList<String>());
            }
        }

        return ans;
        
    }

    public TrieNode buildTrie(String[] words)
    {
        TrieNode node = new TrieNode();

        for(String word: words)
        {
            TrieNode curr = node;

            for(char c: word.toCharArray())
            {
                if(!curr.children.containsKey(c))
                {
                    curr.children.put(c, new TrieNode());
                }

                curr = curr.children.get(c);

                curr.suggestions.add(word);
                Collections.sort(curr.suggestions);

                if(curr.suggestions.size() > 3)
                {
                    curr.suggestions.remove(curr.suggestions.size() - 1);
                }
            }
        }

        return node;
    }

    
}

class TrieNode
{
    int data;
    Map<Character, TrieNode> children = new HashMap<>();
    List<String> suggestions;

    TrieNode()
    {
        this.children = new HashMap<>();
        this.suggestions = new ArrayList<>();
    }
    
}