package DynamicProgramming;

public class MaxProfit4 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // [天数][状态] 0 买入状态 1 两天前已卖出,度过冷冻期状态 2 前两天未卖,卖后需度过冷冻期状态 3 冷却期状态
        int[][] dp = new int[len][4];
        dp[0][0] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[len - 1][3], Math.max(dp[len - 1][1], dp[len - 1][2]));
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 4 };
        MaxProfit4 m1 = new MaxProfit4();
        System.out.println(m1.maxProfit(prices));
    }
}
