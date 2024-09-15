// Level: Medium. 743: Network Delay Time.

class Solution {

    HashMap<Integer, List<Pair>> graph = new HashMap<>();

    int n;

    PriorityQueue<Pair> minHeap;

    int[] distances;

    public int networkDelayTime(int[][] times, int n, int k) {

        this.n = n;

        this.distances = new int[n+1];

        this.minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        Arrays.fill(distances, Integer.MAX_VALUE);

        constructGraph(times);

        distances[k] = 0;

        minHeap.add(new Pair(k, 0));

        while(!minHeap.isEmpty())
        {
            Pair current = minHeap.poll();

            int curr_dist = current.weight, node = current.node;

            if(curr_dist > distances[node]) continue;

            List<Pair> neighbours = graph.get(node);

            if(neighbours == null) continue;

            for(Pair pair: neighbours)
            {
                int dist = curr_dist + pair.weight;

                if(dist < distances[pair.node])
                {
                    distances[pair.node] = dist;
                    minHeap.add(new Pair(pair.node, dist));
                }
            }
        }

        int maximum = 0;

        for(int i = 1; i <= n; i++)
        {
            if(distances[i] == 0) continue;

            maximum = Math.max(maximum, distances[i]);

            if(distances[i] == Integer.MAX_VALUE) return -1;
        }

        return maximum;

    }

    public void constructGraph(int[][] edges)
    {
        for(int i = 1; i <= n; i++)
        {
            graph.put(i, new LinkedList<>());
        }

        for(int[] edge: edges)
        {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

    }
}

class Pair
{
    int node;
    int weight;

    Pair(int node, int weight)
    {
        this.node = node;
        this.weight = weight;
    }
}

/*
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1

Constraints:

    1 <= k <= n <= 100
    1 <= times.length <= 6000
    times[i].length == 3
    1 <= ui, vi <= n
    ui != vi
    0 <= wi <= 100
    All the pairs (ui, vi) are unique. (i.e., no multiple edges.)


 */