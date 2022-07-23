package String;

public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        // 去除多余的空格
        int i = 0, j = 0;
        while (j < sb.length()) {
            // 跳过连续的空格
            while (j < sb.length() && sb.charAt(j) == ' ') {
                j++;
            }
            if (i != 0) {
                // 在非第一个字符串前加入空格
                if (j == sb.length())
                    break;
                sb.setCharAt(i, ' ');
                i++;
            }
            while (j < sb.length() && sb.charAt(j) != ' ') {
                sb.setCharAt(i, sb.charAt(j));
                i++;
                j++;
            }
        }
        // 原地去除空格。
        if (i < sb.length()) {
            sb.delete(i, sb.length());
        }

        // 将原字符串整体倒置
        i = 0;
        j = sb.length() - 1;
        reverse(sb, i, j);
        // 从头开始，将各字符倒转过来
        i = 0;
        j = 0;
        while (j < sb.length()) {
            // 将j 移至一单词末尾
            while (j < sb.length() - 1 && sb.charAt(j + 1) != ' ') {
                j++;
            }
            int tmp = j;
            reverse(sb, i, j);
            i = tmp + 2;
            j = tmp + 2;
        }
        return sb.toString();

    }

    public void reverse(StringBuilder sb, int i, int j) {
        while (i < j) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ReverseWords r1 = new ReverseWords();
        String s = "a good   example    ";
        System.out.println(r1.reverseWords(s));
    }
}
