// Level: Medium. 1302: Deepest Leaves Sum.

// My Solution: BFS

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

    LinkedList<TreeNode> queue = new LinkedList<>();

    public int deepestLeavesSum(TreeNode root) {
        
        queue.add(root);

        int depth = 1;

        int maxDepth = 0;

        int currSum = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();

            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();

                if(maxDepth < depth) maxDepth = depth;

                if(maxDepth == depth)
                {
                    currSum += node.val;
                }

                if(node.left != null)
                {
                    queue.add(node.left);
                }

                if(node.right != null)
                {
                    queue.add(node.right);
                }

            }

            if(queue.size() == 0) return currSum;

            currSum = 0;

            depth++;
        }

        return currSum;
    }
}

/*
 * Given the root of a binary tree, return the sum of values of its deepest leaves.

Example 1:

Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    1 <= Node.val <= 100


 */


 // Alternative solution:

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

    LinkedList<TreeNode> queue = new LinkedList<>();

    public int deepestLeavesSum(TreeNode root) {
        
        if(root == null) return 0;

        int[] somme = new int[1];

        int n = height(root);

        nthLevelSum(root, n, somme);

        return somme[0];
    }

    public int height(TreeNode root)
    {
        if(root == null) return 0;

        return 1+ Math.max(height(root.left), height(root.right));
    }

    public void nthLevelSum(TreeNode root, int level, int[] sum)
    {
        if(root == null) return;
        if(level==1)
        {
            sum[0] += root.val;
            return;
        }

        nthLevelSum(root.left, level-1, sum);
        nthLevelSum(root.right, level-1, sum);
    }
}