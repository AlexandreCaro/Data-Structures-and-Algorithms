// Level: Hard. 52. N-Queens 2

class Solution {

    int cols = 0;

    int diagonals = 0;

    int anti_diagonals = 0;

    private int size;

    public int totalNQueens(int n) {

        size = n;

        return backtrack(0, 0, 0, 0);
        
    }

    public int backtrack(int row, int diagonals, int antiDiagonals, int cols)
    {
        if(row == size) return 1;

        int solutions = 0;

        for(int col = 0; col < size; col++)
        {

            int currCol = 1 << col;
            int currDiagonal = 1 << (row - col + size);
            int currAntiDiagonal = 1 << (row + col);

            if((cols & currCol) != 0 || (diagonals & currDiagonal) != 0 || (anti_diagonals & currAntiDiagonal) != 0)
            {
                continue;
            }

            cols = cols ^ currCol;
            diagonals = diagonals ^ currDiagonal;
            anti_diagonals = anti_diagonals ^ currAntiDiagonal;

            solutions += backtrack(row+1, diagonals, antiDiagonals, cols);

            cols = cols ^ currCol;
            diagonals = diagonals ^ currDiagonal;
            anti_diagonals = anti_diagonals ^ currAntiDiagonal;
        }

        return solutions;
    }
}

/*
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:

Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:

Input: n = 1
Output: 1

Constraints:

    1 <= n <= 9


 */