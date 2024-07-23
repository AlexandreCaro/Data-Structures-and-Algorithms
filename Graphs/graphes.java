public Map<Integer, List<Integer>> buildGraph(int[][] edges)
{
    for(int[] edge: edges)
    {
        int x = edge[0], y = edge[1];

        if(!graph.containsKey(x))
        {
            graph.put(x, new ArrayList<>());
        }

        graph.get(x).add(y);

        // Undirected:

        if(!graph.containsKey(y))
        {
            graph.put(y, new ArrayList<>());
        }

        graph.get(y).add(x);
    }
}