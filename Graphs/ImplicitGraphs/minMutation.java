// Level: Medium. 433: Minimum Genetic Mutation

// My Solution: 11/18 test cases passed. Time Limit exceeded

class Solution {

    LinkedList<String> geneBank = new LinkedList<>();

    LinkedList<String> nucleotides = new LinkedList<>(Arrays.asList("A", "T", "G", "C"));

    HashSet<String> seen = new HashSet<>();

    public int minMutation(String startGene, String endGene, String[] bank) {

        geneBank = new LinkedList(Arrays.asList(bank));

        Queue<String> queue = new LinkedList<>();

        queue.add(startGene);
        seen.add(startGene);

        int steps = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                String current = queue.remove();

                if(current.equals(endGene)) return steps;

                List<String> near = neighbors(new StringBuilder(current));

                queue.addAll(near);

            }

            steps++;
        }
        
        return -1;
    }

    public List<String> neighbors(StringBuilder gene)
    {
        List<String> ans = new LinkedList<>();

        for(int i = 0; i < gene.length(); i++)
        {
            ans.addAll(change(gene, i));
        }

        return ans;
    }

    public List<String> change(StringBuilder gene, int i)
    {

        List<String> neighbors = new LinkedList<>();

        char character = gene.charAt(i);

        for(String nucleotide: nucleotides)
        {
            char nucleo = nucleotide.charAt(0);

            if(nucleo == character)
            {
                System.out.println(character);
                continue;
            }

            gene.setCharAt(i, nucleo);
            String current = gene.toString();
            if(geneBank.contains(current) && !seen.contains(current)) neighbors.add(current);
            gene.setCharAt(i, character);
        }

        return neighbors;
    }
}

// 2nd attempt: 15/18 test cases

// You prune the search space if the ith index of the current gene is equal to the ith index of the goal gene

class Solution {

    LinkedList<String> geneBank = new LinkedList<>();

    LinkedList<String> nucleotides = new LinkedList<>(Arrays.asList("A", "T", "G", "C"));

    String goal;

    HashSet<String> seen = new HashSet<>();

    public int minMutation(String startGene, String endGene, String[] bank) {

        goal = endGene;

        geneBank = new LinkedList(Arrays.asList(bank));

        Queue<String> queue = new LinkedList<>();

        queue.add(startGene);
        seen.add(startGene);

        int steps = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                String current = queue.remove();

                if(current.equals(endGene)) return steps;

                List<String> near = neighbors(new StringBuilder(current));

                queue.addAll(near);

            }

            steps++;
        }
        
        return -1;
    }

    public List<String> neighbors(StringBuilder gene)
    {
        List<String> ans = new LinkedList<>();

        for(int i = 0; i < gene.length(); i++)
        {
            ans.addAll(change(gene, i));
        }

        return ans;
    }

    public List<String> change(StringBuilder gene, int i)
    {

        List<String> neighbors = new LinkedList<>();

        char character = gene.charAt(i);

        if(goal.charAt(i) == gene.charAt(i)) return neighbors;

        for(String nucleotide: nucleotides)
        {
            char nucleo = nucleotide.charAt(0);

            if(nucleo == character)
            {
                System.out.println(character);
                continue;
            }

            gene.setCharAt(i, nucleo);
            String current = gene.toString();
            if(geneBank.contains(current) && !seen.contains(current)) neighbors.add(current);
            gene.setCharAt(i, character);
        }

        return neighbors;
    }
}

// 3rd attempt: 15/18 test cases

class Solution {

    LinkedList<String> geneBank = new LinkedList<>();

    LinkedList<String> nucleotides = new LinkedList<>(Arrays.asList("A", "T", "G", "C"));

    String goal;

    HashSet<String> seen = new HashSet<>();

    public int minMutation(String startGene, String endGene, String[] bank) {

        goal = endGene;

        geneBank = new LinkedList(Arrays.asList(bank));

        if(!geneBank.contains(goal)) return -1;

        Queue<String> queue = new LinkedList<>();

        queue.add(startGene);
        seen.add(startGene);

        int steps = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                String current = queue.remove();

                if(current.equals(endGene)) return steps;

                List<String> near = neighbors(new StringBuilder(current));

                queue.addAll(near);

            }

