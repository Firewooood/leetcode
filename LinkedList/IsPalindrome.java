package LinkedList;

import java.util.Stack;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true; // 只有一个节点，则必为回文链表
        int len = 0;
        ListNode p = head, q = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        p = head;
        int x = len % 2 == 0 ? len / 2 : len / 2 + 1;
        Stack<ListNode> stack = new Stack<>();
        while (x-- > 0) {
            stack.push(p);
            p = p.next;
        }
        if (len % 2 == 1)
            stack.pop();
        while (p != null) {
            if(stack.pop().val != p.val)return false;
            p = p.next;
        }
        
        return true;
    }
    public static void main(String[] args) {
        IsPalindrome i1 = new IsPalindrome();
        ListNode l4 = new ListNode(1);
        ListNode l3 = new ListNode(2,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1, l2);
        System.out.println(i1.isPalindrome(l1));
    }
}
