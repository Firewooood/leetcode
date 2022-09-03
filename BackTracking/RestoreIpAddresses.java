package BackTracking;

import java.util.ArrayList;
import java.util.List;

class RestoreIpAddresses {
    List<String> res = new ArrayList<>();
    String cur = "";

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return res;
    }

    // startIndex 记录搜索的起始位置,pointNum记录添加点的数量
    public void backtracking(String s, int startIndex, int pointNum) {
        if (pointNum == 3) { // 已添加三个点,说明IP地址已被分为四份
            if (isValid(s, startIndex, s.length() - 1)) { // 第四子串若合规,则加入结果集中
                cur += s.substring(startIndex, s.length());
                res.add(new String(cur));
            }
            return;
        }
        int len = 0;
        for (int i = startIndex; i < s.length() - 1; i++) {
            if (isValid(s, startIndex, i)) { // 如果符合IP地址规则
                cur += s.substring(startIndex, i + 1);
                cur += ".";
                len = cur.length();
            } else {
                continue;
            }
            backtracking(s, i + 1, pointNum + 1);
            // 回溯过程 将上面backtracking得到的结果删掉
            cur = cur.substring(0, len - i + startIndex - 2);
        }
    }

    // 判断字符串s 是否满足有效IP地址
    public boolean isValid(String s, int start, int end) {
        if (end - start >= 3) // 有效IP地址每位数组在3之间
            return false;
        if (s.charAt(start) == '0' && start != end)
            return false; // 有效地址不能以0 开头, 0 除外
        String num = s.substring(start, end + 1);
        if (Integer.parseInt(num) > 255)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "101023";
        RestoreIpAddresses r1 = new RestoreIpAddresses();
        List<String> res = r1.restoreIpAddresses(s);
        for (String x : res) {
            System.out.println(x);
        }
    }
}