package DynamicProgramming;

public class Change {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // 硬币组成金额 i 的组合数为 dp[i]
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // 硬币组成金额 i 的排列数为 dp[i]
        dp[0] = 1;
        for (int j = 0; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (j - coins[i] >= 0)
                    dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Change c1 = new Change();
        int[] coins = { 1, 2, 5 };
        int amount = 5;

        System.out.println(c1.change(amount, coins));
        System.out.println(c1.change1(amount, coins));
    }
}
