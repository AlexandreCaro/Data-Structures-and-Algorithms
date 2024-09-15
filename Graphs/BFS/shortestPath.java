// Level: Hard. 1293: Shortest Path in a Grid with Obstacles Elimination

/*
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

Example 1:

Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).

Example 2:

Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 40
    1 <= k <= m * n
    grid[i][j] is either 0 or 1.

 */

// My Solution: 23/55 test cases passed

class Solution {

    int m, n;

    int[][] globalGrid;

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, 1}};

    Set<State> seen = new HashSet<>();

    public int shortestPath(int[][] grid, int k) {

        m = grid.length;

        n = grid[0].length;

        globalGrid = grid;

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0, k));

        while(!queue.isEmpty())
        {
            State state = queue.remove();

            if(state.x == m - 1 && state.y == n - 1) return state.steps;

            LinkedList<State> neighbors = retrieveNeighbors(state);

            for(State nextState: neighbors)
            {
                if(!seen.contains(nextState))
                {
                    seen.add(nextState);
                    queue.add(nextState);
                }
            }

        }

        return -1;
        
        
    }

    public LinkedList<State> retrieveNeighbors(State state)
    {
        LinkedList<State> liste = new LinkedList<>();

        for(int[] dir: directions)
        {
            int nextRow = state.x + dir[0];
            int nextCol = state.y + dir[1];

            if(isValid(nextRow, nextCol))
            {
                
                if(globalGrid[nextRow][nextCol] == 1 && state.remain > 0)
                {
                    State nextState = new State(nextRow, nextCol, state.steps+1, state.remain-1);

                    if(!seen.contains(nextState)) liste.add(nextState);
                }
                else if(globalGrid[nextRow][nextCol] == 0)
                {
                    State nextState = new State(nextRow, nextCol, state.steps+1, state.remain);

                    if(!seen.contains(nextState)) liste.add(new State(nextRow, nextCol, state.steps+1, state.remain));
                }
            }
        }

        return liste;
    }

    public boolean isValid(int row, int col)
    {
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}

class State
{
    int x;
    int y;
    int steps;
    int remain;

    State(int x, int y, int steps, int remain)
    {
        this.x = x;
        this.y = y;
        this.steps = steps;
        this.remain = remain;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;

        if(o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        return this.x == state.x && this.y == state.y && this.steps == state.steps && this.remain == state.remain;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y, steps, remain);
    }
}

// boolean[][] seen: 53/55 test cases passed

class Solution {

    int m, n;

    int[][] globalGrid;

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    boolean[][][] seen;

    public int shortestPath(int[][] grid, int k) {

        m = grid.length;

        n = grid[0].length;

        seen = new boolean[m][n][k+1];

        globalGrid = grid;

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0, k));
        seen[0][0][k] = true;

        while(!queue.isEmpty())
        {
            State state = queue.remove();

            if(state.x == m - 1 && state.y == n - 1) return state.steps;

            LinkedList<State> neighbors = retrieveNeighbors(state);

            for(State nextState: neighbors)
            {
                if(!seen[nextState.x][nextState.y][nextState.remain])
                {
                    seen[nextState.x][nextState.y][nextState.remain] = true;
                    queue.add(nextState);
                }
            }

        }

        return -1;
        
        
    }

    public LinkedList<State> retrieveNeighbors(State state)
    {
        LinkedList<State> liste = new LinkedList<>();

        for(int[] dir: directions)
        {
            int nextRow = state.x + dir[0];
            int nextCol = state.y + dir[1];

            if(isValid(nextRow, nextCol))
            {
                
                if(globalGrid[nextRow][nextCol] == 1 && state.remain > 0)
                {
                    State nextState = new State(nextRow, nextCol, state.steps+1, state.remain-1);

                    if(!seen[nextState.x][nextState.y][nextState.remain]) liste.add(nextState);
                }
                else if(globalGrid[nextRow][nextCol] == 0)
                {
                    State nextState = new State(nextRow, nextCol, state.steps+1, state.remain);

                    if(!seen[nextState.x][nextState.y][nextState.remain]) liste.add(new State(nextRow, nextCol, state.steps+1, state.remain));
                }
            }
        }

        return liste;
    }

    public boolean isValid(int row, int col)
    {
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}

class State
{
    int x;
    int y;
    int steps;
    int remain;

    State(int x, int y, int steps, int remain)
    {
        this.x = x;
        this.y = y;
        this.steps = steps;
        this.remain = remain;
    }

}