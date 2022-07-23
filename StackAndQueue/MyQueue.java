package StackAndQueue;

import java.util.Stack;

/// 需要用两个栈实现队列的先进先出

public class MyQueue {
    Stack<Integer> p;
    Stack<Integer> q;

    public MyQueue() {
        p = new Stack<>();
        q = new Stack<>();
    }

    public void push(int x) {
        p.push(x);
    }

    public int pop() {
        // 若q空，则将p栈元素依次出栈加入q中
        if (q.empty()) {
            int n = p.size();
            for (int i = 0; i < n; i++) {
                q.push(p.pop());
            }
        } // 若q非空，先返回q中的顶值
        return q.pop();
    }

    public int peek() {
        // 若q空，则将p栈元素依次出栈加入q中
        if (q.empty()) {
            int n = p.size();
            for (int i = 0; i < n; i++) {
                q.push(p.pop());
            }
        } // 若q非空，先返回q中的顶值
        return q.peek();
    }

    public boolean empty() {
        if (p.empty() && q.empty())
            return true;
        return false;
    }

}
