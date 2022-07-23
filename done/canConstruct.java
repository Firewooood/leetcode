package done;import java.util.HashMap;
import java.util.Map;

public class canConstruct {
    public static void main(String[] args) {
        String ransomNote = "aaaa";
        String magazine = "aaab";
        canConstruct c1 = new canConstruct();
        System.out.println(c1.canConstruct1(ransomNote, magazine));
    }
    
    /**
     * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
     * 
     * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，
     * 判断 ransomNote 能不能由 magazines 里面的字符构成。
     * 
     * 如果可以构成，返回 true ；否则返回 false 。
     * 
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char cur = magazine.charAt(i);
            map.put(cur - 'a', map.getOrDefault(cur - 'a', 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char cur = ransomNote.charAt(i);
            if(!map.containsKey(cur-'a'))
                return false;
            int num = map.get(cur - 'a');
            if (num <= 0)
                return false;
            else {
                map.put(cur - 'a', num - 1);
            }
        }
        return true;
    }
}
