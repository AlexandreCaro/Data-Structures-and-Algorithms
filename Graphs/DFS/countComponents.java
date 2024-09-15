// Level: Medium. 323. Number of Connected Components in an undirected graph.

// My Solution:

/*Runtime
8ms
Beats27.47% */

class Solution {

    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    Set<Integer> seen = new HashSet<>();

    int n;

    public int countComponents(int n, int[][] edges) {

        this.n = n;

        constructGraph(edges);

        int count = 0;

        for(int i = 0; i < n; i++)
        {
            if(!seen.contains(i))
            {
                seen.add(i);
                dfs(i);
                count++;
            }
        }

        return count;
        
    }

    public void dfs(int i)
    {
        if(graph.get(i) == null) return;

        for(int num: graph.get(i))
        {
            if(!seen.contains(num))
            {
                seen.add(num);
                dfs(num);
            }
        }
    }

    public void constructGraph(int[][] edges)
    {
        for(int i = 0; i < n; i++)
        {
            graph.put(i, new LinkedList<>());
        }

        for(int[] edge: edges)
        {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
            graph.get(to).add(from);
        }
    }
}

/*
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

Example 1:

Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2

Example 2:

Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1

Constraints:

    1 <= n <= 2000
    1 <= edges.length <= 5000
    edges[i].length == 2
    0 <= ai <= bi < n
    ai != bi
    There are no repeated edges.


 */