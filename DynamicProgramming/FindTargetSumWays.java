package DynamicProgramming;

public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        int x = (sum + target) / 2;
        if (target > sum || (sum + target) % 2 != 0)
            return 0;
        int[] dp = new int[x + 1]; // dp[i] 表示使目标和为i 的方法数
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = x; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[x];
    }

    public static void main(String[] args) {
        FindTargetSumWays f1 = new FindTargetSumWays();
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;
        System.out.println(f1.findTargetSumWays(nums, target));
    }
}
