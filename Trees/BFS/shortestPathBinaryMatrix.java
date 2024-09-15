// Level: Medium. 1091. Shortest Path in Binary Matrix

/*
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

The length of a clear path is the number of visited cells of this path.

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 2

 */

class Solution {

    Queue<Point> queue = new LinkedList<Point>();
    boolean[][] seen;
    
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid[0][0] == 1) return -1;

        int n = grid.length;

        seen = new boolean[n][n];

        queue.add(new Point(0, 0, true));

        int steps = 0;

        while(!queue.isEmpty())
        {
            int currentLength = queue.size();

            steps += 1;

            for(int i = 0; i < currentLength; i++)
            {
                Point current = queue.remove();

                if(current.x == n-1 && current.y == n-1 && current.valid == true) return steps;

                if(!seen[current.x][current.y])
                {
                    validDirections(current, grid);
                    seen[current.x][current.y] = true;
                }

            }
        }

        return -1;
        
    }

    public void validDirections(Point current, int[][] grid)
    {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for(int[] direction: directions)
        {
            int currRow = current.x + direction[0];
            int currCol = current.y + direction[1];

            if(isValid(currRow, currCol, grid) && grid[currRow][currCol] == 0 && !seen[current.x][current.y])
            {
                Point newCurrent = new Point(currRow, currCol, true);
                queue.add(newCurrent);
            }
        }
    }

    public boolean isValid(int currRow, int currCol, int[][] grid)
    {
        int n = grid.length;

        return 0 <= currRow && currRow < n && 0 <= currCol && currCol < n;
    }
}

class Point
{
    int x;
    int y;
    boolean valid;
    boolean seen;

    Point(int x, int y, boolean valid)
    {
        this.x = x;
        this.y = y;
        this.valid = valid;
        this.seen = false;
    }
}