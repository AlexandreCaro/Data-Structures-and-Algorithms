// Level: medium. 2352: Equal row and column pairs

/*
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 

Example 1:

Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]

Example 2:

Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]

 

Constraints:

    n == grid.length == grid[i].length
    1 <= n <= 200
 */

// My solution

class Solution {

    HashMap<String, Integer> rows = new HashMap<>();

    HashMap<String, Integer> cols = new HashMap<>();

    int n;

    public int equalPairs(int[][] grid) {

        n = grid.length;

        for(int i = 0; i < n; i++)
        {
            StringBuilder row = new StringBuilder();

            StringBuilder col = new StringBuilder();

            for(int j = 0; j < n; j++)
            {
                row.append(grid[i][j]).append(',');
                col.append(grid[j][i]).append(',');
            }

            String newRow = row.toString();
            String newCol = col.toString();

            rows.put(newRow, rows.getOrDefault(newRow, 0) + 1);
            cols.put(newCol, cols.getOrDefault(newCol, 0) + 1);
        }

        int count = 0;

        for(String row: rows.keySet())
        {
            if(cols.containsKey(row))
            {
                System.out.println(row + " " + rows.get(row)); 
                count += (rows.get(row) * cols.get(row));
            }
        }

        return count;
        
    }
}