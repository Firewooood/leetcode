package StackAndQueue;

import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (stack.empty() || stack.peek() != s.charAt(i)) {
                stack.add(cur); // 栈空时、不等栈顶元素的元素 入栈
            } else {
                stack.pop();
            }
        }
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates r1 = new RemoveDuplicates();
        String s = "abbaca";
        System.out.println(r1.removeDuplicates(s));
    }
}
