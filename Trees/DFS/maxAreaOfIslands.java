// Level: Medium. 695: Max Area of Islands

// My solution: 657/728 test cases passed

class Solution {

    int[][] neighbors = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    boolean[][] seen;

    int[][] globalGrid;

    int m, n;

    int maxSize = 0;

    public int maxAreaOfIsland(int[][] grid) {

        globalGrid = grid;

        m = grid.length;

        n = grid[0].length;

        seen = new boolean[m][n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {

                Point current = new Point(i, j, globalGrid[i][j]);

                if(!seen[i][j] && isValid(i, j))
                {
                    seen[i][j] = true;

                    if(1 > maxSize) maxSize = 1;
                    
                    dfs(new Point(i, j, globalGrid[i][j]), 1);
                
                }

                seen[i][j] = true;
            }
        }

        return maxSize;

    }

    public void dfs(Point current, int size)
    {
        System.out.println("HERE" + size);

        for(Point neighbor: neighbors(current))
        {
            if(!seen[neighbor.x][neighbor.y])
            {
                seen[neighbor.x][neighbor.y] = true;

                size++;
                if(size > maxSize) maxSize = size;

                dfs(neighbor, size);
            }
        }
    }

    public List<Point> neighbors(Point point)
    {
        List<Point> liste = new LinkedList<Point>();

        for(int[] neighbor: neighbors)
        {
            int newX = point.x + neighbor[0];
            int newY = point.y + neighbor[1];

            if(isValid(newX, newY) && !seen[newX][newY])
            {

                Point neigh = new Point(newX, newY, globalGrid[newX][newY]);

                liste.add(neigh);
            }
        }

        return liste;
    }

    public boolean isValid(int x, int y)
    {
        if(0 <= x && x < m && 0 <= y && y < n && globalGrid[x][y] == 1) return true;

        return false;
    }
}

class Point
{
    int x;
    int y;
    int value;

    Point(int x, int y, int value)
    {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

// 2nd solution: all test cases passed

/*
 * Runtime
4ms
Beats14.84%
 */

 class Solution {

    int[][] neighbors = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    boolean[][] seen;

    int[][] globalGrid;

    int m, n;

    int maxSize = 0;

    public int maxAreaOfIsland(int[][] grid) {

        globalGrid = grid;

        m = grid.length;

        n = grid[0].length;

        seen = new boolean[m][n];

        int size = 0;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {

                if(!seen[i][j] && isValid(i, j))
                {                    
                    size = dfs(new Point(i, j, globalGrid[i][j]));

                    maxSize = Math.max(maxSize, size);
                
                }

                seen[i][j] = true;
            }
        }

        return maxSize;

    }

    public int dfs(Point current)
    {

        if(!isValid(current.x, current.y) || seen[current.x][current.y]) return 0;

        seen[current.x][current.y] = true;
        int size = 1;

        for(int[] neighbor: neighbors)
        {
            int newX = current.x + neighbor[0];
            int newY = current.y + neighbor[1];

            size += dfs(new Point(newX, newY, isValid(newX, newY) ? globalGrid[newX][newY] : 0));
        }

        return size;
    }

    public boolean isValid(int x, int y)
    {
        if(0 <= x && x < m && 0 <= y && y < n && globalGrid[x][y] == 1) return true;

        return false;
    }
}

class Point
{
    int x;
    int y;
    int value;

    Point(int x, int y, int value)
    {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

/*
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:

Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    grid[i][j] is either 0 or 1.


 */