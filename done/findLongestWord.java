package done;import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class findLongestWord {
    public static void main(String[] args) {
        String[] aaa = { "ale", "apple", "monkey", "plea" };
        List<String> dictionary = Arrays.asList(aaa); //将String转为List<String>
        System.out.println(findLongestWord1("abpcplea", dictionary));
    }

    public static String findLongestWord1(String s, List<String> dictionary) {
        //先对dictionary进行排序， 长度不同的字符串，按长度降序排序
        //长度相同的，按字符串的字典序升序排列
        Collections.sort(dictionary,(a,b)->{
            if (a.length() != b.length())
                return b.length() - a.length();
            //如果compare方法大于0，则将前一个数和后一数交换 ，亦即升序排列。
            return a.compareTo(b);
        });
        for (String a : dictionary) {
            int i = 0;
            int j = 0;
            //i用于在a上滑动，j用于在s上滑动
            while(i<a.length()&&j<s.length())
            {
                if (a.charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                } else
                    j++;
            }
            if (i == a.length())
                return a;
        }
        return "";
    }
}
