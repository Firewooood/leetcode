package done;
public class longestPalindrome {
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1)
            return "";
        // 将字符串s构造成"#a#b#a#b#"形式的字符数组
        char[] charArr = manacherString(s);
        int[] radius = new int[charArr.length]; // 记录每个位置的回文半径
        int R = -1; // 记录最右回文右边界
        int c = -1; // 最右回文右边界的对称中心
        int max = Integer.MIN_VALUE;
        int maxi = -1;
        for (int i = 0; i < radius.length; i++) {
            // 1.如果R > i 则此时无优化算法，直接向右暴力扩张，将回文半径初步设为1
            // 2.如果R < i；若i 关于 c 的对称点i`的回文区，在c的回文区内，则回文半径为 i`的回文半径radius[2*c-i]
            // 若i`的回文区在c的回文区边界上(或外), 则回文半径至少为i 到 R的距离R-i+1
            radius[i] = R > i ? Math.min(radius[2 * c - i], R - i + 1) : 1;
            // 若i的回文区左右边界 未 过界
            while (i + radius[i] < charArr.length && i - radius[i] > -1) {
                if (charArr[i - radius[i]] == charArr[i + radius[i]]) {
                    // 比较回文区左边界前一字符和 右边界后一字符
                    radius[i]++;
                } else {
                    break;
                }
            }
            // 更新最右回文右边界
            if (i + radius[i] > R) {
                R = i + radius[i] - 1;
                c = i;
            }
            // 分别记录最大回文半径 和 回文子串的中心点位置
            if (radius[i] > max) {
                max = radius[i];
                maxi = i;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int j = maxi - max + 1; j <= maxi + max - 1; j++) {
            if (charArr[j] != '#')
                res.append(charArr[j]);
        }
        return res.toString();
    }

    public char[] manacherString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        return sb.toString().toCharArray();
    }

    public static void main(String[] args) {
        longestPalindrome l1 = new longestPalindrome();
        String res = l1.longestPalindrome1("babad");
        System.out.println(res);
    }
}
