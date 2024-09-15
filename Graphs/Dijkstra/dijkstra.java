public class Dijkstra
{
    int[] distTo;
    int[] edgeTo;

    PriorityQueue<VertexDistance> minHeap;

    public int[] dijkstraSP(Graph g)
    {
        int[] distTo = new int[g.vertex];
        int[] edgeTo = new int[g.vertex];

        minHeap = new PriorityQueue<VertexDistance>((a, b) -> a.distance - b.distance);

        int s = 0;

        for(int v = 0; v < g.vertex; v++)
        {
            distTo[v] = Integer.MAX_VALUE;
        }

        distTo[0] = 0;

        minHeap.add(new VertexDistance(0, 0));

        while(!pq.isEmpty())
        {
            node, curr_dist = heap.pop();

            if(curr_dist > distances[node])
            {
                continue;
            }

            for(Edge e: g.get(node))
            {
                int w = e.to();
                int weight = e.weight();

                int dist = distTo[v] + weight;

                if(distTo[w] > dist)
                {
                    distTo[w] = dist;
                    edgeTo[w] = v;

                    minHeap.add(new VertexDistance(w, dist));
                }
            }
        }

        return distTo;


    }

}

class Edge
{
    int from;
    int to;
    int weight;

    Edge(int from, int to, int weight)
    {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

class VertexDistance
{
    int vertex;
    int distance;

    VertexDistance(int vertex, int distance)
    {
        this.vertex = vertex;
        this.distance = distance;
    }
}

