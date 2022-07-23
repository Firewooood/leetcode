package done;public class findNthDigit {

    /**
     * 给你一个整数 n ，
     * 请你在无限的整数序列 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第 n 位数字。
     * 如 n = 11 时，返回 0， 0是10的一部分
     * @param n
     * @return
     */
    public int f1(int n) {
        if (n < 10)
            return n;
        int d = 1;//定义d记录整数的位数
        int cnt = 9;//当前位数整数的个数
        //一位数字不含0 有9个，两位数字有90个，三位数字有900个,由此增加
        while (n > (long) d * cnt) {
            n -= d * cnt;
            d++;
            cnt *= 10;
        }
        int remainder = (n) % d;
        int res = remainder == 0 ? n / d : n / d + 1;
        res = cnt/9 + res - 1;
        System.out.println(res);
        // char - ‘0’ 即得该char 所对应的 int
        return String.valueOf(res).charAt((remainder + d -1) % d) - '0';
    }

    public static void main(String[] args) {
        findNthDigit f1 = new findNthDigit();
        System.out.println(f1.f1(22));
    }
}
