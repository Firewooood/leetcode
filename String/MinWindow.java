package String;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        // 维护两个数组，记录已有字符串、目标字符串 指定字符出现次数
        int[] need = new int[128];      // ASCII表长度128
        int[] have = new int[128];
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        for (int i = 0; i < t.length(); i++)
            need[t1[i]]++; // 记录目标字符串出现次数
        
        int left = 0, right = 0, min = s.length() + 1, count = 0, start = 0;
        while (right < s.length()) {
            char r = s1[right];
            if (need[r] == 0) { // 若当前字符不在目标子串中
                right++;
                continue;
            }
            if (have[r] < need[r])
                count++; // 当且仅当滑动窗口中已有子串未达到目标子串出现次数
            have[r]++;
            right++;
            // 当且仅当已有字符串包含所有目标子串字符
            while (count == t.length()) {
                if (right - left < min) { // 更新最小覆盖子串长度
                    min = right - left;
                    start = left;
                }
                char l = s1[left];
                if (need[l] == 0) {
                    // 被去除的字符为left，若当前字符不在目标字串中，直接移除
                    left++;
                    continue;
                }
                if (have[l] == need[l]) { //去除的字符为目标字串中，去除其，滑动窗口部位最小覆盖字串
                    count--;
                }
                have[l]--;
                left++;
            }
        }
        if (min == s.length() + 1) {
            return ""; // 没有符合条件的子串
        }
        return s.substring(start, start + min);
        
    }

    public static void main(String[] args) {
        MinWindow m1 = new MinWindow();
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(m1.minWindow(s, t));
    }
}
