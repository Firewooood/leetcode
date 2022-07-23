package done;

import java.util.Stack;

public class reversePrint {
    public static void main(String[] args) {
        reversePrint r1 = new reversePrint();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        int[] res = r1.reversePrint1(l1);
        for (int x : res)
            System.out.println(x);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        int n = stack.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = stack.pop();
        }

        return res;
    }
}
