package done;public class getMoneyAmount {
    public static void main(String[] args) {
        getMoneyAmount g = new getMoneyAmount();
        System.out.println(g.g1(10));
    }

    /**
     * dp[i][j]表示从[i,j]中猜出正确数字所需要的最少花费金额.(dp[i][i] = 0) 假设在范围[i,j]中选择x,
     * 则选择x的最少花费金额为: max(dp[i][x-1], dp[x+1][j]) + x
     * 枚举先猜k，则花费k，剩下区间[i,k-1]和[k+1,j]，因为会告诉你大了或小了，所以肯定只选择一个，又因为我们要保证猜对，所以取max{dp[i][k-1],dp[k+1][j]}
     * ，即有： dp[i][j]=min(dp[i][j], k+max(dp[i][k-1],dp[k+1][j]));
     * 用max的原因是我们要计算最坏反馈情况下的最少花费金额(选了x之后, 正确数字落在花费更高的那侧)
     * 
     * 初始化为(n+2)*(n+2)数组的原因: 处理边界情况更加容易, 例如对于求解dp[1][n]时x如果等于1, 需要考虑dp[0][1](0不可能出现,
     * dp[0][n]为0) 而当x等于n时, 需要考虑dp[n+1][n+1](n+1也不可能出现, dp[n+1][n+1]为0)
     * 
     * 如何写出相应的代码更新dp矩阵, 递推式dp[i][j] = max(max(dp[i][x-1], dp[x+1][j]) + x), x~[i:j],
     * 可以画出矩阵图协助理解, 可以发现dp[i][x-1]始终在dp[i][j]的左部, dp[x+1][j]始终在dp[i][j]的下部,
     * 所以更新dp矩阵时i的次序应当遵循bottom到top的规则, j则相反, 由于i肯定小于等于j, 所以我们只需要遍历更新矩阵的一半即可(下半矩阵)
     **/
    public int g1(int n) {
        int dp[][] = new int[n + 2][n + 2];
        // 定义d[i][j]表示从[i,j]中猜出正确数字所需的最少花费金额
        for (int i = n; i >= 1; --i) {
            for (int j = i; j <= n; ++j) {
                if (i == j)
                    dp[i][j] = 0;
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int x = i; x <= j; ++x)
                        dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][x - 1], dp[x + 1][j]) + x);
                }
            }
        }
        return dp[1][n];
    }

}