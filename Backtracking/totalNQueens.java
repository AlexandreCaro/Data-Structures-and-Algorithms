// Level: Hard. 53: N-Queens 2

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

 */

class Solution {

    Set<Integer> cols = new HashSet<>();

    Set<Integer> diagonals = new HashSet<>();

    Set<Integer> anti_diagonals = new HashSet<>();

    public int totalNQueens(int n) {

        return backtrack(0, n);
        
    }

    public int backtrack(int row, int n)
    {
        if(row == n) return 1;

        int solutions = 0;

        for(int col = 0; col < n; col++)
        {
            int curr_diagonal = row - col;
            int curr_anti_diagonal = row + col;

            if(cols.contains(col) || diagonals.contains(curr_diagonal) || anti_diagonals.contains(curr_anti_diagonal))
            {
                continue;
            }

            cols.add(col);
            diagonals.add(curr_diagonal);
            anti_diagonals.add(curr_anti_diagonal);

            solutions += backtrack(row+1, n);

            cols.remove(col);
            diagonals.remove(curr_diagonal);
            anti_diagonals.remove(curr_anti_diagonal);
        }

        return solutions;
    }
}