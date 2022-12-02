package LinkedList;

public class ListNodeMethod {
    public static ListNode parse(int[] head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < head.length; i++) {
            ListNode node = new ListNode(head[i]);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}
