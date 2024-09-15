// Level: Easy. 530: Minimum Absolute Difference in BST

/*
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 * 
Example 1:

Input: root = [4,2,6,1,3]
Output: 1

Example 2:

Input: root = [1,0,48,null,null,12,49]
Output: 1

 

Constraints:

    The number of nodes in the tree is in the range [2, 104].
    0 <= Node.val <= 105

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

    ArrayList<Integer> values = new ArrayList<Integer>();

    public int getMinimumDifference(TreeNode root) {

        inOrderDFS(root);

        int minimum = Integer.MAX_VALUE;

        for(int i = 1; i < values.size(); i++)
        {
            int previous = values.get(i-1);
            int current = values.get(i);

            int difference = Math.abs(current - previous);

            if(minimum > difference) minimum = difference;
        }

        return minimum;
        
    }

    public void inOrderDFS(TreeNode node)
    {
        if(node == null) return;

        inOrderDFS(node.left);
        values.add(node.val);
        inOrderDFS(node.right);
    }
}

// Iterative version:

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

    ArrayList<Integer> values = new ArrayList<Integer>();

    public int getMinimumDifference(TreeNode root) {

        ArrayList<Integer> values = iterativeinOrder(root);

        int minimum = Integer.MAX_VALUE;

        for(int i = 1; i < values.size(); i++)
        {
            int previous = values.get(i-1);
            int current = values.get(i);

            int difference = Math.abs(current - previous);

            if(minimum > difference) minimum = difference;
        }

        return minimum;
        
    }

    public ArrayList<Integer> iterativeinOrder(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack();
        ArrayList<Integer> values = new ArrayList<>();

        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null)
        {
            if(curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            else
            {
                curr = stack.pop();
                values.add(curr.val);
                curr = curr.right;
            }
        }

        return values;
    }
}