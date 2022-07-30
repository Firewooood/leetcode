package DynamicProgramming;

import java.util.Arrays;

public class numSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // 和为i的完全平方数的最小数量为dp[i]
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1; // 1的完全平方数是自己
        int m = (int) Math.sqrt(n);
        for (int j = 0; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (j - i * i >= 0 && dp[j - i * i] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        numSquares n1 = new numSquares();
        System.out.println(n1.numSquares(12));
    }
}
