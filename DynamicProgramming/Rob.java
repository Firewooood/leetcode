package DynamicProgramming;

public class Rob {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1]; // 偷窃0~i房间,得到的最大金额为dp[i]
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length; j >= nums[i] && j >= 2; j--) {
                dp[j] = Math.max(dp[j - 1], dp[j - 2] + nums[j - 1]);
            }
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = { 4, 9, 7, 1 };
        Rob r1 = new Rob();
        System.out.println(r1.rob(nums));
    }
}
