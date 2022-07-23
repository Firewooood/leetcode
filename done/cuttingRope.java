package done;
public class cuttingRope {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(cuttingRope1(120));
    }
    
    public static int cuttingRope1(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        // 将绳子的分段尽可能为3
        long res = 1;
        int x = n / 3;
        int y = n % 3;

        while (x > 1) {
            res *= 3;
            if (res > 1000000007) {
                res = res % 1000000007;
            }
            x--;
        }
        if (y == 1) {
            res = (res * 4) % 1000000007;
        } else {
            int j = y == 0 ? 3 : 6;
            res = (res * j) % 1000000007;

        }
        return (int)res;
    }
    
}
