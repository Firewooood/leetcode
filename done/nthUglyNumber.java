package done;

public class nthUglyNumber {
    public static void main(String[] args) {
        nthUglyNumber n1 = new nthUglyNumber();
        System.out.println(n1.nthUglyNumber1(55));
    }

    /**
     * 将只包含质因子2、3、5的数称为丑数
     * 
     * @param n n < 1690
     * @return 输出第n个丑数
     */
    public int nthUglyNumber1(int n) {
        if (n <= 0)
            return -1;
        int[] dp = new int[n];
        dp[0] = 1;
        int id2 = 0, id3 = 0, id5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[id2] * 2, Math.min(dp[id3] * 3, dp[id5] * 5));
            if (dp[id2] * 2 == dp[i])
                id2++;
            if (dp[id3] * 3 == dp[i])
                id3++;
            if (dp[id5] * 5 == dp[i])
                id5++;
        }
        return dp[n - 1];
    }
}
