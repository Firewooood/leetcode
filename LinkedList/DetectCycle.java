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

    public ListNode detectCycle1(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        int step = 0;
        while ((slow == dummyNode) || slow != null && fast != null && slow != fast) {
            step++;
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else {
                return null;
            }
        }
        if (fast == null || slow == null)
            return null; // 若遍历至null, 说明链表无环
        // 此时fast == null
        slow = dummyNode;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(-4);
        ListNode l4 = new ListNode(0, l5);
        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(3, l3);
        l5.next = l3;
        DetectCycle d1 = new DetectCycle();
        ListNode res = d1.detectCycle1(l2);
        System.out.println(res.val);
    }
}
