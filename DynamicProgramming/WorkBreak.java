package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; // dp[i] 表示可否由wordDict中的String构成 s[0,i);
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                int len = wordDict.get(j).length();
                if (i - len >= 0 && dp[i - len]) {
                    String cur = s.substring(0, i - len);
                    cur += wordDict.get(j);
                    if (cur.equals(s.substring(0, i))) {
                        dp[i] = true;
                    }
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        WorkBreak w1 = new WorkBreak();
        System.out.println(w1.wordBreak(s, wordDict));

    }
}
