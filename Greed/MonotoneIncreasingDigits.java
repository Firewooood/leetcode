package Greed;

public class MonotoneIncreasingDigits {
    /**
     * 返回 >= n 的最大数字，且该数字呈单调递增
     * 
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char pre = s.charAt(0);
        int index = 0, index2 = 0; // index1 标记第一个不满足递增的下标， index2 表示最后一个 > 前一位数的下标
        // 从左至右找出第一个不满足单调递增的数
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur - pre < 0) {
                index = i;
                break;
            }
            if (cur - pre > 0)
                index2 = i;
            pre = cur;
        }
        if (index == 0)
            return n;
        index2++;
        String s1 = s.substring(0, index2);
        int v1 = Integer.parseInt(s1) - 1;
        s1 = String.valueOf(v1);
        String s2 = "";
        while (index2++ < s.length()) {
            s2 += "9";
        }

        return Integer.parseInt(s1 + s2);

    }

    public int monotoneIncreasingDigits1(int n) {
        char[] c = String.valueOf(n).toCharArray();
        if (c.length <= 1)
            return n;
        int index = 0;
        for (int i = c.length - 2; i >= 0; i--) {
            if (c[i + 1] < c[i]) { // 低位数字 < 高位数字
                c[i] -= 1;
                index = i;
            }
        }
        index++;
        while (index < c.length) {
            c[index] = '9';
            index++;
        }
        return Integer.parseInt(new String(c));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits m1 = new MonotoneIncreasingDigits();
        System.out.println(m1.monotoneIncreasingDigits1(1234546));
    }
}
