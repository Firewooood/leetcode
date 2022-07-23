package done;public class countAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay1(5));
    }
    
    public static String countAndSay1(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder res = new StringBuilder();
            int pos = 0;
            int start = 0;
            while (pos < str.length()) {
                //遍历str字符串
                while (pos < str.length() && str.charAt(pos) == str.charAt(start))
                    pos++;
                res.append(Integer.toString(pos - start)).append(str.charAt(start));
                //模拟下一项是对上一项的描述，n 个 字符 i
                start = pos;
            }
            str = res.toString();
        }
        return str;
    }
}
