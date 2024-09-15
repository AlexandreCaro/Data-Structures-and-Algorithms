// Medium: 1448. Count Good Nodes in Binary Tree

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
    public int goodNodes(TreeNode root) {

        if(root == null) return 0;

        return dfs(root, Integer.MIN_VALUE);
        
    }

    public int dfs(TreeNode node, int max_so_far)
    {
        if(node == null) return 0;

        int left = dfs(node.left, Math.max(max_so_far, node.val));
        int right = dfs(node.right, Math.max(max_so_far, node.val));

        int ans = left + right;

        if(node.val  >= max_so_far) ans += 1;

        return ans;
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
    int maxSoFar;

    Pair(TreeNode node, int maxSoFar)
    {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }
 }

class Solution {
    public int goodNodes(TreeNode root) {

        if(root == null) return 0;

        Stack<Pair> stack = new Stack<Pair>();

        stack.push(new Pair(root, Integer.MIN_VALUE));

        int ans = 0;

        while(!stack.isEmpty())
        {
            Pair pair = stack.pop();

            TreeNode node = pair.node;

            int maxSoFar = pair.maxSoFar;

            if(node.val >= maxSoFar) ans+=1;

            if(node.left != null) stack.push(new Pair(node.left, Math.max(maxSoFar, node.val)));

            if(node.right != null) stack.push(new Pair(node.right, Math.max(maxSoFar, node.val)));
        }

        return ans;
    }

}