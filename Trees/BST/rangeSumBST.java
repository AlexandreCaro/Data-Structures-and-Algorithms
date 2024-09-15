// Level: Easy. 938: Range Sum of BST

/*
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

Example 1:

Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

 

Constraints:

    The number of nodes in the tree is in the range [1, 2 * 104].
    1 <= Node.val <= 105
    1 <= low <= high <= 105
    All Node.val are unique.


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

    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {

        dfs(root, low, high);

        return sum;
        
    }

    public void dfs(TreeNode node, int low, int high)
    {
        if(node == null) return;

        if(node.val >= low && node.val <= high)
        {
            sum += node.val;
        }

        dfs(node.left, low, high);
        dfs(node.right, low, high);
    
    }
}

// Optimization:

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

    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {

        dfs(root, low, high);

        return sum;
        
    }

    public void dfs(TreeNode node, int low, int high)
    {
        if(node == null) return;

        if(node.val >= low && node.val <= high)
        {
            sum += node.val;
        }

        if(node.val <= low)
        {
            dfs(node.right, low, high);
        }

        else if(node.val >= high)
        {
            dfs(node.left, low, high);
        }
        else
        {
            dfs(node.left, low, high);
            dfs(node.right, low, high);
        }
        
    
    }
}

// Leetcode solution:

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

    public int rangeSumBST(TreeNode root, int low, int high) {

        if(root == null) return 0;

        int ans = 0;

        if(low <= root.val && root.val <= high)
        {
            ans += root.val;
        }

        if(low < root.val)
        {
            ans += rangeSumBST(root.left, low, high);
        }

        if(root.val < high)
        {
            ans += rangeSumBST(root.right, low, high);
        }

        return ans;
        
    }
}

// Less efficient: stack implementation

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

    public int rangeSumBST(TreeNode root, int low, int high) {

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        int sum = 0;

        while(!stack.isEmpty())
        {

            TreeNode node = stack.pop();

            if(low <= node.val && node.val <= high)
            {
                sum += node.val;
            }

            if(node.left != null && low < node.val)
            {
                stack.push(node.left);
            }

            if(node.right != null && node.val < high)
            {
                stack.push(node.right);
            }

        }

        return sum;
        
    }
}



