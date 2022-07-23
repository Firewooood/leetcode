package done;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongEstSubString {
     public static void main(String[] args) {
         LengthOfLongEstSubString l1 = new LengthOfLongEstSubString();
         System.out.println(l1.sub("aavaf"));
     }
    
     public int sub(String s) {
         int len = s.length(), max = 0;
         if (s.length() < 1 || s == null)
             return 0;
         int[] dp = new int[len + 1]; // 定义数组，dp[i]为以i为底的最长字串。
         Set<Character> set = new HashSet<>(); // 定义当前字母是否在已出现过
         for (int i = 0; i < len; i++) {
             char c = s.charAt(i);
             if (!set.contains(c)) {
                 //若当前字母未出现过
                 dp[i + 1] = dp[i] + 1;
                 if (dp[i + 1] > max)
                     max = dp[i + 1];
                 set.add(c);
             } else {
                 dp[i + 1] = 1;
                 set.clear();
                 set.add(c);
             }
         }
         return max;
     }
}
