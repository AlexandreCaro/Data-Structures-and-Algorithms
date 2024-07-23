class Solution {

    public void dfs(int node, HashMap<Integer, List<Integer>> graph, Set<Integer> seen)
    {
        for(int neighbor: graph.get(node))
        {
            if(!seen.contains(neighbor))
            {
                seen.add(neighbor);
                dfs(neighbor, graph, seen);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(isConnected[i][j] == 1)
                {
                    if(!graph.containsKey(i)) graph.put(i, new ArrayList<>());

                    if(!graph.containsKey(j)) graph.put(j, new ArrayList<>());

                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        Set<Integer> seen = new HashSet<Integer>();

        int ans = 0;

        for(int i = 0; i < n; i++)
        {
            if(!seen.contains(i))
            {
                ans+=1;
                seen.add(i);
                dfs(i, graph, seen);
            }
        }

        return ans;
    }

    public void iterativeDFS(int node, HashSet<Integer> seen, HashMap<Integer> graph)
    {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(node);

        while(!stack.empty())
        {
            int cur = stack.pop();

            for(int neighbor: graph.get(cur))
            {
                if(!seen.containsKey(neighbor))
                {
                    seen.add(neighbor);
                    stack.push(neighbor);
                }
            }

        }
    }
}

