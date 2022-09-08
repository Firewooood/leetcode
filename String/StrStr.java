package String;

public class StrStr {
    // KMP

    public int strStr(String h, String n) {
        int len1 = h.length(), len2 = n.length();
        // 构建n 的next数组
        int[] next = new int[len2];
        getNext(next, n);
        int i = 0, j = -1;
        while (i < len1) {
            while (j >= 0 && h.charAt(i) != n.charAt(j + 1)) {
                j = next[j];
            }
            if (h.charAt(i) == n.charAt(j + 1)) {
                j++;
            }
            if (j == len2 - 1)
                return i - len2 + 1;
            i++;
        }
        return -1;
    }

    public void getNext(int[] next, String n) {
        int j = -1;
        next[0] = j;
        // i 指向后缀末尾部分, j 指向前缀末尾部分
        for (int i = 1; i < n.length(); i++) {
            while (j >= 0 && n.charAt(i) != n.charAt(j + 1)) {
                // 前后缀不相同, 向前回退
                j = next[j]; // 寻找当前比较字符前一位 对应的回退位置
            }
            if (n.charAt(i) == n.charAt(j + 1)) {
                j++;
            }
            next[i] = j; // 将j(前缀长度)赋给next[i]
        }
    }

    public static void main(String[] args) {
        String h = "abababababbbabbbb";
        String n = "abac";
        StrStr s1 = new StrStr();
        System.out.println(s1.strStr(h, n));
    }

}
