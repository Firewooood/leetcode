package DynamicProgramming;

public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] zero = new int[strs.length];
        int[] one = new int[strs.length];
        int x = 0;
        // 遍历strs, 得到每一子元素中0, 1 的个数
        for (String s : strs) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    one[x]++;
                else {
                    zero[x]++;
                }
            }
            x++;
        }
        int[][] dp = new int[m + 1][n + 1]; // dp[i][j] 表示最多有m个0,n个1的最大子集长度
        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >= zero[i]; j--) {
                for (int k = n; k >= one[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero[i]][k - one[i]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm1(String[] strs, int m, int n) {
        int len = strs.length;
        int[] zero = new int[len];
        int[] one = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    zero[i]++;
                } else
                    one[i]++;
            }
        }

        int[][] dp = new int[m + 1][n + 1]; // dp[i][j] 表示最多有i个0，j个1的最大子集长度
        dp[0][0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = m; j >= zero[i]; j--) {
                for (int k = n; k >= one[i]; k--) {
                    dp[j][k] = Math.max(dp[j - zero[i]][k - one[i]] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        FindMaxForm f1 = new FindMaxForm();
        String[] strs = { "10", "0001", "111001", "1", "0" };
        int m = 5, n = 3;
        // String[] strs = { "10", "0", "1" };
        // int m = 1, n = 1;
        System.out.println(f1.findMaxForm1(strs, m, n));
    }
}
