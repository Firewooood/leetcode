package done;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class longestWord {
    public static void main(String[] args) {
        longestWord l1 = new longestWord();
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        System.out.println(l1.Long(words));
    }

    public String Long(String[] words) {
        int n = words.length, max = 0;
        //将words中的字符串按字典序排序
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b){ 
                if(a.length()!=b.length())
                    return a.length() - b.length();
                else {
                    return a.compareTo(b);
                }
            }
        });

        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for (String w : words) {
            if (w.length() == 1) {
                map.put(w, 1); // 长度为1的字符串直接存入表中
                queue.add(w);
                max = 1;
            } else {
                int len = w.length();
                if (len > max + 1)
                    break;
                if (map.get(w.substring(0, len - 1)) != null) //若当前字符串有前缀，则将其加入map中，且更新最大长度；
                {
                    //queue中word长度可增加时，将较短的word清除。
                    if (len == max + 1) {
                        queue.clear();
                    }
                    map.put(w, len);
                    queue.add(w);
                    max = len;
                }
            }
        }
        String res = queue.peek();
        return  res == null ? "" : res;
    }

}


