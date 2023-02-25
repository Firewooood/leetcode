package String;

import java.util.HashMap;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        // 滑动窗口,包含的情况下：至少有一个窗口只包含s1中的全部字符，并且该窗口每个字符的个数与s1中每个字符的个数相等
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0; // 窗口：左闭右开
        int valid = 0; // 窗口中满足s1要求的字符个数
        while (right < s2.length()) {
            char c = s2.charAt(right);
            ++right; // 扩大窗口
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) { // 字符c满足s1的要求
                    valid++;
                }
            }
            // 求排列，说明窗口[left, right)中字符数量和目标字符数量一样，所以窗口最大为s1.length()
            if (right - left == s1.length()) { // 到达最大窗口，开始收缩窗口
                if (valid == need.size()) { // 窗口中元素是s1的一个排列
                    return true;
                }
                // 收缩窗口
                char d = s2.charAt(left);
                ++left;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) { // 下一步d的个数-1后就不满足了，有效元素-1
                        valid--;
                    }
                    window.put(d, window.get(d) - 1); // 字符d在窗口中的个数-1
                }
            }
        }
        return false;
    }

    public boolean checkInclusion1(String t, String s) {
        int[] need = new int[128], window = new int[128];
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        for (int i = 0; i < t.length(); i++)
            need[t1[i]]++; // 记录目标字符串出现次数
        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            char r = s1[right];
            right++;
            if (need[r] > 0) { // 当前元素满足t
                if (window[r] < need[r])
                    count++;
                window[r]++;
            }
            while (right - left >= t.length()) { // 将左边界处不满足条件者退出
                char l = s1[left];
                if (count == t.length())
                    return true;
                left++;
                if (need[l] > 0) { // 当前元素满足t
                    if (window[l] <= need[l])
                        count--;
                    window[l]--;
                }

            }
        }
        return false;
    }
    public static void main(String[] args) {
        String t = "hello", s = "ooolleloololeh";
        CheckInclusion c1 = new CheckInclusion();
        System.out.println(c1.checkInclusion1(t, s));
    }
}
