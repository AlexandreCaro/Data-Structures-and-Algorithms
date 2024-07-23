public void postorderDfs(Node node)
{
    if(node == null) return;

    postorderDfs(node.left);
    postorderDfs(node.right);

    System.out.println(node.val);

    return;
}