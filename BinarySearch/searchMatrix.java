// Level: Medium. 74. Search a 2D Matrix

/*
 * You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;

        int n = matrix[0].length;

        int total = m*n;

        int left = 0;

        int right = total - 1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;

            int row = Math.floorDiv(mid, n);

            int col = mid % n;

            int num = matrix[row][col];

            if(num == target) return true;

            if(num < target) left = mid+1;

            if(num > target) right = mid - 1;


        }

        return false;
    }
}