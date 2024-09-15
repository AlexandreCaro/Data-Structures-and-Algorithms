// Level: Medium. 56. Merge Intervals

// My Solution: 20/ 171 test cases passed

class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> interval = new LinkedList<>();

        boolean first = false;

        for(int i = 0; i < intervals.length; i++)
        {

            if(i == 0)
            {
                int currEnd = intervals[0][1];
                int nextStart = intervals[1][0];

                if(currEnd >= nextStart)
                {
                    int start = intervals[0][0];
                    int end = intervals[1][1];

                    interval.add(new int[]{start, Math.max(end, currEnd)});

                    first = true;
                }
                else
                {
                    int start = intervals[0][0];
                    int end = intervals[0][1];

                    interval.add(new int[]{start, end});
                }
            }
            else
            {
                if(first == true)
                {
                    first = false;
                    continue;
                }
                int currEnd = intervals[i-1][1];
                int nextStart = intervals[i][0];

                if(currEnd >= nextStart)
                {
                    int start = intervals[i-1][0];
                    int end = intervals[i][1];

                    interval.add(new int[]{start, Math.max(end, currEnd)});
                }
                else
                {
                    int start = intervals[i][0];
                    int end = intervals[i][1];

                    interval.add(new int[]{start, Math.max(end, currEnd)});
                }
            }
            
        }

        int[][] inter = new int[interval.size()][];

        for(int i = 0; i < interval.size(); i++)
        {
            inter[i] = new int[interval.get(i).length];

            inter[i][0] = interval.get(i)[0];

            inter[i][1] = interval.get(i)[1];
        }

        return inter;
        
    }
}

// 2nd attempt

import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new LinkedList<>();

        int[] currentInterval = intervals[0];

        merged.add(currentInterval);

        for(int[] interval: intervals)
        {
            int currentEnd = currentInterval[1];

            int nextStart = interval[0];
            int nextEnd = interval[1];

            if(currentEnd >= nextStart)
            {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }
            else
            {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);    
        
    }
}