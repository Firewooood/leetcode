package LinkedList;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode dumny = new ListNode(-1, head); // 在head节点前添加一个dumny节点
        ListNode pre = dumny;
        ListNode after = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null) {
                // 若节点个数为奇数
                pre.next = cur;
                break;
            }
            after = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur; // 反转节点
            cur.next = after;
            pre = cur;
            cur = after;

        }
        return dumny.next;
    }

    public static void main(String[] args) {
        SwapPairs s1 = new SwapPairs();
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode tmp = s1.swapPairs(l1);
        while (tmp != null) {
            System.out.print(tmp.val + "  ");
            tmp = tmp.next;
        }
    }
}
