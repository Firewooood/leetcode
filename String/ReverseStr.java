package String;

public class ReverseStr {
    public String reverseStr(String s, int k) {
        // 每隔k个反转k个，末尾不够k个时全部反转；
        int n = s.length();
        char[] s1 = s.toCharArray();
        int start = 0, end = k - 1;
        while (n - 1 > end) {
            // 反转前 2*n*k 的字符串
            int k1 = start, k2 = end;
            while (start < end) {
                char tmp = s1[start];
                s1[start] = s1[end];
                s1[end] = tmp;
                start++;
                end--;
            }
            start = k1 + 2 * k;
            end = k2 + 2 * k;
        }
        if (start < n) {
            // 为剩余字符串少于k的情况
            end = n - 1;
            while (start < end) {
                char tmp = s1[start];
                s1[start] = s1[end];
                s1[end] = tmp;
                start++;
                end--;
            }
        }
        return String.valueOf(s1);
    }
}
