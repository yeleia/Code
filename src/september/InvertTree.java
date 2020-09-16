package september;



/**
 * @author ：yl
 * @description：反转二叉树
 * @date ：2020/9/16 21:17
 */
public class InvertTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        invertTree(treeNode);
        System.out.println(treeNode);
    }
}
