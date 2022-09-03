package DynamicProgramming;

public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int x : stones)
            sum += x;
        int[] dp = new int[sum / 2 + 1]; // dp[i] 表示 stones[i] 中选择石头能得到的最大重量

        for (int i = 0; i < stones.length; i++) {
            for (int j = sum / 2; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[sum / 2];
    }

    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };

        LastStoneWeightII l1 = new LastStoneWeightII();
        System.out.println(l1.lastStoneWeightII(stones));
    }
}
