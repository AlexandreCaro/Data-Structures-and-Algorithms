class RecentCounter {

    private int counter;
    private LinkedList<Integer> queue;

    public RecentCounter() {
        
        counter = 0;
        queue = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        
        queue.add(t);

        while(!queue.isEmpty() && queue.peek() < t - 3000)
        {
            queue.poll();
        }

        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */