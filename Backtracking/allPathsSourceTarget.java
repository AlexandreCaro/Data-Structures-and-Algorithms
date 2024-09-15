// Level: Medium. 797: All Paths from Source to Target.

// My Solution:

class Solution {

    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    List<List<Integer>> ans = new LinkedList<List<Integer>>();

    Set<Integer> seen = new HashSet<>();

    int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] edges) {
        
        this.n = edges.length;

        constructGraph(edges);

        
        seen.add(0);

        LinkedList begin = new LinkedList<>();

        begin.add(0);

        dfs(0, begin);

        return ans;

    }

    public void dfs(int source, LinkedList<Integer> current)
    {
    
        List<Integer> neighbours = graph.get(source);

        if(source == n-1) ans.add(new LinkedList<>(current));

        for(Integer neighbour: neighbours)
        {
            if(!seen.contains(neighbour))
            {
                seen.add(neighbour);
                current.add(neighbour);

                dfs(neighbour, current);

                seen.remove(neighbour);
                current.remove(neighbour);
            }

            
        }
    }

    public void constructGraph(int[][] edges)
    {
        for(int i = 0; i < n; i++)
        {
            graph.put(i, new LinkedList<Integer>());
        }

        for(int i = 0; i < n; i++)
        {
            for(int edge: edges[i])
            {
                graph.get(i).add(edge);
            }
        }
    }
}

// We can do it also without the set seen.

/*
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

Example 1:

Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Example 2:

Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

Constraints:

    n == graph.length
    2 <= n <= 15
    0 <= graph[i][j] < n
    graph[i][j] != i (i.e., there will be no self-loops).
    All the elements of graph[i] are unique.
    The input graph is guaranteed to be a DAG.


 */