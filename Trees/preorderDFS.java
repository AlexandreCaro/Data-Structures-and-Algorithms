public void preorderDFS(Node node)
{
    if(node == null) return;

    System.out.println(node.val);
    preorderDFS(node.left);
    preorderDFS(node.right);

    return;
}