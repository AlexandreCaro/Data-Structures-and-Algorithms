// Level: Medium. 79. Word Search

// Leetcode:

class Solution {

    // Set<Point> seen = new HashSet<>();

    boolean[][] seen;

    int m;

    int n;

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    String target;

    public boolean exist(char[][] board, String word) {

        target = word;

        m = board.length;

        n = board[0].length;

        seen = new boolean[m][n];

        for(int row = 0; row < m; row++)
        {
            for(int col = 0; col < n; col++)
            {
                if(board[row][col] == target.charAt(0))
                {
                    seen[row][col] = true;
                    if(backtrack(row, col, 1, board))
                    {
                        return true;
                    }
                    seen[row][col] = false;
                }

            }
        }

        return false;

    }

    public boolean backtrack(int row, int col, int index, char[][] board)
    {
        if(target.length() == index) return true;

        for(int[] dir: directions)
        {
            int nextRow = row + dir[0], nextCol = col + dir[1];

            if(isValid(nextRow, nextCol) && !seen[nextRow][nextCol])
            {
                if(board[nextRow][nextCol] == target.charAt(index))
                {
                    seen[nextRow][nextCol] = true;
                    if(backtrack(nextRow, nextCol, index+1, board)) return true;
                    seen[nextRow][nextCol] = false;
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

// First attempt

class Solution {

    Set<Point> seen = new HashSet<>();

    char[][] globalBoard;

    int[][] neighbourhood = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    StringBuilder currentWord = new StringBuilder();

    public boolean exist(char[][] board, String word) {

        globalBoard = board;
        
    }

    public void dfs(Point current, String word, int index)
    {
        LinkedList<Point> neighbors = retrieveNeighbors(current, word, index);

        if(neighbors.isEmpty())
        {
            seen.remove(current);
            currentWord.deleteCharAt(currentWord.length() - 1);
            continue;
        }

        for(Point neighbor: neighbors)
        {
            if(!seen.contains(neighbor))
            {
                seen.add(neighbor);
                dfs(neighbor, word, index+1);
            }
        }
    }

    public LinkedkList<Point> retrieveNeighbors(Point current, String word, int index)
    {
        LinkedList<Point> neighbors = new LinkedList<>();

        for(int[] neighbor: neighbourhood)
        {
            int nextRow = current.x + neighbor[0];
            int nextCol = current.y + neighbor[1];

            if(isValid(nextRow, nextCol))
            {
                Point nextPoint = new Point(nextRow, nextCol, globalBoard[nextRow][nextCol]);

                if(word.charAt(index+1) == globalBoard[nextRow][nextCol] && !seen.contains(nextPoint))
                {
                    currentWord.append(globalBoard[nextRow][nextCol]);
                    neighbors.add(nextPoint);
                } 
            }
        }

        return neighbors;
    }

    public boolean isValid(int currRow, currCol)
    {

        int m = globalBoard.length;

        int n = globalBoard[0].length;

        return 0 <= currRow && currRow < m && 0 <= currCol && currCol < n;

    }
}

class Point
{
    int x;
    int y;
    char letter;

    Point(int x, int y, char letter)
    {
        this.x = x;
        this.y = y;
        this.letter = letter;
    }
}

// Second attempt: 65/87 testcases

class Solution {

    // Set<Point> seen = new HashSet<>();

    boolean[][] seen;

    char[][] globalBoard;

    int[][] neighbourhood = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    StringBuilder currentWord = new StringBuilder();

    public boolean exist(char[][] board, String word) {

        globalBoard = board;

        int m = globalBoard.length;

        int n = globalBoard[0].length;

        // if(m == 1 && n == 1) return true;

        seen = new boolean[m][n];

        LinkedList<Point> path = new LinkedList<>();

        // boolean possible = dfs(path, new Point(0,0,globalBoard[0][0]), word, 0);

        // if(possible) return true;

        boolean possible;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                possible = dfs(path, new Point(i, j, globalBoard[i][j]), word, 0);

                System.out.println(i + " " + j);

                if(possible) return true;
            }
        }

        return false;

    }

    public boolean dfs(LinkedList<Point> path, Point current, String word, int index)
    {
        if(index == word.length()) return true;

        if(current.letter != word.charAt(index)) return false;

        seen[current.x][current.y] = true;
        currentWord.append(current.letter);
        path.add(current);

        for(int[] dir: neighbourhood)
        {
            int nextRow = current.x + dir[0];
            int nextCol = current.y + dir[1];

            if(isValid(nextRow, nextCol) && !seen[nextRow][nextCol])
            {
                Point next = new Point(nextRow, nextCol, globalBoard[nextRow][nextCol]);
                if(dfs(path, next, word, index+1)) return true;
            }
        }

        seen[current.x][current.y] = false;
        currentWord.setLength(currentWord.length()-1);
        path.removeLast();

        return false;
    }

    public LinkedList<Point> retrieveNeighbors(Point current, String word, int index)
    {
        LinkedList<Point> neighbors = new LinkedList<>();

        for(int[] neighbor: neighbourhood)
        {
            int nextRow = current.x + neighbor[0];
            int nextCol = current.y + neighbor[1];

            if(isValid(nextRow, nextCol))
            {
                Point nextPoint = new Point(nextRow, nextCol, globalBoard[nextRow][nextCol]);

                if(word.charAt(index+1) == globalBoard[nextRow][nextCol] && !seen[nextRow][nextCol])
                {
                    seen[nextRow][nextCol] = true;
                    neighbors.add(nextPoint);
                } 
            }
        }

        return neighbors;
    }

    public boolean isValid(int currRow, int currCol)
    {

        int m = globalBoard.length;

        int n = globalBoard[0].length;

        return 0 <= currRow && currRow < m && 0 <= currCol && currCol < n;

    }
}

class Point
{
    int x;
    int y;
    char letter;

    Point(int x, int y, char letter)
    {
        this.x = x;
        this.y = y;
        this.letter = letter;
    }
}