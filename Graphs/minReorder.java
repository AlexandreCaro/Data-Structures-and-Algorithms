// Level: medium. 1466: Reorder routes to make all paths lead to the city zero

/*
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.

 */

class Solution {

    Set<String> roads = new HashSet<String>();
    Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
    Set<Integer> seen = new HashSet<Integer>();

    public int minReorder(int n, int[][] connections) {

        for(int i = 0; i < n; i++)
        {
            graph.put(i, new ArrayList<Integer>());
        }

        for(int[] connection: connections)
        {
            int x = connection[0];
            int y = connection[1];

            graph.get(x).add(y);
            graph.get(y).add(x);

            roads.add(convertToHash(x, y));
        }

        seen.add(0);

        return dfs(0);
        
    }

    public int dfs(int node)
    {
        int ans = 0;

        for(int neighbor: graph.get(node))
        {
            if(!seen.contains(neighbor))
            {

                if(roads.contains(convertToHash(node, neighbor)))
                {
                    ans++;
                }

                seen.add(neighbor);

                ans += dfs(neighbor);
            }
        }

        return ans;
    }

    public String convertToHash(int from, int to)
    {
        return String.valueOf(from) + "," + String.valueOf(to);
    }

    // Verion itérative:

    public int minReorderIterative(int n, int[][] connections) {

        for(int i = 0; i < n; i++)
        {
            graph.put(i, new ArrayList<Integer>());
        }

        for(int[] connection: connections)
        {
            int x = connection[0];
            int y = connection[1];

            graph.get(x).add(y);
            graph.get(y).add(x);

            roads.add(convertToHash(x, y));
        }

        seen.add(0);

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);

        int ans = 0;

        while(!stack.empty())
        {
            int node = stack.pop();

            for(int neighbor: graph.get(node))
            {
                if(!seen.contains(neighbor))
                {

                    if(roads.contains(convertToHash(node, neighbor)))
                    {
                        ans++;
                    }

                    seen.add(neighbor);

                    stack.push(neighbor);
                }

            }
        }

        return ans;
        
    }
}