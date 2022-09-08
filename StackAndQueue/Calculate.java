package StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculate {
    // + - * /
    public int calculate(String s) {
        Stack<Integer> num = new Stack<>(); // 操作数栈
        Stack<Character> op = new Stack<>(); // 运算符栈
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        // num.push(0);
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ' ')
                continue;
            if (cur >= '0' && cur <= '9') {
                temp = temp * 10 + cur - '0';
            } else {
                num.push(temp);
                temp = 0;
                while (!op.empty() && (map.get(op.peek()) >= map.get(cur))) {
                    calc(num, op);
                } // 当操作符栈为空 或 栈中操作符优先级小于当前运算符时
                op.push(cur);
            }
        }
        num.push(temp);
        int len = op.size();
        for (int i = 0; i < len; i++) {
            calc(num, op);
        }
        return num.peek();
    }

    // + - ( )
    public int calculate2(String s) {
        Stack<Integer> num = new Stack<>(); // 操作数栈
        Stack<Character> op = new Stack<>(); // 运算符栈
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        num.push(0);
        int temp = 0;
        s = s.replaceAll(" ", "");
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                if (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '-') {
                    // 处理类似(-2) (+2) 这种情况
                    num.push(0);
                }
                // 左括号直接入栈
                op.push(cur);
            } else if (cur == ')') {
                while (op.peek() != '(') {
                    calc(num, op); // 运算括号内的
                }
                op.pop(); // 弹出左括号
            } else {
                if (cur >= '0' && cur <= '9') {
                    temp = 0;
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        temp = 10 * temp + s.charAt(i) - '0';
                        i++;
                    }
                    i--;
                    num.push(temp);
                } else {
                    while (!op.empty() && op.peek() != '(' && (map.get(op.peek()) >= map.get(cur))) {
                        calc(num, op);
                    } // 当操作符栈为空 或 栈中操作符优先级小于当前运算符时
                    op.push(cur);
                }
            }
        }
        int len = op.size();
        for (int i = 0; i < len; i++) {
            calc(num, op);
        }
        return num.peek();
    }

    void calc(Stack<Integer> num, Stack<Character> op) {
        // 栈中操作符优先级大于当前操作符时
        int num2 = num.pop();
        int num1 = num.pop();
        char op1 = op.pop();
        if (op1 == '+') {
            num.push(num1 + num2);
        } else if (op1 == '-') {
            num.push(num1 - num2);
        } else if (op1 == '*') {
            num.push(num1 * num2);
        } else {
            num.push(num1 / num2);
        }
    }

    public static void main(String[] args) {
        Calculate c1 = new Calculate();
        String s = "1*2-3/4+5*6-7*8+9/10";
        String s1 = "1 - ( - 2)";
        System.out.println(c1.calculate2(s1));
    }
}
