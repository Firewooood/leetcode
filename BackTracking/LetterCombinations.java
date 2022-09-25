package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String s = "";

        backTracking(digits, s, res, 0);
        return res;
    }

    void backTracking(String digits, String s, List<String> res, int len) {
        if (s.length() == digits.length()) {
            res.add(new String(s));
            return;
        }

        int x = digits.charAt(len) - '0';
        for (int i = 0; i < map[x].length(); i++) {
            String s1 = s + map[x].charAt(i);
            backTracking(digits, s1, res, len + 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations l1 = new LetterCombinations();
        List<String> res = l1.letterCombinations("23");
        for (String s : res)
            System.out.println(s + ",");
    }
}
