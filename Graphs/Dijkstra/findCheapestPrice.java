// Level: Medium. 787: Cheapest flights within k stops.

// My Solution: 

// Attempt 1: 25/56 test cases passed

class Solution {

    HashMap<Integer, List<Trip>> graph = new HashMap<>();

    PriorityQueue<Trip> minHeap;

    int[] distances;

    int n;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        this.n = n;

        distances = new int[n];

        minHeap = new PriorityQueue<Trip>((a, b) -> a.weight - b.weight);

        constructGraph(flights);

        Arrays.fill(distances, Integer.MAX_VALUE);

        minHeap.add(new Trip(src, 0, 0));

        while(!minHeap.isEmpty())
        {
            Trip current = minHeap.poll();

            int curr_dist = current.weight, node = current.node, stops = current.stops;

            if(stops == k+1) break;

            if(curr_dist > distances[node]) continue;

            List<Trip> neighbours = graph.get(node);

            for(Trip trip: neighbours)
            {
                int dist = curr_dist + trip.weight;

                if(dist < distances[trip.node])
                {
                    distances[trip.node] = dist;
                    minHeap.add(new Trip(trip.node, trip.weight, trip.stops+1));
                }
            }
        }

        if(distances[dst] == Integer.MAX_VALUE) return -1;

        return distances[dst];
    }

    public void constructGraph(int[][] edges)
    {
        for(int i = 0; i < n; i++)
        {
            graph.put(i, new LinkedList<Trip>());
        }

        for(int[] edge: edges)
        {
            graph.get(edge[0]).add(new Trip(edge[1], edge[2], 0));
        }
    }
}

class Trip
{
    int node;
    int weight;
    int stops;

    Trip(int node, int weight, int stops)
    {
        this.node = node;
        this.weight = weight;
        this.stops = stops;
    }
}

// Attempt 2: 41/56 test cases passed

class Solution {

    HashMap<Integer, List<Trip>> graph = new HashMap<>();

    PriorityQueue<Trip> minHeap;

    int[] distances;

    int n;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        this.n = n;

        distances = new int[n];

        minHeap = new PriorityQueue<Trip>((a, b) -> a.weight - b.weight);

        constructGraph(flights);

        Arrays.fill(distances, Integer.MAX_VALUE);

        minHeap.add(new Trip(src, 0, -1));

        while(!minHeap.isEmpty())
        {
            Trip current = minHeap.poll();

            int curr_dist = current.weight, node = current.node, stops = current.stops;

            if(node == dst) return curr_dist;

            if(stops == k) continue;

            if(curr_dist > distances[node]) continue;

            if(!graph.containsKey(node)) continue;

            List<Trip> neighbours = graph.get(node);

            for(Trip trip: neighbours)
            {
                int dist = curr_dist + trip.weight;

                if(dist < distances[trip.node])
                {
                    distances[trip.node] = dist;
                    minHeap.add(new Trip(trip.node, dist, trip.stops+1));
                }
            }
        }

        if(distances[dst] == Integer.MAX_VALUE) return -1;

        return distances[dst];
    }

    public void constructGraph(int[][] edges)
    {
        for(int i = 0; i < n; i++)
        {
            graph.put(i, new LinkedList<Trip>());
        }

        for(int[] edge: edges)
        {
            graph.get(edge[0]).add(new Trip(edge[1], edge[2], -1));
        }
    }
}

class Trip
{
    int node;
    int weight;
    int stops;

    Trip(int node, int weight, int stops)
    {
        this.node = node;
        this.weight = weight;
        this.stops = stops;
    }
}

/*
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Example 1:

Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

Example 2:

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

Example 3:

Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

Constraints:

    1 <= n <= 100
    0 <= flights.length <= (n * (n - 1) / 2)
    flights[i].length == 3
    0 <= fromi, toi < n
    fromi != toi
    1 <= pricei <= 104
    There will not be any multiple flights between two cities.
    0 <= src, dst, k < n
    src != dst


 */

