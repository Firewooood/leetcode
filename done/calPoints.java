package done;
import java.util.Stack;

public class calPoints {
    public static void main(String[] args) {
        calPoints c1 = new calPoints();
        String []ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(c1.calPoints1(ops));
    }

    public int calPoints1(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int n = ops.length;
        for (int i = 0; i < n; i++) {
            switch (ops[i]) {
                case "+":
                    int tmp1 = stack.pop();
                    int tmp2 = stack.pop();
                    int sum = tmp1 + tmp2;
                    stack.push(tmp2);
                    stack.push(tmp1);
                    stack.push(sum);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(ops[i]));
            }
        }
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }
}
