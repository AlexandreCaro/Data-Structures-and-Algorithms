// Level: Medium. 1926: Nearest exit from entrance in Maze.

// My Solution.

class Solution {

    LinkedList<Point> queue = new LinkedList<Point>();

    boolean[][] seen;

    int m, n;

    char[][] globalMaze;

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    List<Point> entrances = new LinkedList<Point>();

    public int nearestExit(char[][] maze, int[] entrance) {

        int x = entrance[0];
        int y = entrance[1];

        globalMaze = maze;

        this.m = maze.length;
        this.n = maze[0].length;

        this.seen = new boolean[m][n];

        queue.add(new Point(x, y, 0, maze[x][y]));
        seen[x][y] = true;

        while(!queue.isEmpty())
        {

            Point point = queue.poll();

            List<Point> neighbors = neighbors(point);

            for(Point neighbor: neighbors)
            {
                if(!seen[neighbor.x][neighbor.y])
                {
                    queue.add(neighbor);
                    seen[neighbor.x][neighbor.y] = true;
                }
            }

        }

        int minimum = Integer.MAX_VALUE;

        for(Point enter: entrances)
        {
            if(minimum > enter.distance) minimum = enter.distance;
        }

        return (minimum == Integer.MAX_VALUE) ? -1 : minimum;
        
    }

    public List<Point> neighbors(Point current)
    {

        List<Point> neighbors = new LinkedList<>();

        for(int[] dir: directions)
        {
            int neigh_x = current.x + dir[0];
            int neigh_y = current.y + dir[1];

            if(isValid(neigh_x, neigh_y) && !seen[neigh_x][neigh_y] && globalMaze[neigh_x][neigh_y] == '.')
            {
                if(isFrontier(neigh_x, neigh_y))
                {
                    Point entrance = new Point(neigh_x, neigh_y, current.distance+1, '.');
                    entrances.add(entrance);
                    neighbors.add(entrance);
                }
                else
                {
                    Point neighbor = new Point(neigh_x, neigh_y, current.distance+1, '.');
                    neighbors.add(neighbor);
                }
                
            }

        }

        return neighbors;
    }

    public boolean isFrontier(int x, int y)
    {
        return (x == 0 || x == m -1 || y == 0 || y == n-1) && globalMaze[x][y] == '.';
    }

    public boolean isValid(int x, int y)
    {
        return 0 <= x && x <= m-1 && 0 <= y && y <= n-1;
    }

}

class Point
{
    int x;
    int y;
    int distance;
    boolean blocked;

    Point(int x, int y, int distance, char character)
    {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.blocked = (character == '+' ? true : false);
    }
}

/*
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

Example 1:

Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.

Example 2:

Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.

Example 3:

Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze. 

Constraints:

    maze.length == m
    maze[i].length == n
    1 <= m, n <= 100
    maze[i][j] is either '.' or '+'.
    entrance.length == 2
    0 <= entrancerow < m
    0 <= entrancecol < n
    entrance will always be an empty cell.


 */