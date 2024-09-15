public void inorderDFS(Node node)
{
    if(node == null) return;

    inorderDFS(node.left);
    System.out.println(node.val);
    inorderDFS(node.right);

    return;
}