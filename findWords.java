import java.util.ArrayList;

import java.util.List;

import javax.sql.rowset.WebRowSet;

public class findWords {
    public static void main(String[] args) {
        String[] input = { "Hello", "Alaska", "Dad", "Peace" };
        String[] res = f1(input);
        for(String x:res)
        System.out.println(x);
    }

    public static String[] f1(String[] words) {
        List<String> list = new ArrayList<>();
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        for (String word : words) {
            int n1=0,n2=0,n3=0,len = word.length();
            out: for (int i = 0; i < word.length(); i++) {
                if (s1.contains(word.charAt(i) + ""))
                    n1++;
                else if (s2.contains(word.charAt(i) + ""))
                    n2++;
                else
                    n3++;
            }
            if (n1 == len || n2 == len || n3 == len)
                list.add(word);
        }
        return list.toArray(new String[list.size()]);
    }

}
