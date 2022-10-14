package DynamicProgramming;

public class Rob {
    // 该方法错误
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

    public int rob1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1]; // dp[i] 表示在第i天偷窃的最高金额
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < len; i++) {
            dp[i] = dp[i - 2] + nums[i - 1];
        }
        return Math.max(dp[len], dp[len - 1]);
    }

    // 这个地方所有的房屋都 围成一圈，求盗窃的最大金额
    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        int[] dp1 = new int[len]; // 从1~len-1
        int[] dp2 = new int[len]; // 从2~len
        dp1[1] = nums[0];
        dp2[1] = nums[1];

        for (int i = 2; i < len; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i - 1]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp1[len - 1], dp2[len - 1]);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 9, 7, 1 };
        // int[] nums = { 2, 7, 9, 3, 1 };
        Rob r1 = new Rob();
        System.out.println(r1.rob(nums));
    }
}
