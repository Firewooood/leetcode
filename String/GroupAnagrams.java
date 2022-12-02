package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GroupAnagrams {
    // 将字母异位词组合在一起。
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        // 使用质数表示每个字母，单词字母乘积可以区分各个单词
        int[] word = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
                103 };
        Map<Double, List<String>> map = new HashMap<>();
        for (String s : strs) {
            double cur = 1;
            for (int i = 0; i < s.length(); i++) {
                cur *= word[s.charAt(i) - 'a'];
            }
            if (!map.containsKey(cur)) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(cur, temp);
            } else {
                List<String> temp = map.get(cur);
                temp.add(s);
            }
        }

        for (Map.Entry<Double, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams g1 = new GroupAnagrams();
        String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        g1.groupAnagrams(strs);
    }
}
