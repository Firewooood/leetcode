package DynamicProgramming;

public class CountSubString {
    public int countSubstrings(String s) {
        int n = s.length();
        if (n <= 1)
            return n;
        boolean[][] dp = new boolean[n + 1][n + 1]; // dp[i][j] 表示串s i-1~j-1 是否为回文子串
        int res = 0;
        for (int i = 0; i < n; i++) { // 定义步长
            for (int j = 0; i + j < n; j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    if (i <= 1)
                        dp[j + 1][j + i + 1] = true;
                    else
                        dp[j + 1][j + i + 1] = dp[j + 2][j + i];
                } else {
                    dp[j + 1][j + i + 1] = false;
                }

                if (dp[j + 1][j + i + 1])
                    res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "aaa";
        CountSubString c1 = new CountSubString();
        System.out.println(c1.countSubstrings(s));
    }
}
