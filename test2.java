import done.canConstruct;

public class test2 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 5 };
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums)
            sum += x;
        if (sum % 2 == 1)
            return false;
        int[] dp = new int[sum / 2 + 1]; // dp[i]表示容量为i的背包最多价值

        for (int j = 0; j < nums.length; j++) {
            for (int i = sum / 2; i > 0; i--) {
                if (i - nums[j] >= 0) {
                    dp[i] = Math.max(dp[i - nums[j]] + nums[j], dp[i]);
                }
            }
        }
        return dp[sum / 2] == sum / 2;
    }
}
