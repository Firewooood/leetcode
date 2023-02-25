package LinkedList;

public class SortList {
    public ListNode sortList(ListNode head) {
        // 使用插入排序法。
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE, head);
        ListNode p_prev = dummyNode;
        ListNode p = head; // 定义p，作为遍历链表的浮标
        while (p != null) {
            ListNode q = dummyNode.next;
            ListNode q_prev = dummyNode;
            while (q.val < p.val) {
                q = q.next;
                q_prev = q_prev.next;
            }
            // 维持一个单增链表，链表的结尾是p；
            if (q == p) {
                p = p.next;
                p_prev = p_prev.next;
                continue;
            }
            q_prev.next = p;
            p_prev.next = p.next;
            p.next = q;
            p = p_prev.next;
            // p_prev = q;
        }
        return dummyNode.next;
    }
    
    public ListNode sortList1(ListNode head) {
        // 使用归并排序法。

        // 1. 递归结束条件
        if (head == null || head.next == null)
            return head;

        // 2. 找到链表中间节点并断开链表  递归下探
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3. 合并有序链表
        return mergeTwoLists(left, right);
    }

    // 找到链表的中间节点
    ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode cur = sentry;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;    // 将剩余部分加入有序链表中
        return sentry.next;
    }

    public void swap(ListNode p, ListNode q, ListNode p_pre, ListNode q_pre) {
        
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(0);
        ListNode l3 = new ListNode(4, l4);
        ListNode l2 = new ListNode(3, l3);
        ListNode l1 = new ListNode(5, l2);
        ListNode l0 = new ListNode(-1, l1);

        SortList s1 = new SortList();
        ListNode lNew = s1.sortList1(l0);
    }
}
