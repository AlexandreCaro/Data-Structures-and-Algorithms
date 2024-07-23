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

 /* Level: Easy
  * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.
  */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;

        boolean status = dfs(root, 0, targetSum);

        return status;
        
    }

    public boolean dfs(TreeNode node, int curr, int targetSum)
    {
        if(node == null) return false;

        if(node.left == null && node.right == null)
        {
            return curr + node.val == targetSum;
        }

        curr += node.val;

        boolean left = dfs(node.left, curr, targetSum);
        boolean right = dfs(node.right, curr, targetSum);

        return left || right;
    }
}

// Version itérative:

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

 class Pair
 {
     TreeNode node;
     int curr;
 
     Pair(TreeNode node, int curr)
     {
         this.node = node;
         this.curr = curr;
     }
 }
 
 class Solution {
     public boolean hasPathSum(TreeNode root, int targetSum) {
 
         if(root == null) return false;
 
         Stack<Pair> stack = new Stack<Pair>();
 
 
         stack.push(new Pair(root, 0));
 
         while(!stack.empty())
         {
             Pair pair = stack.pop();
 
             TreeNode node = pair.node;
             int curr = pair.curr;
 
             if(node.left == null && node.right == null)
             {
                 if(node.val + curr == targetSum) return true;
             }
 
             if(node.left != null) stack.push(new Pair(node.left, curr+node.val));
             
             if(node.right != null) stack.push(new Pair(node.right, curr+node.val));
         }
 
         return false;
         
     }
 
     
 }