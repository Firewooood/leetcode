package LinkedList;

public class RemoveElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = head;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                // 1. 要删除的节点是头节点
                if (cur == head) {
                    head = cur.next;
                } else { //
                    pre.next = cur.next;
                    cur = cur.next;
                    continue;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveElement r1 = new RemoveElement();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(1, l3);
        ListNode l5 = new ListNode(6, l4);

        ListNode cur = r1.removeElements(l5, 2);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
