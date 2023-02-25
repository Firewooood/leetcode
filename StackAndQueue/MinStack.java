package StackAndQueue;

import java.util.Stack;

// 最小栈
public class MinStack {
    Stack<Node> stack;
    Node dummpyNode;    // 使用双向链表来从小到大存储val
    public MinStack() {
        stack = new Stack<>();
        dummpyNode = new Node(Integer.MIN_VALUE);
    }

    public void push(int val) {
        if (dummpyNode.next == null || val < dummpyNode.next.val) {
            // 若当前无最小值，或进入的val小于最小值。
            Node cur = new Node(val, dummpyNode, dummpyNode.next);
            if (dummpyNode.next != null) {
                dummpyNode.next.pre = cur;
            }
            dummpyNode.next = cur;
            stack.push(cur);
        } else {
            // 当前的val在最小值之后
            Node p_pre = dummpyNode;
            Node p = dummpyNode.next, cur;
            while (p != null && p.val < val) {
                p_pre = p;
                p = p.next;
            }
            if (p == null) {
                cur = new Node(val, p_pre, null);
                p_pre.next = cur;
            } else {
                cur = new Node(val, p.pre, p);
                p.pre.next = cur;
                p.pre = cur;
            }
            stack.push(cur);
        }
    }

    public void pop() {
        Node cur = stack.pop();
        cur.pre.next = cur.next;
        if(cur.next != null)
            cur.next.pre = cur.pre;
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return dummpyNode.next.val;
    }

    class Node
    {
        int val;
        Node pre;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}
