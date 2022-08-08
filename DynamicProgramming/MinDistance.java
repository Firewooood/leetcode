package DynamicProgramming;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1]; // dp[i][j] 表示word1[0~i-1]转化成word2[0~j-1] 的最小操作数
        for (int i = 0; i <= n; i++)
            dp[i][0] = i; // word1变为空串,需减去当前所有char
        for (int j = 0; j <= m; j++)
            dp[0][j] = j; // 空串变为word2,需加上word2所有char
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j]; // 如hors -> ros = hor -> ro
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "a", word2 = "ab";
        MinDistance m1 = new MinDistance();
        System.out.println(m1.minDistance(word1, word2));
    }

}
