package done;

public class truncateSentence {
    public static void main(String[] args) {
        truncateSentence t1 = new truncateSentence();
        String s = "chopper is not a tanuki";
        int k = 5;
        System.out.println(t1.t1(s, k));
    }
    
    /**
     * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，
     * 且不存在前导或尾随空格。
     * 每个单词仅由大小写英文字母组成（不含标点符号）。
     * 给你一个句子 s​​​​​​ 和一个整数 k​​​​​​ ，请你将 s​​ 截断 ​，
     * ​​​使截断后的句子仅含 前 k​​​​​​ 个单词。
     * 返回 截断 s​​​​​​ 后得到的句子。
     * @param s
     * @param k
     * @return
     */
    public String t1(String s, int k) {
        StringBuilder res = new StringBuilder();
        String[] cur = s.split(" ");
        for (int i = 0; i < k - 1; i++) {
            res.append(cur[i]);
            res.append(" ");
        }
        res.append(cur[k - 1]);
        return res.toString();
    }
}
