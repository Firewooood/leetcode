package HashMap;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, max = 0; // 定义滑动窗口的起终点
        while (end < s.length()) {
            char cur = s.charAt(end);
            if (!map.containsKey(cur)) {
                // 若end处char不为重复元素
                map.put(cur, end);
                end++;
            } else {
                // 若当前char 为重复元素
                if(map.get(cur) + 1 > start)
                    start = map.get(cur) + 1;
                map.put(cur, end); // 维护map中字符为最新的
                end++;
            }
            max = Math.max(max, end - start);
         }

        return max;
    }
    public static void main(String[] args) {
        String s = "abba";
        LengthOfLongestSubstring l1 = new LengthOfLongestSubstring();
        System.out.println(l1.lengthOfLongestSubstring(s));
    }
}

