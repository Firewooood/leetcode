package done;import java.util.Arrays;

public class KInversePairs {
    public static void main(String[] args) {
        KInversePairs k = new KInversePairs();
        System.out.println(k.k1(3, 1));
    }
   
    /*
    给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，
    且恰好拥有 k 个逆序对的不同的数组的个数。
    逆序对的定义如下：对于数组的第i个和第 j个元素，
    如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
    由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
    输入: n = 3, k = 1
    输出: 2
    解释: 
    数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
    */
    int mod = (int) 1e9 + 7;
    public int k1(int n, int k) {
        int[][] f = new int[n + 1][k + 1];
        int[][] sum = new int[n + 1][k + 1];
        f[1][0] = 1;
        Arrays.fill(sum[1], 1);
        for (int i = 2; i <= n; i++)
        {
            for (int j = 0; j <= k; j++) {
                f[i][j] = j < i ? sum[i - 1][j] : (sum[i - 1][j] - sum[i - 1][j - i] + mod) % mod;
                sum[i][j] = j == 0 ? f[i][j] : (sum[i][j - 1] + f[i][j]) % mod;
            }
        }

        return f[n][k];
    }
}
