package String;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> num = new Stack<>();
        Stack<String> s1 = new Stack<>();
        char[] c = s.toCharArray();
        int tmpNum = 0;
        String tmpS = "";
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') {
                tmpNum = c[i] - '0' + tmpNum * 10;
            } else if (c[i] >= 'a' && c[i] <= 'z') {
                tmpS += c[i];
            } else if (c[i] == '[') {
                num.push(tmpNum);
                s1.push(tmpS);
                tmpNum = 0;
                tmpS = "";
            } else if (c[i] == ']') {
                int n = num.pop();
                String s2 = s1.pop();
                for (int j = 0; j < n; j++) {
                    s2 += tmpS;
                }
                tmpS = s2;
            }
        }
        res += tmpS;
        return res;
    }
    public static void main(String[] args) {
        String s = "100[leetcode]";
        DecodeString d1 = new DecodeString();
        System.out.println(d1.decodeString(s));
    }
}
