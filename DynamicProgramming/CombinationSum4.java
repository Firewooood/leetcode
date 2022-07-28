package DynamicProgramming;

public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1]; // 组成重量为i的组合个数为 dp[i]
        dp[0] = 1;

        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSum4 c1 = new CombinationSum4();
        int[] nums = { 1, 2, 3 };
        int target = 4;
        System.out.println(c1.combinationSum4(nums, target));
    }

}
