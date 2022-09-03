package done;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordDictionary {
    Map<Integer, Set<String>> map;

    // 使用word 的长度做Map的key，若相等，则在value 集合中找到该值。
    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        int len = word.length();
        map.computeIfAbsent(len, k -> new HashSet<>());
        // 如果key对应的value不存在，则获取后续的lambda表达式重新计算的值，保存为该key的value
        map.get(len).add(word);
    }

    public boolean search(String word) {

        int len = word.length();
        if (null == map.get(len)) {
            return false;
        }
        Set<String> set = map.get(len);
        // 需考虑word中有"."的情况
        for (String w : set) {
            boolean res = true;
            for (int i = 0; i < word.length(); i++) {
                if (w.charAt(i) != '.' && word.charAt(i) != '.' && w.charAt(i) != word.charAt(i)) {
                    res = false;
                    break;
                }
            }
            if (res) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary word = new WordDictionary();
        word.addWord("bad");
        word.addWord("mad");
        word.addWord("pad");
        boolean param_2 = word.search("mad");
        System.out.println(param_2);
    }
}
