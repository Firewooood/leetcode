package LinkedList;

class MyLinkedList {
    ListNode head;
    int len;

    public MyLinkedList() {
        // 建立头尾指针
        head = new ListNode(-1);
        len = 0;
    }

    public int get(int index) {
        ListNode cur = head;
        int n = 0;
        if (index < 0 || index >= len)
            return -1;
        while (n <= index) {
            n++;
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(len, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > len)
            return;
        // index 在0和len之间时，在index之前添加该节点。
        ListNode cur = new ListNode(val);
        ListNode tmp = head;
        int n = index;
        while (n > 0) {
            tmp = tmp.next;
            n--;
        }
        cur.next = tmp.next;
        tmp.next = cur;
        len++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len)
            return;
        len--;
        int n = index;
        ListNode tmp = head;
        while (n > 0) {
            tmp = tmp.next;
            n--;
        }
        tmp.next = tmp.next.next;
    }

    void show() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.print(" ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        linkedList.get(1);
        linkedList.deleteAtIndex(1);
        linkedList.get(1);

        linkedList.show();
    }
}

class ListNode {
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