// Level: Medium. 973. K Closest Points to Origin

// My Solution:

/*
 * Runtime
155ms
Beats5.04%
 */

class Solution {

    PriorityQueue<Point> minHeap;

    public int[][] kClosest(int[][] points, int k) {

        minHeap = new PriorityQueue<Point>((a, b) -> Double.compare(a.norm, b.norm));

        for(int[] point: points)
        {
            Point current = new Point(point[0], point[1], calculateDistance(point[0], point[1]));
            minHeap.add(current);
        }

        int remain = k;

        List<Point> near = new LinkedList<Point>();

        while(remain > 0)
        {
            Point current = minHeap.poll();
            near.add(current);

            remain--;
        }

        int[][] ans = new int[near.size()][];

        for(int i = 0; i < near.size(); i++)
        {
            Point point = near.get(i);
            ans[i] = new int[]{point.x, point.y};
        }

        return ans;
        
    }

    public double calculateDistance(int x, int y)
    {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}

class Point
{
    int x;
    int y;
    double norm;

    Point(int x, int y, double norm)
    {
        this.x = x;
        this.y = y;
        this.norm = norm;
    }
}

/*
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Example 1:

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.

Constraints:

    1 <= k <= points.length <= 104
    -104 <= xi, yi <= 104


 */