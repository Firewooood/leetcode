package done;

public class binaryGap {
    public static void main(String[] args) {
        binaryGap b1 = new binaryGap();
        System.out.println(b1.binaryGap1(7));
    }
    
    /**
     * 给定一个正整数n，找到并返回n 的二进制表示中两个相邻1之间的  最长距离
     * 如果不存在两个相邻的1，返回0
     * 如果只有0将两个1分隔开（可能不存在0），则认为这两个1彼此相邻，两个1之间的距离是他们二进制表示中位置的差。
     * 如“1001” 中两个1 的距离为3
     * @param n
     * @return
     */
    public int binaryGap1(int n) {
        int max = 0, n1 = n, res = 0;
        while ((n1 & 1) == 0) {
            //当n的最小位不为1时，将n右移，直至最小位为1
            n1 >>= 1;
        }
        while (n1 > 0) {
            n1 >>= 1;
            max++;
            if ((n1 & 1)==1) {
                res = Math.max(res, max);
                max = 0;
            }
        }
        return res;
    }
}
