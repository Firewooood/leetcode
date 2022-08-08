package MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>(); // stack中存储的为nums 数组的下标
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }

        // 处理栈中剩余的元素
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() != 1 && nums[i] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i];
                stack.pop();
            }
        }
        int m = stack.size();
        while (m-- > 0) {
            res[stack.pop()] = -1;
        }

        return res;
    }

    public int[] nextGreaterElements2(int[] nums) {
        // 边界判断
        if (nums == null || nums.length <= 1) {
            return new int[] { -1 };
        }
        int size = nums.length;
        int[] result = new int[size];// 存放结果
        Arrays.fill(result, -1);// 默认全部初始化为-1
        Stack<Integer> st = new Stack<>();// 栈中存放的是nums中的元素下标
        for (int i = 0; i < 2 * size; i++) {
            while (!st.empty() && nums[i % size] > nums[st.peek()]) {
                result[st.peek()] = nums[i % size];// 更新result
                st.pop();// 弹出栈顶
            }
            st.push(i % size);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElements n1 = new NextGreaterElements();
        int[] nums = { 5, 4, 3, 2, 1 };
        int[] res = n1.nextGreaterElements2(nums);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
