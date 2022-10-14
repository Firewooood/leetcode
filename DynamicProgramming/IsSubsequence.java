package DynamicProgramming;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        boolean[][] dp = new boolean[n + 1][m + 1]; // dp[i][j] 表示 s[0~i] 是否是 t[0~j]的子序列
        for (int i = 0; i <= m; i++)
            dp[0][i] = true;

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (i > j)
                    break;
                if (s.charAt(i) == t.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        IsSubsequence i1 = new IsSubsequence();
        String s = "abc", t = "ahbgdc";
        System.out.println(i1.isSubsequence(s, t));
    }
}
