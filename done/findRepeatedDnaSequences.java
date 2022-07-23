package done;import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findRepeatedDnaSequences {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = findRepeatedDnaSequences1(s);
        for(String r:res)System.out.println(r);
    }
    
    public static List<String> findRepeatedDnaSequences1(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= len; i++) {
            String cur = s.substring(i, i + 10);//分割要进行判断的字串
            int n = map.getOrDefault(cur, 0);//若map中有当前判断的子串，则获取他的值，否则置零
            if (n == 1)
                res.add(cur);//若cur在map中出现两次，则加入输出列表中。
            map.put(cur, n + 1);
        }
        return res;
    }
}
