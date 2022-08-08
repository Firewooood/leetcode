package MonotonicStack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(0); // 首元素 下标入栈
        for (int i = 1; i < temperatures.length;) {
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) { // 当前元素比栈顶元素小,则当前元素下标入栈
                stack.push(i);
                i++;
            } else {
                // 当前元素比栈顶元素大, 则栈顶元素出栈
                res[stack.peek()] = i - stack.pop();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        DailyTemperatures d1 = new DailyTemperatures();
        int[] res = d1.dailyTemperatures(temperatures);
    }
}
