package DynamicProgramming;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1]; // dp[i][j] 表示以text1.charAt(i) 和text2.charAt(j) 结束的子序列的最大长度
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    for (int a = 0; a <= i; a++) {
                        for (int b = 0; b <= j; b++) {
                            dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[a][b] + 1);
                        }
                    }
                }
                res = Math.max(res, dp[i + 1][j + 1]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        LongestCommonSubsequence l1 = new LongestCommonSubsequence();
        System.out.println(l1.longestCommonSubsequence(text1, text2));
    }
}