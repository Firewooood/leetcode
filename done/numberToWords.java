package done;   

public class numberToWords {
    public static void main(String[] args) {
        System.out.println(numberToWords1(121344534));
    }
    static String[] num2str_small = {
        "Zero", 
        "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    static String[] num2str_medium = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    static String[] num2str_large = {
        "Billion", "Million", "Thousand", "",
    };

    public static String  num2Str(int x) {
        String res = "";
        if (x >= 100) {
            res += num2str_small[x / 100] + " Hundred ";
            x %= 100;
        }
        if (x >= 20) {
            res += num2str_medium[x / 10] + " ";
            x %= 10;
        }
        if (x != 0)
            res += num2str_small[x] + " ";
        return res;
    }

    public static String numberToWords1(int num) {
        if (num == 0)
            return num2str_small[0];
        StringBuilder res = new StringBuilder();
        //每三位一组，分别从前至后将数字转换成string
        for (int i = (int) 1e9, j = 0; i >= 1; i /= 1000, j++) {
            if (num < i)
                continue;
            res.append(num2Str(num / i) + num2str_large[j] + " ");
            num %= i;
        }
        //删除res末尾的空格。
        while (res.charAt(res.length() - 1) == ' ')
            res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
