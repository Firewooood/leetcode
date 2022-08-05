package DynamicProgramming;

public class NumDistinct {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1]; // dp[i][j] 表示串s 0~i-1中, 子序列t 0~j-1 出现的次数
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > i)
                    break;
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        NumDistinct n1 = new NumDistinct();
        System.out.println(n1.numDistinct(s, t));
    }
}
