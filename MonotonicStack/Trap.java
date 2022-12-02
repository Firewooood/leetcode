package MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class Trap {
    // 求数i右边第一个大于等于i 的数
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2)
            return 0;
        int res = 0;
        int[] right = new int[n + 1]; // 表示从i ~ n - 1 , 最长的柱子值
        int[] left = new int[n + 1]; // 表示从0 ~ i ,最长的柱子值
        for (int i = 1; i <= n; i++) {
            left[i] = height[i - 1] > left[i - 1] ? height[i - 1] : left[i - 1];
        }

        for (int i = n; i > 0; i--) {
            right[i - 1] = height[i - 1] > right[i] ? height[i - 1] : right[i];
        }
        for (int i = 0; i < n; i++) {
            right[i] = Math.min(right[i], left[i + 1]);
            res += right[i] - height[i];
        }
        return res;
    }

    public int trap1(int[] height) {
        int n = height.length;
        if (n <= 2)
            return 0;
        int[] left = new int[n]; // 记录每个位置左边最大的柱子高度
        int[] right = new int[n]; // 记录每个位置右边最大的柱子高度
        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        max = 0;
        for (int j = n - 1; j >= 0; j--) {
            max = Math.max(max, height[j]);
            right[j] = max;
        }
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        Trap t1 = new Trap();
        System.out.println(t1.trap1(height));
    }
}