            steps++;
        }
        
        return -1;
    }

    public List<String> neighbors(StringBuilder gene)
    {
        List<String> ans = new LinkedList<>();

        for(int i = 0; i < gene.length(); i++)
        {
            ans.addAll(change(gene, i));
        }

        return ans;
    }

    public List<String> change(StringBuilder gene, int i)
    {

        List<String> neighbors = new LinkedList<>();

        char character = gene.charAt(i);

        for(String nucleotide: nucleotides)
        {
            char nucleo = nucleotide.charAt(0);

            if(nucleo == character)
            {
                System.out.println(character);
                continue;
            }

            gene.setCharAt(i, nucleo);
            String current = gene.toString();
            if(geneBank.contains(current) && !seen.contains(current)) neighbors.add(current);
            gene.setCharAt(i, character);
        }

        return neighbors;
    }
}

// 4th attempt: 18/18 test cases passed

// Upper limit on the number of steps:

/*
 * Runtime
64ms
Beats12.76%
 */

class Solution {

    HashSet<String> geneBank = new HashSet<>();

    List<String> nucleotides = new ArrayList<>(Arrays.asList("A", "T", "G", "C"));

    String goal;

    HashSet<String> seen = new HashSet<>();

    public int minMutation(String startGene, String endGene, String[] bank) {

        goal = endGene;

        geneBank = new HashSet(Arrays.asList(bank));

        if(!geneBank.contains(goal)) return -1;

        Queue<String> queue = new LinkedList<>();

        queue.add(startGene);
        seen.add(startGene);

        int steps = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                String current = queue.remove();

                if(current.equals(endGene)) return steps;

                List<String> near = neighbors(new StringBuilder(current));

                queue.addAll(near);

            }

            steps++;

            if(steps >= 10000) return -1;
        }
        
        return -1;
    }

    public List<String> neighbors(StringBuilder gene)
    {
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < gene.length(); i++)
        {
            ans.addAll(change(gene, i));
        }

        return ans;
    }

    public List<String> change(StringBuilder gene, int i)
    {

        List<String> neighbors = new ArrayList<>();

        char character = gene.charAt(i);

        for(String nucleotide: nucleotides)
        {
            char nucleo = nucleotide.charAt(0);

            if(nucleo == character)
            {
                // System.out.println(character);
                continue;
            }

            gene.setCharAt(i, nucleo);
            String current = gene.toString();
            if(geneBank.contains(current) && !seen.contains(current)) neighbors.add(current);
            gene.setCharAt(i, character);
        }

        return neighbors;
    }
}

/*
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

    For example, "AACCGGTT" --> "AACCGGTA" is one mutation.

There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

Example 1:

Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1

Example 2:

Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2

Constraints:

    0 <= bank.length <= 10
    startGene.length == endGene.length == bank[i].length == 8
    startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].


 */

// Leetcode solution:

class Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {

        if(startGene.equals(endGene)) return 0;

        Set<String> bankSet = new HashSet<>();

        for(String b: bank)
        {
            bankSet.add(b);
        }

        char[] charSet = new char[]{'A', 'T', 'G', 'C'};
        int level = 0;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(startGene);
        visited.add(startGene);

        while(!queue.isEmpty())
        {
            int size = queue.size();

            while(size-- > 0)
            {
                String curr = queue.poll();

                if(curr.equals(endGene)) return level;

                char[] currArray = curr.toCharArray();

                for(int i = 0; i < currArray.length; i++)
                {
                    char old = currArray[i];

                    for(char c: charSet)
                    {
                        currArray[i] = c;
                        String next = new String(currArray);

                        if(!visited.contains(next) && bankSet.contains(next))
                        {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    currArray[i] = old;

                }
            }

            level++;
        }

        return -1;
        
    }

    
}