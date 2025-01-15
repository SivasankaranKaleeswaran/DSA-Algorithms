package BinaryTree;

public class RemoveNodeinBST {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.print("Original Tree (Inorder Traversal): ");
        printInOrder(root);
        System.out.println();


        int keyToDelete = 3;
        TreeNode updatedTree = deleteNode(root, keyToDelete);


        System.out.print("Tree After Deletion (Inorder Traversal): ");
        printInOrder(updatedTree);
        System.out.println();

    }

    private static TreeNode deleteNode(TreeNode root, int toDelete) {

        if(root == null) return root;

        TreeNode tmp = root;

        if(root.val == toDelete) return helper(root);

        while(root!=null)
        {
            if(toDelete < root.val)
            {
                if(root.left != null && root.left.val == toDelete) {
                    root.left = helper(root.left);
                    break;
                }

                root= root.left;
            }
            else {

                if(root.right != null && root.right.val == toDelete) {
                    root.right = helper(root.right);
                    break;
                }

                root= root.right;

            }
        }

        return tmp;
    }

    private static TreeNode helper(TreeNode root) {

        if(root.left == null) return root.right;
        if(root.right == null )return root.left;

        TreeNode currRight = root.right;
        TreeNode farRight = getFarRight(root.left);

        farRight.right = currRight;

        return root.left;
    }

    private static TreeNode getFarRight(TreeNode root) {

        while(root.right != null)
        {
            root=root.right;
        }

        return root;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);

        System.out.print(root.val + " ");

        printInOrder(root.right);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}