package done;public class licenseKeyFormatting {
    public static void main(String[] args) {
        String s = "a-a-a-a-";
        System.out.println(licenseKeyFormatting1(s, 2));
    }
    
    public static String licenseKeyFormatting1(String s,int k)
    {
        StringBuilder res = new StringBuilder();

        //删去string中的  '-'  将小写字母换为大写字母
        String[] split = s.toUpperCase().split("-");
        for (String a : split) {
            res.append(a);
        }
        //将上面处理好的string按k进行分段   
        for (int i = res.length() - k; i > 0; i -= k) {
            res.insert(i, '-');
        }
        //从后往前插入，不会导致插入的字符被下一次重复计算。
        return res.toString();
    }
}
