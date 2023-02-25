package DynamicProgramming;

public class MaxProduct {
    // 找出数组中乘积最大的连续非空子数组
    public int maxProduct(int[] nums) {
        int[] dp1 = new int[nums.length]; // dp[i] 表示i为下标的最大连续非空子数组。
        int[] dp2 = new int[nums.length]; // dp[i] 表示i为下标的最小连续非空子数组。
        int max = nums[0];

        dp1[0] = nums[0];
        dp2[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp1[i] = Math.max(Math.max(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i]), nums[i]);
            dp2[i] = Math.min(Math.min(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i]), nums[i]);
            max = Math.max(dp1[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { -1, -3, -1 };
        MaxProduct m1 = new MaxProduct();
        System.out.println(m1.maxProduct(nums));
    }
}
