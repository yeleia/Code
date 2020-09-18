package september;

/**
 * @author ：yl
 * @description：二叉树展为链表
 * @date ：2020/9/17 7:23
 */
public class Flatten {
    public static void flatten(TreeNode node){
        if (node == null){
            return;
        }
        flatten(node.left);
        flatten(node.right);
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        node.right = left;
        TreeNode tempNode = node;
        while (tempNode.right != null){
            tempNode = tempNode.right;
        }
        tempNode.right = right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(6);
        flatten(treeNode);
        System.out.println(treeNode);
    }
}
