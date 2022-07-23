package done;import java.util.HashMap;
import java.util.Map;

public class fractionToDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal1(3, 5));
    }
    
    public static String fractionToDecimal1(int numerator, int denominator)
    {
        StringBuilder res = new StringBuilder();
        long a = numerator, b = denominator;

        //异号的情况,加上负号
        if (a > 0 && b < 0 || a < 0 && b > 0)
            res.append('-');
        a = Math.abs(a);
        b = Math.abs(b);

        //整数部分
        res.append(a/b);

        //小数点
        if(a%b!=0)
            res.append('.');

        //小数部分
        Map<Long, Integer> map = new HashMap<>();
        while ((a = (a % b) * 10) > 0 && !map.containsKey(a)) {
            //a = (a % b) * 10 模拟除法操作的末尾添0过程。
            // 若整除，或者小数部分循环，则退出循环
            map.put(a, res.length());
            //将除得的结果存入map中，索引为当前所在的位数。
            res.append(a / b);
        }
        //若除尽
        if (a == 0)
            return res.toString();
        return res.insert(map.get(a).intValue(), '(').append(')').toString();
            //上文的while退出循环时，a为循环开始的第一个数，在该数之前插入 （ ，在结尾插入）
    }
}
