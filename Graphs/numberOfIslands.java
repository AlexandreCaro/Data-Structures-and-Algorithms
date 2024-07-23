class Solution {

    int m;
    int n;
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] seen;

    public int numIslands(char[][] grid) {
        
        m = grid.length;
        n = grid[0].length;
        
        seen = new boolean[m][n];
        
        int ans = 0;
        
        for(int row = 0; row < m; row++)
        {
            for(int col = 0; col < n; col++)
            {
                if(grid[row][col] == '1' && !seen[row][col])
                {
                    ans++;
                    seen[row][col] = true;
                    dfs(row, col, grid);
                
                }
            }
        }
        
        return ans;
    }

    public boolean valid(int row, int col, char[][] grid)
    {
        return 0 <= row && row < m && 0 <= col && col < n && grid[row][col] == '1';
    }
    
    public void dfs(int row, int col, char[][] grid)
    {
        
        m = grid.length;
        n = grid[0].length;
        
        for(int[] direction: directions)
        {
            int newX = row + direction[0];
            int newY = col + direction[1];
            
            if(valid(newX, newY, grid) && !seen[newX][newY])
            {
                seen[newX][newY] = true;
                dfs(newX, newY, grid);
            }
        }

    }

    public void iterativeDFS(int startRow, int startCol, char[][] grid)
    {
        
        Stack<Integer> rowStack = new Stack<Integer>();
        Stack<Integer> colStack = new Stack<Integer>();

        rowStack.push(startRow);
        colStack.push(startCol);

        while(!rowStack.empty())
        {
            int curRow = rowStack.pop();
            int curCol = colStack.pop();

            for(int[] direction: directions)
            {
                int nextRow = curRow + direction[0];
                int nextCol = curCol + direction[1];

                if(valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol])
                {
                    seen[nextRow][nextCol] = true;
                    rowStack.push(nextRow);
                    colStack.push(nextCol);
                }
            }
        }

    }
}

