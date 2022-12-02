package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtracking(res, 0, 0, n, "");
        return res;
    }

    public void backtracking(List<String> res, int leftNum, int rightNum, int n, String s) {
        if (leftNum == n && rightNum == n) {
            res.add(s);
            return ;
        }
        if (leftNum > n || leftNum < rightNum) {
            return; // 剪枝，s中左括号数量一定大于右括号
        }
        
        backtracking(res, leftNum + 1, rightNum, n, s + "(");
        backtracking(res, leftNum, rightNum + 1, n, s+")");

    }

    public static void main(String[] args) {
        GenerateParenthesis g1 = new GenerateParenthesis();
        g1.generateParenthesis(3);
    }
}
