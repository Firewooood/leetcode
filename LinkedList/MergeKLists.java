package LinkedList;

import java.util.PriorityQueue;

import done.numFriendRequests;

public class MergeKLists {
    // 使用优先队列合并
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });
        for (int i = 0; i < lists.length; i++) {
            // 将lists中所有列表的头节点加入优先队列
            if (lists[i] != null)
                queue.add(lists[i]);
        }
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            p.next = cur;
            p = p.next; // 将最小Node加入结果集
            if (cur.next != null)
                queue.add(cur.next);
        }
        return dummyNode.next;
    }

    // 使用分治法 两两合并
    public ListNode mergeKLists1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r)
            return null;
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    public static void main(String[] args) {
        MergeKLists m1 = new MergeKLists();
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNodeMethod.parse(new int[] { 1, 4, 5 });
        lists[1] = ListNodeMethod.parse(new int[] { 1, 3, 4 });
        lists[2] = ListNodeMethod.parse(new int[] { 2, 6 });
        ListNode res = m1.mergeKLists(lists);
    }

    
}
