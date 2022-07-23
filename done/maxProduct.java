package done;

import java.util.HashSet;
import java.util.Set;

public class maxProduct {
    public static void main(String[] args) {
        String[] words = { "a", "aa", "aaa", "aaaa" };
        maxProduct m = new maxProduct();
        System.out.println(m.m1(words));
    }
    

    /**
     * 给定一个字符串数组 words，找到 length(word[i]) *
     * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
     * 你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
     * @param words
     * @return
     */
    public int m1(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            Set<Character> set = new HashSet<>();
            for (int k = 0; k < words[i].length(); k++) {
                set.add(words[i].charAt(k));
            }
            for (int j = i + 1; j < words.length; j++) {
                for (int r = 0; r < words[j].length(); r++) {
                    if (set.contains(words[j].charAt(r)))
                        break;
                    if(r==words[j].length()-1)
                    {
                        max = Math.max(max, words[i].length() * words[j].length());
                    }
                }
            }
        }
        return max;
    }
}
