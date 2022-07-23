package LinkedList;

class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head.next == null || head.next.next == null)
            return null;
        ListNode A = head;
        ListNode B = head;
        int num = 0;
        // 大步小步
        while (B != null && A != null) {
            A = A.next;
            B = B.next.next;
            num++;
            if (A == B)
                break;

        }
        System.out.println(num);
        if (A != B)
            return null;
        A = head;
        while (num-- > 1) {
            A = A.next;
        }
        B = head;
        while (A.next != B) {
            A = A.next;
            B = B.next;
        }
        return B;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(-4);
        ListNode l4 = new ListNode(0, l5);
        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(3, l3);
        l5.next = l3;
        DetectCycle d1 = new DetectCycle();
        ListNode res = d1.detectCycle(l2);
        System.out.println(res.val);
    }
}