// 3rd attempt: 44/ 56 test cases passed

class Solution {

    HashMap<Integer, List<Trip>> graph = new HashMap<>();

    PriorityQueue<Trip> minHeap;

    int[] distances;

    int n;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        this.n = n;

        distances = new int[n];

        minHeap = new PriorityQueue<Trip>((a, b) -> a.weight - b.weight);

        constructGraph(flights);

        Arrays.fill(distances, Integer.MAX_VALUE);

        minHeap.add(new Trip(src, 0, 0));

        while(!minHeap.isEmpty())
        {
            Trip current = minHeap.poll();

            int curr_dist = current.weight, node = current.node, stops = current.stops;

            if(node == dst) return curr_dist;

            if(stops >= k+1) continue;

            if(curr_dist > distances[node]) continue;

            List<Trip> neighbours = graph.get(node);

            for(Trip trip: neighbours)
            {
                int dist = curr_dist + trip.weight;

                if(dist < distances[trip.node])
                {
                    distances[trip.node] = dist;
                    int newStops = stops+1;

                    if(newStops <= k+1) minHeap.add(new Trip(trip.node, dist, newStops));
                }
            }
        }

        if(distances[dst] == Integer.MAX_VALUE) return -1;

        return distances[dst];
    }

    public void constructGraph(int[][] edges)
    {
        for(int i = 0; i < n; i++)
        {
            graph.put(i, new LinkedList<Trip>());
        }

        for(int[] edge: edges)
        {
            graph.get(edge[0]).add(new Trip(edge[1], edge[2], 0));
        }
    }
}

class Trip
{
    int node;
    int weight;
    int stops;

    Trip(int node, int weight, int stops)
    {
        this.node = node;
        this.weight = weight;
        this.stops = stops;
    }
}

// Solution:

class Solution {

    HashMap<Integer, List<int[]>> graph = new HashMap<>();

    PriorityQueue<int[]> minHeap;

    int[] distances;

    int n;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(int[] flight: flights)
        {
            graph.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, k+1});

        Map<Integer, Integer> visited = new HashMap<>();

        while(!pq.isEmpty())
        {
            int[] current = pq.poll();
            int node = current[0], cost = current[1], stops = current[2];

            if(node == dst) return cost;

            if(stops > 0)
            {
                int maxStops = visited.getOrDefault(node, -1);

                if(stops > maxStops)
                {
                    visited.put(node, stops);

                    List<int[]> neighbors = graph.getOrDefault(node, Collections.emptyList());

                    for(int[] neighbor: neighbors)
                    {
                        pq.offer(new int[]{neighbor[0], cost + neighbor[1], stops-1});
                    }
                }
            }
        }

        return -1;

    }
}

class Trip
{
    int node;
    int weight;
    int stops;

    Trip(int node, int weight, int stops)
    {
        this.node = node;
        this.weight = weight;
        this.stops = stops;
    }
}

// BFS-Dijkstra:

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] flight: flights)
        {
            adj.computeIfAbsent(flight[0], value -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        int[] shortDist = new int[n];

        Arrays.fill(shortDist, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{src, 0});

        int stops = 0;

        while(stops <= k && !queue.isEmpty())
        {
            int qLen = queue.size();

            while(qLen-- > 0)
            {
                int[] temp = queue.poll();

                int node = temp[0];
                int distance = temp[1];

                if(!adj.containsKey(node)) continue;

                for(int[] e: adj.get(node))
                {
                    int neighbor = e[0];
                    int cost = e[1];

                    if(cost + distance >= shortDist[neighbor]) continue;

                    shortDist[neighbor] = cost + distance;
                    queue.offer(new int[]{neighbor, shortDist[neighbor]});
                }
            }

            stops++;
        }

        return (shortDist[dst] == Integer.MAX_VALUE) ? -1 : shortDist[dst];
        
    }
}

