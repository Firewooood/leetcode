package StackAndQueue;

import java.util.Stack;

public class IsVAalid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.pop() == '(') {
                    continue;
                }
                return false;
            } else if (!stack.isEmpty() && s.charAt(i) == ']') {
                if (stack.pop() == '[') {
                    continue;
                }
                return false;
            } else {
                if (!stack.isEmpty() && stack.pop() == '{') {
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsVAalid i1 = new IsVAalid();
        String s = "]";
        System.out.println(i1.isValid(s));
    }
}
