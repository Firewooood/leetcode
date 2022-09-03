package MonotonicStack;

import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, res = 0;
        int[] left = new int[n]; // 记录i柱子左边第一个小于该柱子的下标
        int[] right = new int[n]; // 记录i柱子右边第一个小于该柱子的下标
        // 得到left数组 , j = left[j]; 利用原来的结果, 减少时间消耗
        left[0] = -1;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }
            left[i] = j;
        }
        // 得到right数组
        right[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && heights[j] >= heights[i]) {
                j = right[j];
            }
            right[i] = j;
        }
        for (int i = 0; i < n; i++) {
            int tmp = heights[i] * (right[i] - left[i] - 1);
            res = tmp > res ? tmp : res;
        }
        return res;
    }

    int largestRectangleArea2(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();

        // 数组扩容，在头和尾各加入一个元素
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        st.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                while (heights[i] < heights[st.peek()]) { // 注意是while
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LargestRectangleArea l1 = new LargestRectangleArea();
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(l1.largestRectangleArea2(heights));
    }
}
