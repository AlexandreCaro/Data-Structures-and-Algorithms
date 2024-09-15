public class LazyPrimMST
{
    boolean[] marked;
    Queue<Edge> mst = new LinkedList<>();
    PriorityQueue<Edge> minHeap;

    public LazyPrimMST(Graph G)
    {
        marked = new boolean[G.vertex];
        minHeap = new PriorityQueue<Edge>((a, b) -> a.weight - b.weight);

        visit(G, 0);

        while(!pq.isEmpty() && mst.size() < G.vertex - 1)
        {
            Edge e = pq.poll();

            int v = e.from;
            int w = e.to;

            if(marked[v] && marked[w]) continue;
            mst.enqueue(e);

            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);
        }

    }

    private void visit(Graph G, int v)
    {
        marked[v] = true;

        for(Edge e : G.adj(v))
        {
            if(!marked[e.to]) pq.add(e);
        }
    }
}