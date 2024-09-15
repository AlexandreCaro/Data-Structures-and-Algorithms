// Level: Easy. 543: Diameter of Binary Tree.

// First attempt: 101/106 test cases passed. 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

        return returnDepth(root.left, 1) + returnDepth(root.right, 1);
        
    }

    public int returnDepth(TreeNode node, int depth)
    {
        if(node == null) return depth-1;

        int left = returnDepth(node.left, depth+1);
        int right = returnDepth(node.right, depth+1);

        return Math.max(left, right);
    }
}

// 2nd attempt:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        inOrder(root, 0);

        return maxDiameter;
        
    }

    public int returnDepth(TreeNode node, int depth)
    {
        if(node == null) return 0;

        int left = returnDepth(node.left, depth);
        int right = returnDepth(node.right, depth);

        return Math.max(left, right)+1;
    }

    public void inOrder(TreeNode node, int depth)
    {
        if(node == null) return;

        int left = returnDepth(node.left, depth+1);
        int right = returnDepth(node.right, depth+1);

        if(left + right > maxDiameter) maxDiameter = left + right;

        inOrder(node.left, depth+1);
        inOrder(node.right, depth+1);
    }
}

/*
 * Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Example 1:

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:

Input: root = [1,2]
Output: 1

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -100 <= Node.val <= 100


 */

// Other solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        calculateDepth(root);

        return maxDiameter;
        
    }

    public int calculateDepth(TreeNode node)
    {
        if(node == null) return 0;

        int left = calculateDepth(node.left);
        int right = calculateDepth(node.right);

        maxDiameter = Math.max(maxDiameter, left+right);

        return Math.max(left, right) + 1;
    }
}