/*
 * Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

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
    public int maxDepth(TreeNode root) {
        
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
        
    }
  
}

// Itérative:

class Pair
{
   public TreeNode node;
   public int depth;

   Pair(TreeNode node, int depth)
   {
       this.node = node;
       this.depth = depth;
   } 
}

class Solution {
   public int maxDepth(TreeNode root) {

    if (root == null) {
        return 0;
    }
    
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(root, 1));
    int ans = 0;
    
    while (!stack.empty()) {
        Pair pair = stack.pop();
        TreeNode node = pair.node;
        int depth = pair.depth;
        
        ans = Math.max(ans, depth);
        if (node.left != null) {
            stack.push(new Pair(node.left, depth + 1));
        }
        if (node.right != null) {
            stack.push(new Pair(node.right, depth + 1));
        }
    }

    return ans;
       
   }
 
}