package may;



/**
 * @ClassName ReverseList
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 **/
public class ReverseList {
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int data) {
            this.value = data;
        }
    }
    /***
     * @param head
     * @return {@link ListNode}
     * @author yl
     * @date 2021/5/17 21:44
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next;
        ListNode newHead = reverseList(temp);
        temp.next = head;
        head.next = null;
        return newHead;
    }
    public static int num = 0;
    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next ;
        while (head != null){
            num ++;
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static int[] reversePrint(ListNode head){
        ListNode node = reverseList(head);
        if (node == null){
            return new int[0];
        }
        int[] result = new int[num];
        int i = 0;
        while (node != null){
            result[i] = node.value;
            i++;
            node = node.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
       /* ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);*/
        /*node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;*/
        node1.next = null;
        int[] result = reversePrint(node1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
   public static void print(ListNode node){
       System.out.println(node.value);
       if (node.next != null){
           print(node.next);
       }
   }
}
