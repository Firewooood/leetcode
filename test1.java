import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import LinkedList.LRUCache;
import StackAndQueue.MinStack;

public class test1 {

    int test2(int[] nums, int k) {
        Queue<Integer> qq = new PriorityQueue<>((a, b) -> b - a); // 定义一个降序排列的优先队列
        for (int x : nums)
            qq.add(x);
        for (int i = 0; i < k; i++) {
            int cur = qq.poll();
            if (cur == 1)
                break; // 若最大的数为1 则直接退出
            int tmp = 0;
            while (cur != 0) {
                tmp++;
                cur &= cur - 1;
            }
            qq.add(tmp);
        }
        int sum = 0, len = qq.size();
        for (int i = 0; i < len; i++) {
            sum += qq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();

    }
}
