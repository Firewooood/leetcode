package done;
public class maxProfit {
    public static void main(String[] args) {
        maxProfit m1 = new maxProfit();
        int[] prices = { 3,2,6,5,0,3 };
        System.out.println(m1.solution(prices));
    }

    public int solution(int[] prices) {
        int len = prices.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len];
        int max = prices[0], max_x = 0;
        int min = prices[0], min_x = 0; // 使用_x记录max和min的坐标
        for (int i = 1; i < len; i++) {
            if (prices[i] > max) { // 若当前价钱比最大价钱大，则直接卖出，可得最大利润
                max = prices[i];// 将最大值改为现在
                max_x = i;
            }
            if (prices[i] < min) {
                min = prices[i];
                min_x = i;
            }
            if (max_x > min_x) {
                dp[i] = Math.max(dp[i - 1], max - min); 
            } else
            {
                dp[i] = dp[i - 1];
                max = prices[i];
                max_x = i;
            }
                
        }
        return dp[len - 1];
    }

}
