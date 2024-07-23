// Level: Hard. 503: IPO

// Leetcode solution:

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;

        int[][] projects = new int[n][2];

        for(int i = 0; i < n; i++)
        {
            projects[i] = new int[]{capital[i], profits[i]};
        }

        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        int i = 0;

        for(int j = 0; j < k; j++)
        {
            while(i < n && projects[i][0] <= w)
            {
                heap.add(projects[i][1]);
                i++;
            }

            if(heap.isEmpty()) return w;

            w += heap.remove();
        }

        return w;
    }

}


// Attempt 1: 32/35 tests passed!

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        int currCap = w;

        int count = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for(int i = 0; i < profits.length; i++)
        {
            if(capital[i] <= w)
            {
                if(profits[i] > 0)
                {
                    maxHeap.add(profits[i]);
                    profits[i] = Integer.MIN_VALUE;
                }
            }
        }

        while(count < k)
        {
            if(maxHeap.peek() == null) break;

            int maximum = maxHeap.poll();

            w += maximum;

            maxHeap = recharge(w, maxHeap, profits, capital);

            count++;
        }

        return w;
    }

    public PriorityQueue<Integer> recharge(int currCap, PriorityQueue<Integer> maxHeap, int[] profits, int[] capital)
    {

        for(int i = 0; i < capital.length; i++)
        {
            if(capital[i] <= currCap)
            {
                if(profits[i] > 0)
                {
                    maxHeap.add(profits[i]);
                    profits[i] = Integer.MIN_VALUE;
                }
            }
        }

        return maxHeap;
    }
}
