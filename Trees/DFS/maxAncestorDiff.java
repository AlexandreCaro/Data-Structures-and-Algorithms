// Level: Medium. 1026: Maximum difference between node and ancestor.

// My solution: 27/30 test cases passed. Time Limit Exceeded

import java.util.Collections;

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

    HashMap<TreeNode, ArrayList<Integer>> tree = new HashMap<>();

    public int maxAncestorDiff(TreeNode root) {

        dfs(root);

        int maxDiff = 0;

        for(TreeNode node: tree.keySet())
        {
            maxDiff = Math.max(maxDiff, getMax(tree.get(node)));
        }

        return maxDiff;

    }

    public int getMax(ArrayList<Integer> liste)
    {
        return Collections.max(liste);
    }

    public void dfs(TreeNode node)
    {
        if(node == null) return;

        constructTree(node);

        dfs(node.left);
        dfs(node.right);
    }

    public void constructTree(TreeNode root)
    {
        constructTree(root, root);
    }

    public void constructTree(TreeNode node, TreeNode root)
    {
        if(node == null) return;

        if(!tree.containsKey(root)) tree.put(root, new ArrayList<>());

        tree.get(root).add(Math.abs(node.val - root.val));

        if(node.left != null)
        {
            constructTree(node.left, root);
        }

        if(node.right != null)
        {
            constructTree(node.right, root);
        }
    }
}

// 2nd attempt: use a hahsmap that maps to integer instead of an ArrayList

// 30/30 test casses passed

/*
 * Runtime
309ms
Beats5.16%
 */

import java.util.Collections;

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

    HashMap<TreeNode, Integer> tree = new HashMap<>();

    public int maxAncestorDiff(TreeNode root) {

        dfs(root);

        int maxDiff = 0;

        for(TreeNode node: tree.keySet())
        {
            maxDiff = Math.max(maxDiff, tree.get(node));
        }

        return maxDiff;

    }

    public void dfs(TreeNode node)
    {
        if(node == null) return;

        constructTree(node);

        dfs(node.left);
        dfs(node.right);
    }

    public void constructTree(TreeNode root)
    {
        constructTree(root, root);
    }

    public void constructTree(TreeNode node, TreeNode root)
    {
        if(node == null) return;

        if(!tree.containsKey(root)) tree.put(root, 0);

        if(tree.get(root) < Math.abs(node.val - root.val))
        {
            tree.put(root, Math.abs(node.val - root.val));
        }

        if(node.left != null)
        {
            constructTree(node.left, root);
        }

        if(node.right != null)
        {
            constructTree(node.right, root);
        }
    }
}