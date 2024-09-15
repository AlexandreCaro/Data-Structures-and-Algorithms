// Level: medium. 1129: Shortest Path with Alternating colors.

// My Solution:

class Solution {

    HashMap<Integer, List<Integer>> redGraph = new HashMap<>();
    HashMap<Integer, List<Integer>> blueGraph = new HashMap<>();

    int[] destinations;

    boolean[][] seen;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        destinations = new int[n];

        seen = new boolean[n][2];

        for(int i = 0; i < redEdges.length; i++)
        {
            int from = redEdges[i][0], to = redEdges[i][1];

            if(!redGraph.containsKey(from)) redGraph.put(from, new ArrayList<>());

            redGraph.get(from).add(to);
        }

        for(int j = 0; j < blueEdges.length; j++)
        {
            int from = blueEdges[j][0], to = blueEdges[j][1];

            if(!blueGraph.containsKey(from)) blueGraph.put(from, new ArrayList<>());

            blueGraph.get(from).add(to);
        }

        for(int i = 0; i < n; i++)
        {
            bfs(i);
        }

        return destinations;
        
    }

    public void bfs(int destination)
    {
        seen = new boolean[destinations.length][2];

        LinkedList<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0));
        queue.add(new State(0, 1, 0));

        seen[0][0] = true;
        seen[0][1] = true;

        while(!queue.isEmpty())
        {
            State state = queue.remove();

            if(state.node == destination) 
            {
                destinations[destination] = state.steps;
                return;
            }

            LinkedList<State> neighbors = retrieveNeighbors(state);

            for(State neighbor: neighbors)
            {
                if(!seen[neighbor.node][neighbor.color])
                {
                    seen[neighbor.node][neighbor.color] = true;
                    queue.add(new State(neighbor.node, neighbor.color, neighbor.steps));
                }
            }
        }

        destinations[destination] = -1;
    }

    public LinkedList<State> retrieveNeighbors(State current)
    {

        LinkedList<State> neighbors = new LinkedList<>();

        int node = current.node, color = current.color, steps = current.steps;

        if(color == 0)
        {
            List<Integer> blueEdges = blueGraph.get(node);

            if(blueEdges == null) return new LinkedList<>();

            for(Integer next: blueEdges)
            {
                if(!seen[next][1]) neighbors.add(new State(next, 1, steps+1));
            }
        }
        else if(color == 1)
        {
            List<Integer> redEdges = redGraph.get(node);

            if(redEdges == null) return new LinkedList<>();

            for(Integer next: redEdges)
            {
                if(!seen[next][0]) neighbors.add(new State(next, 0, steps+1));
            }
        }

        return neighbors;
    }
}

class State
{
    int node;
    int color;
    int steps;

    State(int node, int color, int steps)
    {
        this.node = node;
        this.color = color;
        this.steps = steps;
    }
}

/*
 * You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.

You are given two arrays redEdges and blueEdges where:

    redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
    blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.

Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.

Example 1:

Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
Output: [0,1,-1]

Example 2:

Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
Output: [0,1,-1]

Constraints:

    1 <= n <= 100
    0 <= redEdges.length, blueEdges.length <= 400
    redEdges[i].length == blueEdges[j].length == 2
    0 <= ai, bi, uj, vj < n


 */

// Leetcode solution:

class Solution {

    int RED = 0;
    int BLUE = 1;

    Map<Integer, Map<Integer, List<Integer>>> graph = new HashMap<>();

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        graph.put(RED, new HashMap<>());
        graph.put(BLUE, new HashMap<>());

        addToGraph(RED, redEdges, n);
        addToGraph(BLUE, blueEdges, n);

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, RED, 0));
        queue.add(new State(0, BLUE, 0));

        boolean[][] seen = new boolean[n][2];
        seen[0][RED] = true;
        seen[0][BLUE] = true;

        while(!queue.isEmpty())
        {
            State state = queue.remove();
            int node = state.node, color = state.color, steps = state.steps;

            ans[node] = Math.min(ans[node], steps);

            for(int neighbor: graph.get(color).get(node))
            {
                if(!seen[neighbor][1-color])
                {
                    seen[neighbor][1-color] = true;
                    queue.add(new State(neighbor, 1-color, steps+1));
                }
            }
        }

        for(int i = 0; i < n; i++)
        {
            if(ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }

        return ans;

    }

    public void addToGraph(int color, int[][] edges, int n)
    {
        for(int i = 0; i < n; i++)
        {
            graph.get(color).put(i, new ArrayList<>());
        }

        for(int[] edge: edges)
        {
            int x = edge[0], y = edge[1];
            graph.get(color).get(x).add(y);
        }
    }

    
    
}

class State
{
    int node;
    int color;
    int steps;

    State(int node, int color, int steps)
    {
        this.node = node;
        this.color = color;
        this.steps = steps;
    }
}