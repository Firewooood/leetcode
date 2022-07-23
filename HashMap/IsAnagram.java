package HashMap;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            int x = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), x);
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                int x = map.get(t.charAt(i)) - 1;
                if (x < 0)
                    return false;
                map.put(t.charAt(i), x);
            } else {
                return false;
            }
        }
        // map.entrySet()
        return true;
    }

    public static void main(String[] args) {
        IsAnagram i1 = new IsAnagram();
        String s = "aacc", t = "ccac";
        System.out.println(i1.isAnagram(s, t));
    }
}
