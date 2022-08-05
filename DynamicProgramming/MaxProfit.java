package DynamicProgramming;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2]; // dp[i][0] 表示第i天不持有股票的最大利润, dp[i][1] 表示第i天持有股票的最大利润
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            dp[i + 1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
            dp[i + 1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        }
        return dp[prices.length][0];
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        MaxProfit m1 = new MaxProfit();
        System.out.println(m1.maxProfit(prices));
    }
}
