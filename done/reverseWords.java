package done;
import java.util.Stack;

public class reverseWords {
    public static void main(String[] args) {
        reverseWords r1 = new reverseWords();
        System.out.println(r1.reverseWords1("the sky is blue"));
    }
    public String reverseWords1(String s) {
        int n = s.length();
        int i = 0 ,j = 0;  
        Stack <String> stack = new Stack<>();
        while (j < n) {
            while (s.charAt(j) == ' ') {
                j++;
            }
            i = j; //使用i记录空格后第一个字母的下标
            while (j < n && s.charAt(j) != ' ') {
                    j++;
            }
                
            String temp = s.substring(i, j);
            stack.push(temp);
        }
        return " ";
    }
}
