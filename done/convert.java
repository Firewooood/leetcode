package done;

public class convert {
    public static void main(String[] args) {
        convert c1 = new convert();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(c1.convert1(s, numRows));
    }
    
    /**
     * 将一个给定字符串s根据给定的行数 numRows，以从上往下、从左到右进行Z字排列。
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 行数为4时，排列如下
     * P     I     N
     * A   L S   I G
     * Y A   H R
     * P     I
     * 
     * @param s
     * @param numRows
     * @return
     */
    public String convert1(String s, int numRows) {
        //可知本题为对原字符串进行取模2n-2，余数相同或互补的，即在同一行
        String []res = new String [numRows];
        //定义numRows个String，用于记录每一层的字符和
        if (s.length() == 0 || numRows <= 1) {
            return s;
        }
        int mod = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int j = i % mod;
            if (j > numRows - 1) {
                j = mod - j;
            }
            if (res[j] == null)
                res[j] = "";
            res[j] += s.charAt(i);
        }
        for (int i = 1; i < numRows; i++) {
            res[0] += res[i] == null ? "" : res[i];
        }
        return res[0];
    }
}
