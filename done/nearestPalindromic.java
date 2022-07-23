package done;
import java.util.HashSet;
import java.util.Set;

public class nearestPalindromic {
    public static void main(String[] args) {
        nearestPalindromic n1 = new nearestPalindromic();
        System.out.println(n1.n1("123"));
    }
    
    /**
     * 给定一个表示整数的字符串 n，返回距离它最近的回文整数（不包括自身）。如果不止一个
     * 返回较小的那个  最近的定义为 两个整数的/ /差的绝对值// 最小
     * 如 s = 123 返回 121
     *  s = 1 ，0和2 是最近的回文，返回0
     * @param s
     * @return
     */

    /**
     * 
     * 如果数组的字符串长度 == 1，数字n - 1
     * 开头为1，9**9为一个候选答案 例：100000，答案为99999
     * 开头为9, 10**01为一个候选答案 例：99999，答案为100001
     * 如果本身对称，则把最中间的一个（或两个）位数减（如果0则加）一
     * 例：123321，答案为122221
     * 例：120021，答案为121121
     * 如果不对称：
     * 把前半部分逆序替换掉后半部分 例：1223，答案为1221
     * 把最中间的一个（或两个）位数加一 例：1283，答案为1331，而非1221
     * 把最中间的一个（或两个）位数减一 例：1800，答案为1771，而非1881
     */
    public String n1(String s) {
        //小于等于10的数，返回n -1 
        int n = s.length();
        long cur = Long.parseLong(s);
        Set<Long> set = new HashSet<>();
        //将999**999 和1000**001加入set中
        set.add((long) Math.pow(10, n - 1) - 1);
        set.add((long) Math.pow(10, n) + 1);
        //t为字符串s的前半部分
        long t = Long.parseLong(s.substring(0, (n + 1) / 2));
        //将前半部分 以及 +-1的回文加入集合
        for (long i = t - 1; i <= t + 1; i++) {
            long temp = -1;
            if (n % 2 == 0)
                temp = getNum(i, true);
            else
                temp = getNum(i, false);
            if (temp != cur)
                set.add(temp);
        }
        long res = -1;
        //比较当前数字和可能的回文字符串的差距
        for (long i : set) {
            if (res == -1)
                res = i;
            else if (Math.abs(i - cur) < Math.abs(res - cur))
                res = i;
            else if (Math.abs(i - cur) == Math.abs(res - cur) && i < res)
                res = i;
        }
        return String.valueOf(res);
    }

    long getNum(long k, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        sb.append(k);
        int idx = isEven ? sb.length() - 1 : sb.length() - 2;
        while (idx >= 0)
            sb.append(sb.charAt(idx--));
        return Long.parseLong(sb.toString());
    }
}
