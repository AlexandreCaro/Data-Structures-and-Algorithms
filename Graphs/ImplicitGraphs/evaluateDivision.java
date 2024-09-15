// Level: Medium. 399. Evaluate Division

class Solution {

    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        addToGraph(equations, values);

        double[] ans = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++)
        {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);

            ans[i] = traverseGraph(from, to);
        }

        return ans;
    }

    public double traverseGraph(String from, String to)
    {

        HashSet<String> seen = new HashSet<>();

        LinkedList<Pair> queue = new LinkedList<>();

        if(!graph.containsKey(from)) return -1;
        
        seen.add(from);

        queue.add(new Pair(from, 1.0));

        Double value = 1.0;

        while(!queue.isEmpty())
        {
            Pair current = queue.remove();

            String node = current.node;
            Double currVal = current.value;

            if(node.equals(to)) return currVal;

            for(Pair neighbor: neighbors(node, seen))
            {
                if(!seen.contains(neighbor))
                {
                    seen.add(neighbor.node);
                    queue.add(new Pair(neighbor.node, neighbor.value * current.value));
                }
            }

        }

        return -1;
    }

    public List<Pair> neighbors(String node, HashSet<String> seen)
    {
        List<Pair> neighbors = new LinkedList<>();

        HashMap<String, Double> map = graph.get(node);

        if(map == null) return neighbors;

        for(String string: map.keySet())
        {
            if(!seen.contains(string))
            {
                neighbors.add(new Pair(string, map.get(string)));
            }
        }

        return neighbors;
    }

    public void addToGraph(List<List<String>> equations, double[] values)
    {
        for(int i = 0; i < equations.size(); i++)
        {
            List<String> equation = equations.get(i);

            String from = equation.get(0);
            String to = equation.get(1);

            Double value = values[i];

            if(!graph.containsKey(from))
            {
                graph.put(from, new HashMap<String, Double>());
            }

            graph.get(from).put(to, value);

            if(!graph.containsKey(to))
            {
                graph.put(to, new HashMap<String, Double>());
            }

            graph.get(to).put(from, 1/value);
        }
    }
}

class Pair
{
    String node;
    Double value;

    Pair(String node, Double value)
    {
        this.node = node;
        this.value = value;
    }
}

/*
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0

Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]

Constraints:

    1 <= equations.length <= 20
    equations[i].length == 2
    1 <= Ai.length, Bi.length <= 5
    values.length == equations.length
    0.0 < values[i] <= 20.0
    1 <= queries.length <= 20
    queries[i].length == 2
    1 <= Cj.length, Dj.length <= 5
    Ai, Bi, Cj, Dj consist of lower case English letters and digits.


 */

// DFS Solution

class Solution {

    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        addToGraph(equations, values);

        double[] ans = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++)
        {
            ans[i] = answerQuery(queries.get(i).get(0), queries.get(i).get(1));
        }

        return ans;
        
    }

    public double answerQuery(String start, String end)
    {

        if(!graph.containsKey(start)) return -1;

        Set<String> seen = new HashSet<>();
        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(start, 1.0));

        while(!stack.empty())
        {
            Pair current = stack.pop();

            String node = current.node;
            double value = current.value;

            if(node.equals(end)) return value;

            for(String neighbor: graph.get(node).keySet())
            {
                if(!seen.contains(neighbor))
                {
                    seen.add(neighbor);
                    stack.push(new Pair(neighbor, value * graph.get(node).get(neighbor)));
                }
            }
        }

        return -1;

        
    }

    public void addToGraph(List<List<String>> equations, double[] values)
    {
        for(int i = 0; i < equations.size(); i++)
        {
            List<String> equation = equations.get(i);

            String from = equation.get(0);
            String to = equation.get(1);

            Double value = values[i];

            if(!graph.containsKey(from))
            {
                graph.put(from, new HashMap<String, Double>());
            }

            graph.get(from).put(to, value);

            if(!graph.containsKey(to))
            {
                graph.put(to, new HashMap<String, Double>());
            }

            graph.get(to).put(from, 1/value);
        }
    }
}

class Pair
{
    String node;
    Double value;

    Pair(String node, Double value)
    {
        this.node = node;
        this.value = value;
    }
}