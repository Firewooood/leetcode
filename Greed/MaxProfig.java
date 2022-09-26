package Greed;

public class MaxProfig {
    public int maxProfit(int[] prices, int fee) {
        int[] in = new int[prices.length]; // in[i] 表示第i天持有一支股票的最大利润
        int[] out = new int[prices.length]; // out[i]表示第i天未持有股票的最大利润
        in[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            out[i] = Math.max(out[i - 1], in[i - 1] + prices[i] - fee);
            in[i] = Math.max(in[i - 1], out[i - 1] - prices[i]); // 第i天持有股票，一定由第i-1天不持有股票状态转移来
        }
        return out[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] prices = { 9, 8, 7, 1, 2 };
        int fee = 3;
        MaxProfig m1 = new MaxProfig();
        System.out.println(m1.maxProfit(prices, fee));
    }
}
