// Level: Medium. 98. Validate Binary Search Tree

/*
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left
    subtree
    of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

Example 1:

Input: root = [2,1,3]
Output: true

Example 2:

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1


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
    public boolean isValidBST(TreeNode root) {
        
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean dfs(TreeNode root, long lower, long upper)
    {
        if(root == null) return true;

        if(!(lower < root.val && root.val < upper))
        {
            return false;
        }

        boolean left = dfs(root.left, lower, root.val);
        boolean right = dfs(root.right, root.val, upper);

        return left && right;
    }
}

// Iterative solution:

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
    public boolean isValidBST(TreeNode root) {
        
        // return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);

        Stack<State> stack = new Stack<>();

        stack.push(new State(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while(!stack.isEmpty())
        {
            State state = stack.pop();

            Long small = state.small, large = state.large;

            if(!(small < state.node.val && state.node.val < large)) return false;

            if(state.node.left != null)
            {
                stack.push(new State(state.node.left, small, state.node.val));
            }

            if(state.node.right != null)
            {
                stack.push(new State(state.node.right, state.node.val, large));
            }
        }
        
        return true;
    }
    
}

class State
{
    TreeNode node;
    long small;
    long large;

    State(TreeNode node, long small, long large)
    {
        this.node = node;
        this.small = small;
        this.large = large;
    }
}