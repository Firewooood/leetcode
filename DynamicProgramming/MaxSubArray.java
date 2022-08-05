package DynamicProgramming;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1]; // dp[i + 1] 表示以nums[i]为尾的最大和
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i] >= 0) {
                dp[i + 1] = dp[i] + nums[i];
            } else {
                dp[i + 1] = nums[i];
            }
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSubArray m1 = new MaxSubArray();
        int[] nums = { 5, 4, -1, 7, 8 };
        System.out.println(m1.maxSubArray(nums));
    }
}
