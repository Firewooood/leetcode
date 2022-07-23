package done;
public class arrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins1(3));
    }

    public static int arrangeCoins1(int n) {
        long high = (long) Math.sqrt(2 * n);//取根号n的整数部分。
        long low = 1;
        long mid = 0;
        while (low < high) {
            mid = low + (high - low) / 2;
            long total = mid * (mid + 1) / 2;
            if (total == n)
                return (int) mid;
            if (total > n) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }  
        }
        return (int) high;
    }
//  public static int arrangeCoins2(int n) {
//         int res = 1;
//         long high = (long) Math.sqrt(2 * n);//取根号n的整数部分。
//         long low = 1;
//         long mid = 0;
//         while (low < high) {
//             mid = (low + high) / 2;
//             if ((mid * mid + mid) / 2 < n) {
//                 low = mid + 1;
//             }
//             else if ((mid * mid + mid) / 2 > n) {
//                 high = mid + 1;
//             }
            
//             if ((mid * mid + mid) / 2 <= n && (mid * mid + 3 * mid + 2) / 2 > n) {
//                 return (int)mid;
//             }

            
//         }
//         return (int)high;
//     }
}
