public class Example {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        /*
        The following code builds a tree that looks like:
            0
          /   \
         1     2
        */
        
        TreeNode root = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        
        root.left = one;
        root.right = two;
        
        System.out.println(root.left.val); // Prints 1
        System.out.println(root.right.val); // Prints 2
    }
}