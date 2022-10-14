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

    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * 
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[4][len + 1]; // dp[0][i] 表示第一次买入的最大利润，dp[1][i] 表示第一次卖出的最大利润
        // dp[2][i] 表示第一次买入的最大利润，dp[3][i] 表示第一次卖出的最大利润

        dp[0][0] = Integer.MIN_VALUE;
        dp[2][0] = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dp[0][i + 1] = Math.max(-prices[i], dp[0][i]);
            dp[1][i + 1] = Math.max(dp[0][i] + prices[i], dp[1][i]);
            dp[2][i + 1] = Math.max(dp[1][i] - prices[i], dp[2][i]);
            dp[3][i + 1] = Math.max(dp[2][i] + prices[i], dp[3][i]);
        }
        return dp[3][len];
    }

    public int maxProfit4(int k, int[] prices) {
        int len = prices.length;
        if (prices.length == 0)
            return 0;
        int[][] dp = new int[len][2 * k]; // dp[i][奇数] 表示第i天未持有股票的最大利润 dp[i][偶数] 表示i天持有股票的最大利润
        for (int i = 0; i < k; i++) {
            dp[0][2 * i] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    dp[i][0] = Math.max(dp[i - 1][0], -prices[i]); // 第一次买入的利润一定是非正的
                    // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]); //
                    // 该表达式错误的加上了前几次买入卖出的利润
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
                } else {
                    dp[i][2 * j] = Math.max(dp[i - 1][2 * j], dp[i][2 * j - 1] - prices[i]);
                    dp[i][2 * j + 1] = Math.max(dp[i - 1][2 * j + 1], dp[i][2 * j] + prices[i]);
                }
            }
        }
        return dp[len - 1][2 * k - 1];
    }

    // 含手续费 买卖股票的最佳时机
    public int maxProfit5(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[len - 1][1];
    }

    public static void main(String[] args) {
        // int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        MaxProfit m1 = new MaxProfit();
        // System.out.println(m1.maxProfit4(2, prices));
        System.out.println(m1.maxProfit5(prices, 2));
    }
}
