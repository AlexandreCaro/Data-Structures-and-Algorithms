public void printAllNodes(TreeNode root)
{
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while(!queue.isEmpty())
    {
        int nodesInCurrentLevel = queue.size();

        for(int i = 0; i < nodesInCurrentLevel; i++)
        {
            TreeNode node = queue.remove();

            System.out.println(node.val);

            if(node.left != null) queue.add(node.left);

            if(node.right != null) queue.add(node.right);
        }
    }
}