// Level: Medium. 863: All Nodes distance K in binary tree

/*
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

Example 2:

Input: root = [1], target = 1, k = 3
Output: []


 */

 // My Solution:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    HashMap<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> seen = new HashSet<Integer>();

    Set<Integer> queueSeen = new HashSet<Integer>();

    Queue<TreeNode> queue = new LinkedList<TreeNode>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        dfs(root);

        iterateUsingForEach(parent);

        queue.add(target);

        queueSeen.add(target.val);

        printQueue(queue);

        int distance = 0;

        while(!queue.isEmpty() && distance < k)
        {
            int currLength = queue.size();

            printQueue(queue);

            for(int i = 0; i < currLength; i++)
            {
                TreeNode current = queue.remove();

                if(current.left != null && !queueSeen.contains(current.left.val))
                {
                    queue.add(current.left);
                    queueSeen.add(current.left.val);
                }

                if(current.right != null && !queueSeen.contains(current.right.val))
                {
                    queueSeen.add(current.right.val);
                    queue.add(current.right);
                }

                TreeNode parentNode = parent.get(current.val);

                if(parentNode != null && !queueSeen.contains(parentNode.val))
                {
                    queueSeen.add(parentNode.val);
                    queue.add(parent.get(current.val));
                }
            }

            if(distance == k) return convertQueue(queue);

            distance++;
        }

        return convertQueue(queue);
    }

    public List<Integer> convertQueue(Queue<TreeNode> queue)
    {
        Iterator<TreeNode> iter = queue.iterator();

        List<Integer> liste = new LinkedList<Integer>();

        for(TreeNode node: queue)
        {
            liste.add(node.val);
        }

        for(TreeNode item: queue)
        {
            System.out.println(item);
        }

        return liste;
    }

    public void iterateUsingForEach(Map<Integer, TreeNode> map)
    {
        for(Map.Entry<Integer, TreeNode> entry: map.entrySet())
        {
            Integer key = entry.getKey();
            TreeNode value = entry.getValue();
            System.out.println("Key = " + key + " , value = " + value.val);
        }
    }

    public void printQueue(Queue<TreeNode> queue)
    {
        for(TreeNode node: queue)
        {
            System.out.println(node.val);
        }
    }

    public void dfs(TreeNode node)
    {

        if(node == null) return;

        if(node.left != null && !seen.contains(node.left.val))
        {
            parent.put(node.left.val, node);
            dfs(node.left);
            seen.add(node.val);
        }

        if(node.right != null && !seen.contains(node.right.val))
        {
            parent.put(node.right.val, node);
            seen.add(node.val);
            dfs(node.right);
        }
        
    }
}

// Leetcode Solution:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<TreeNode, TreeNode> parents = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();

        Set<TreeNode> seen = new HashSet<>();

        queue.add(target);
        seen.add(target);

        int distance = 0;

        while(!queue.isEmpty() && distance < k)
        {
            int currLength = queue.size();

            for(int i = 0; i < currLength; i++)
            {
                TreeNode node = queue.remove();

                for(TreeNode neighbor: new TreeNode[]{node.left, node.right, parents.get(node)})
                {
                    if(neighbor != null && !seen.contains(neighbor))
                    {
                        seen.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }

            distance++;
        }

        List<Integer> ans = new ArrayList<>();
        for(TreeNode node: queue)
        {
            ans.add(node.val);
        }

        return ans;


    }

    public void dfs(TreeNode node, TreeNode parent)
    {

        if(node == null) return;

        parents.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
        
    }
}