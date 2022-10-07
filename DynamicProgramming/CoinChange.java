package DynamicProgramming;

public class CoinChange {
    /**
     * 
     * @param coins  表示不同面额的硬币
     * @param amount 硬币组合的总金额
     * @return 凑成总金额需要的最小硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1]; // dp[i] 表示凑成金额i所需的最小硬币个数

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != 0 || j == coins[i]) { // 当总金额可由硬币构成时
                    if (dp[j] == 0)
                        dp[j] = dp[j - coins[i]] + 1;
                    else
                        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        // int[] coins = { 1, 2, 5 };
        // int amount = 11;
        int[] coins = { 186, 419, 83, 408 };
        int amount = 6249;
        CoinChange c1 = new CoinChange();
        System.out.println(c1.coinChange(coins, amount));
    }
}
