package String;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s.equals(""))
            return false;
        int len = s.length();
        // 原串加个空格(哨兵),使下标从1开始，这样j从0开始，不用初始化

        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];
        // 构造next数组， j从0开始，i从2开始
        int i = 2, j = 0;
        next[0] = -1;
        next[1] = 0;
        while (i <= len) {
            if (j == -1 || chars[i - 1] == chars[j]) {
                next[i++] = ++j;
            } else {
                j = next[j];
            }
        }

        if (next[len] > 0 && len % (len - next[len]) == 0)
            return true;

        return false;
    }

    public boolean repeatedSubstringPattern2(String s) {
        // 我们将两个s 连在一起，并且移除第一个和最后一个字符，如果s是该字符的子串，则s满足要求。

        // 下面的代码中， 从位置 1 开始查询 [两个s连在一起的串] 中 s 子串的出现位置。 并且希望查询结果不为n。
        // 等价于 移除字符串的第一个和最后一个字符。
        return (s + s).indexOf(s, 1) != s.length();
    }

    public static void main(String[] args) {
        String s = "ababba";
        RepeatedSubstringPattern r1 = new RepeatedSubstringPattern();
        System.out.println(r1.repeatedSubstringPattern(s));
    }
}
