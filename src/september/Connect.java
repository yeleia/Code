package september;

/**
 * @author ：yl
 * @description：填充每个节点的下一个右侧节点指针
 * @date ：2020/9/16 22:49
 */
public class Connect {
    public static Node connect(Node root) {
        if (root == null){
            return root;
        }
        connectNode(root.left,root.right);
        return root;
    }
    public static void connectNode(Node node1,Node node2){
        if (node1 == null || node2 ==null){
            return;
        }
        node1.next = node2;
        connectNode(node1.left,node1.right);
        connectNode(node2.left,node2.right);
        connectNode(node1.right,node2.left);
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        connect(node);
        System.out.println(node);
    }
}
