package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        // 将p中各字母的频数存入map中
        for (char c : p1) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0, count = 0, start = 0;
        while (r < s.length()) {
            // 当前字符在p中
            if (need.containsKey(s1[r])) {
                window.put(s1[r], window.getOrDefault(s1[r], 0)+1);
                if (need.get(s1[r]).equals(window.get(s1[r]))) {
                    // 此处不可使用need.get(s1[r]) == window.get(s1[r]) 来判断
                    // Integer在大于127之后，不从常量池中拿。两个对象int值相等，但地址不等
                    count ++;
                }
            }
            r++;
            //  始终维持一个长度为p.length 的滑动窗口
            while(r - l >= p.length()){
                if (need.containsKey(s1[l])) {
                    if (count == need.size()) {
                        // 当前windows中字母满足p
                        res.add(l);
                    }
                    if (need.get(s1[l]).equals(window.get(s1[l]))) {
                        count--;
                    }
                    window.put(s1[l], window.get(s1[l]) - 1);
                    if (window.get(s1[l]) == 0)
                        window.remove(s1[l]);
                }
                l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAnagrams f1 = new FindAnagrams();
        String s = "cbaebabacd", p = "abc";
        List<Integer> res = f1.findAnagrams(s, p);
        
    }
}
