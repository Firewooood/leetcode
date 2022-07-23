package done;

import java.util.Arrays;

public class originalDigits {

    public static void main(String[] args) {
        originalDigits o1 = new originalDigits();
        System.out.println(o1.s1("owoztneoer"));
    }

    static String[] ss = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine" };
    static int[] priority = new int[] { 0, 8, 6, 3, 2, 7, 5, 9, 4, 1 };

    public String s1(String s) {
        int n = s.length();
        int[] cnts = new int[26];
        for (int i = 0; i < n; i++)
            cnts[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i : priority) {
            int k = Integer.MAX_VALUE;
            for (char c : ss[i].toCharArray())
                k = Math.min(k, cnts[c - 'a']);
            //当当前字母为zero时，取zero四个字母中出现次数最少的，即为0的个数
            for (char c : ss[i].toCharArray())
                cnts[c - 'a'] -= k;
            while (k-- > 0)
                sb.append(i);
        }
        char[] cs = sb.toString().toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);
    }
}
