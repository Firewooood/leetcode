package DynamicProgramming;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, res = 0;
        if (len == 1)
            return 1;
        int[] dp = new int[len + 1]; // dp[i] 表示以i为序列尾的最长递增子序列长度
        dp[0] = dp[1] = 1;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + 1);
                } else
                    dp[i + 1] = 1;
                res = Math.max(dp[i + 1], res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLIS l1 = new LengthOfLIS();
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(l1.lengthOfLIS(nums));
    }
}
