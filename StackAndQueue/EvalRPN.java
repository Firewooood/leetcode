package StackAndQueue;

import java.util.Stack;

public class EvalRPN {
    /**
     * 根据tokens逆波兰表示法，给出表达式的值
     * 
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> s1 = new Stack<>();
        int num1, num2;
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("+") && tokens[i] != "-" && tokens[i] != "*" && tokens[i] != "/") {
                // 目前逆波兰表达式中的值为 数, 将其压入栈中
                s1.push(Integer.parseInt(tokens[i]));
            } else if (tokens[i] == "+") {
                num1 = s1.pop();
                num2 = s1.pop();
                s1.push(num2 + num1);
            } else if (tokens[i] == "-") {
                num1 = s1.pop();
                num2 = s1.pop();
                s1.push(num2 - num1);
            } else if (tokens[i] == "/") {
                num1 = s1.pop();
                num2 = s1.pop();
                s1.push(num2 / num1);
            } else {
                num1 = s1.pop();
                num2 = s1.pop();
                s1.push(num2 * num1);
            }
        }

        return s1.peek();
    }

    public static void main(String[] args) {
        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };

        EvalRPN e1 = new EvalRPN();
        System.out.println(e1.evalRPN(tokens));
    }
}
