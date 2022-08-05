package DynamicProgramming;

public class MaxUncrosslines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1]; // dp[i][j] 表示nums1[0] ~ nums1[i], nums2[0] ~ nums2[j] 的最大连线数

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        MaxUncrosslines m1 = new MaxUncrosslines();
        int[] nums1 = { 1, 4, 2 };
        int[] nums2 = { 1, 2, 4 };
        System.out.println(m1.maxUncrossedLines(nums1, nums2));
    }
}
