package DynamicProgramming;

// 和另一不同的区别是
// 需要输出最长子序列
public class LongestCommonSubsequence1 {
    public String longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1]; // 长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    b[i][j] = 1; // 来自左上方
                } else {
                    if (dp[i][j + 1] > dp[i + 1][j]) {
                        dp[i + 1][j + 1] = dp[i][j + 1];
                        b[i][j] = 2; // 2 表示来自上方
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j];
                        b[i][j] = 3; // 3 表示来自左方
                    }
                }
            }
        }
        String res = getRes(b, n - 1, m - 1, text1);
        return res;
    }

    String getRes(int[][] b, int i, int j, String s1) {
        String res = "";
        if (i < 0 || j < 0) {
            return res;
        }
        if (b[i][j] == 1) {
            res += getRes(b, i - 1, j - 1, s1);
            res += s1.charAt(i);
        } else if (b[i][j] == 2) {
            res += getRes(b, i - 1, j, s1);
        } else {
            res += getRes(b, i, j - 1, s1);
        }
        return res;
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        LongestCommonSubsequence1 l1 = new LongestCommonSubsequence1();
        System.out.println(l1.longestCommonSubsequence(text1, text2));
    }
}
