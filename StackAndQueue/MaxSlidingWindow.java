package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        MyQueue1 q = new MyQueue1();
        for (int i = 0; i < k; i++) {
            q.add(nums[i]);
        }
        res[0] = q.peek();
        for (int i = k; i < n; i++) {
            q.pop(nums[i - k]);
            q.add(nums[i]);
            res[i - k + 1] = q.peek();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { -6, -10, -7, -1, -9, 9, -8, -4, 10, -5, 2, 9, 0, -7, 7, 4, -2, -10, 8, 7 };
        int k = 7;
        MaxSlidingWindow m1 = new MaxSlidingWindow();
        int[] res = m1.maxSlidingWindow(nums, k);
        for (int x : res)
            System.out.print(x + " ");
    }
}

class MyQueue1 {
    // 该双端队列按从大到小排序
    Deque<Integer> q = new LinkedList<>();

    public void pop(int val) {
        if (!q.isEmpty() && val == q.peek())
            q.poll();
    }

    // 加入的元素x小于队底元素，则正常加入，若大于，则将小于x的元素全部删除
    public void add(int x) {
        while (!q.isEmpty() && q.getLast() < x) {
            q.removeLast();
        }
        q.add(x);
    }

    public int peek() {
        return q.peek();
    }
}
