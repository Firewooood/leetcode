package LinkedList;

class MyLinkedList1 {
    class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    int len = 0;
    ListNode head;

    public MyLinkedList1() {
        this.len = 0;
        head = null;
    }

    public int get(int index) {
        if (index < 0 || index >= len) {
            return -1;
        }
        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(-1, val);
    }

    public void addAtTail(int val) {
        addAtIndex(len, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > len)
            return; // 若index 大于链表长度,直接返回,不插入节点
        len++;
        if (index <= 0) { // 在头部插入节点
            ListNode cur = new ListNode(val, head);
            this.head = cur;
            return;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        index--;
        while (true) {
            if (index-- == 0) {
                ListNode node = new ListNode(val, cur);
                pre.next = node;
                return;
            }
            cur = cur.next;
            pre = pre.next;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) {
            return;
        }
        len--;
        if (index == 0) {
            // 删除首节点
            head = head.next;
            return;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        index--;
        while (cur != null) {
            if (index-- == 0) {
                pre.next = cur.next;
                return;
            }
            cur = cur.next;
            pre = pre.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList1 linkedList = new MyLinkedList1();
        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(0);

        // linkedList.addAtTail(3);
        // linkedList.addAtIndex(1, 2); // 链表变为1-> 2-> 3

        // System.out.println(linkedList.get(1)); // 返回2
        // linkedList.deleteAtIndex(1); // 现在链表是1-> 3
        // System.out.println(linkedList.get(1)); // 返回3
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */