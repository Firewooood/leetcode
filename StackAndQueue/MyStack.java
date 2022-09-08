package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> p;// 输入队列

    public MyStack() {
        p = new LinkedList<>();
    }

    public void push(int x) {
        p.add(x);
        int size = p.size();
        // 将size - 1 个元素出队列，出栈后重新加回队列
        for (int i = 0; i < size - 1; i++) {
            p.add(p.poll());
        }
        // 此时队列的第一个元素即是入队顺序的最后一个元素。
    }

    public int pop() {
        return p.poll();
    }

    public int top() {
        return p.peek();
    }

    public boolean empty() {
        return p.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
