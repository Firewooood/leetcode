package done;
public class KMP {
    public static int strStr(String _haystack, String _needle) {
        char[] haystack = _haystack.toCharArray();
        char[] needle = _needle.toCharArray();
        int[] next = hasNext(needle, needle.length);
        int n1 = haystack.length, n2 = needle.length;
        if (n1 == 0)
            return -1;
        if (n2 == 0)
            return 0;
        int i = 0, j = 0;
        while (j < n2) {//当子串未遍历到结尾
            if (i == n1) {
                return -1;
            }
            if (j == -1 || haystack[i] == needle[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return i - n2;
    }

    public static int[] hasNext(char[] needle, int len) {
        if (len == 1)
            return new int[] { -1 };
        int[] next = new int[len];
        int i = 2, j = -1;
        next[0] = -1;
        next[1] = 0;
        while (i < len) {
            //如对 abbstabbecabbstabb?i进行分析
            // next[i]的值取决于 ? 的值，abbstabbe c abbstabb?，
            //若 ?=e 则next[i] = next [i-1] + 1 = ++j = 9;
            if (j == -1 || needle[i - 1] == needle[j]) { //子串为0,1,····，i-1。
                next[i++] = ++j; //从0，1，···，j ，前后缀串最大匹配长度为 j+1
            } else {
                j = next[j]; //若当前匹配不上,即上面的 ? != e 的情况
                // next[8] = 3, 即abbs tabbecabbst abb?
                //若? = s，则next[i] = 4;否则为0
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        System.out.println(strStr(haystack, needle));
               
    }
}
