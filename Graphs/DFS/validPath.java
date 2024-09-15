// Level: Easy. Find if Path exists in graph.

class Solution {

    HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();

    HashSet<Integer> seen = new HashSet<>();

    int n;

    boolean effect;

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        n = n;

        constructGraph(edges);

        dfs(source, destination);

        if(effect == true) return effect;

        return false;
        
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

            if(!graph.containsKey(from)) graph.put(from, new LinkedList<>());

            graph.get(from).add(to);
        }
    }

    public void dfs(int source, int destination)
    {
        if(source == destination) effect = true;;

        LinkedList<Integer> neighbours = graph.get(source);

        if(neighbours == null)
        {
            System.out.println("HERE");
            return;
        }

        for(Integer neighbor: graph.get(source))
        {
            if(!seen.contains(neighbor))
            {
                seen.add(neighbor);
                dfs(neighbor, destination);
            }
        }

        return;
    }
}

// 2nd attempt

class Solution {

    HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();

    HashSet<Integer> seen = new HashSet<>();

    int n;

    boolean effect;

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        this.n = n;

        constructGraph(edges);

        dfs(source, destination);

        if(effect == true) return effect;

        return false;
        
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

    public void dfs(int source, int destination)
    {
        if(source == destination)
        {
            effect = true;
            return;
        }

        LinkedList<Integer> neighbours = graph.get(source);

        if(neighbours == null)
        {
            // System.out.println("HERE");
            return;
        }

        for(Integer neighbor: neighbours)
        {
            if(!seen.contains(neighbor))
            {
                seen.add(neighbor);
                dfs(neighbor, destination);
            }
        }

        return;
    }
}

// SOlution: BFS

class Solution {

    HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();

    HashSet<Integer> seen = new HashSet<>();

    int n;

    boolean effect;

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        this.n = n;

        constructGraph(edges);

        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[n];

        queue.add(source);
        seen[source] = true;

        while(!queue.isEmpty())
        {
            int current = queue.remove();

            if(current == destination) return true;

            for(int neighbour: graph.get(current))
            {
                if(!seen[neighbour])
                {
                    seen[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }

        return false;

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
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

Example 1:

Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Example 2:

Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.

Constraints:

    1 <= n <= 2 * 105
    0 <= edges.length <= 2 * 105
    edges[i].length == 2
    0 <= ui, vi <= n - 1
    ui != vi
    0 <= source, destination <= n - 1
    There are no duplicate edges.
    There are no self edges.


 */