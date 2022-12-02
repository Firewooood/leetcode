import java.util.LinkedList;
import java.util.List;

public class LexicalOrder {
    // 给一个整数n，按字典序返回范围[1,n]内所有整数
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        dfs(n, res, 0);
        return res;
    }

    public void dfs(int n, List<Integer> res, int cur) {
        if (cur != 0)
            res.add(cur);

        for (int i = 0; i < 10; i++) {
            int x = cur * 10 + i;
            if (x != 0 && x <= n) {
                dfs(n, res, x);
            }
        }
    }

    public static void main(String[] args) {
        LexicalOrder l1 = new LexicalOrder();
        List<Integer> res = l1.lexicalOrder(13);
    }
}
