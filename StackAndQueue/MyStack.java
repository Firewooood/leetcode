package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> p;// 输入队列

    public MyStack() {
        p = new LinkedList<>();
    }

    public void push(int x) {
        p.add(x);
    }

    public int pop() {
        int size = p.size();
        // 将size - 1 个元素出队列，出栈后重新加回队列
        for (int i = 0; i < size - 1; i++) {
            p.add(p.poll());
        }
        // 此时队列的第一个元素即是入队顺序的最后一个元素。
        return p.poll();
    }

    public int top() {
        int size = p.size();
        // 将size - 1 个元素出队列，出栈后重新加回队列
        for (int i = 0; i < size - 1; i++) {
            p.add(p.poll());
        }
        // 此时队列的第一个元素即是入队顺序的最后一个元素。
        return p.peek();
    }

    public boolean empty() {
        return p.isEmpty();
    }
}
