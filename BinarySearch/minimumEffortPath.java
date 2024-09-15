class Solution {

    boolean[][] seen;

    int[][] neighbourhood = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    int[][] newHeights;

    int n;

    int m;

    public int minimumEffortPath(int[][] heights) {

        m = heights.length;

        n = heights[0].length;

        newHeights = heights;

        seen = new boolean[m][n];

        int left = 0;

        int right = determineMaximum(heights);

        Point begin = new Point(0, 0, newHeights[0][0]);

        Point end = new Point(m-1, n-1, newHeights[m-1][n-1]);

        // System.out.println(left + " " + right);

        while(left < right)
        {
            int mid = left + (right - left) / 2;

            System.out.println(left + " " + right);

            boolean possible = dfs(begin, mid);

            seen = new boolean[m][n];

            if(possible)
            {
                right = mid;
            }
            else
            {
                left = mid+1;
            }

        }

        return left;
        
        
    }

    public int determineMaximum(int[][] heights)
    {

        int max = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(max < heights[i][j]) max = heights[i][j];
            }
        }

        return max;
    }

    public boolean dfs(Point node, int currEffort)
    {
        LinkedList<Point> neighbors = retrieveNeighbors(node);

        for(Point neighbor: neighbors)
        {
            if(!seen[neighbor.x][neighbor.y] && difference(node, neighbor) <= currEffort)
            {
                if(seen[m-1][n-1] == true) return true;

                seen[neighbor.x][neighbor.y] = true;
                dfs(neighbor, currEffort);

                
            }
        }

        return false;
    }

    public int difference(Point currNode, Point newNode)
    {
        return Math.abs(currNode.height - newNode.height);
    }

    public LinkedList<Point> retrieveNeighbors(Point node)
    {
        LinkedList<Point> neighbors = new LinkedList<Point>();

        for(int[] neighbor: neighbourhood)
        {
            int currRow = node.x + neighbor[0];
            int currCol = node.y + neighbor[1];

            if(isValid(currRow, currCol))
            {
                neighbors.add(new Point(currRow, currCol, newHeights[currRow][currCol]));
            }
        }

        return neighbors;
    }

    public boolean isValid(int currRow, int currCol)
    {
        return 0 <= currRow && currRow < m && 0 <= currCol && currCol < n;
    }
}

class Point
{
    int x;
    int y;
    int height;

    Point(int x, int y, int height)
    {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}

// Leetcode + mine:

class Solution {

    int[][] neighbourhood = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

    int n;

    int m;

    public int minimumEffortPath(int[][] heights) {

        m = heights.length;

        n = heights[0].length;

        int left = 0;

        int right = determineMaximum(heights);

        Point begin = new Point(0, 0, heights[0][0]);

        Point end = new Point(m-1, n-1, heights[m-1][n-1]);

        // System.out.println(left + " " + right);

        while(left <= right)
        {
            int mid = left + (right - left) / 2;

            System.out.println(left + " " + right);

            boolean possible = check(mid, heights);

            if(possible)
            {
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }

        }

        return left;
        
        
    }

    public int determineMaximum(int[][] heights)
    {

        int max = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(max < heights[i][j]) max = heights[i][j];
            }
        }

        return max;
    }

    public boolean check(int effort, int[][] heights)
    {
        boolean[][] seen = new boolean[m][n];

        Stack<Point> stack = new Stack<>();

        seen[0][0] = true;

        stack.push(new Point(0, 0, heights[0][0]));

        while(!stack.isEmpty())
        {
            Point current = stack.pop();

            int currRow = current.x, currCol = current.y;

            if(currRow == m-1 && currCol == n-1) return true;

            for(int[] neighbor: neighbourhood)
            {
                int nextRow = currRow + neighbor[0], nextCol = currCol + neighbor[1];
                if(isValid(nextRow, nextCol) && !seen[nextRow][nextCol])
                {
                    if(Math.abs(heights[nextRow][nextCol] - heights[currRow][currCol]) <= effort)
                    {
                        seen[nextRow][nextCol] = true;
                        stack.push(new Point(nextRow, nextCol, heights[nextRow][nextCol]));
                    }
                }
            }
        }

        return false;
    }

    public boolean isValid(int currRow, int currCol)
    {
        return 0 <= currRow && currRow < m && 0 <= currCol && currCol < n;
    }
}

class Point
{
    int x;
    int y;
    int height;

    Point(int x, int y, int height)
    {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}