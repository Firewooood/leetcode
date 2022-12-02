package String;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();   // 存储左括号的下标
        int[] temp = new int[s.length()]; // 定义数组记录s对应的括号是否可匹配，不可匹配的为-1
        // 括号入栈，完成匹配数组
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') { // 左括号下标入栈
                stack.push(i);
            } else {
                // 右括号，若栈中有元素
                if (!stack.isEmpty()) {
                    temp[i] = 0;
                    temp[stack.pop()] = 0;
                } else {
                    temp[i] = -1;   // 未被匹配的右括号
                }
            }
        }
        while (!stack.isEmpty()) {
            temp[stack.pop()] = -1;     //未被匹配的左括号
        }
        int res = 0;int cur = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 0;
            }
        }
        return Math.max(res, cur);
    }

    public static void main(String[] args) {
        LongestValidParentheses l1 = new LongestValidParentheses();
        System.out.println(l1.longestValidParentheses(")()())"));
    }
}
