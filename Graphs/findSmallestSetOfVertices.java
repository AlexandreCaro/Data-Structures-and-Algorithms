// Level: medium, 1557: Minimum Number of Vertices to reach all nodes

/*
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.

Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.

Notice that you can return the vertices in any order.
 */

class Solution {

    Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] indegrees = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            graph.put(i, new ArrayList<Integer>());
        }

        for(List<Integer> edge: edges)
        {
            int from = edge.get(0);
            int to = edge.get(1);

            indegrees[to]+=1;

            graph.get(from).add(to);
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
        {
            if(min > indegrees[i])
            {
                min = indegrees[i];
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();

        for(int j = 0; j < n; j++)
        {
            if(min == indegrees[j]) ans.add(j);
        }

        return ans;
    }

    
}

// LeetCode solution

public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

    int[] indegrees = new int[n];
    
    for(List<Integer> edge: edges)
    {
        indegrees[edge.get(1)]++;
    }

    ArrayList<Integer> ans = new ArrayList<Integer>();

    for(int i = 0; i < n; i++)
    {
        if(indegrees[i] == 0) ans.add(i);
    }

    return ans;
}