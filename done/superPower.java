package done;

public class superPower {
    public static void main(String[] args) {
        int a = 2;
        int[] b = { 1, 0 };
        superPower s1 = new superPower();
        System.out.println(s1.s1(a, b));
        int x = 63 * 63 % 23;
        System.out.println(x);
    }
    
    /**
     * 你的任务是计算 a^b 对 1337 取模，
     * a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
     * @param a
     * @param b
     * @return
     */

    int MOD = 1337;

    public int s1(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }
    
    int dfs(int a, int[] b, int u) {
        if (u == 1)
            return 1;
        return pow(dfs(a, b, u - 1), 10) * pow(a, b[u]) % MOD;
    }
    //99^(2345) = (99^234)^10 * 99^5
    int pow(int a, int b) {
        int ans = 1;
        a %= MOD;
        while (b != 0) {
            if ((b & 1) != 0)
                ans = ans * a % MOD;
            a = a * a % MOD;
            b>>=1;
        }
        return ans;
    }
}
