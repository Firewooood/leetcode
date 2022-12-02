package Greed;

public class MaxArea {
    public int maxArea(int[] height) {
        int n = height.length, res = 0;
        int start = 0, end = n - 1; // 定义双指针
        while (start < end) {
            int cur = Math.min(height[start], height[end]) * (end - start);
            res = Math.max(cur, res);
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        MaxArea m1 = new MaxArea();
        System.out.println(m1.maxArea(height));
    }
}
