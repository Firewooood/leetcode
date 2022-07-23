package done;

public class complexNumberMultiply {
    public static void main(String[] args) {
        complexNumberMultiply c1 = new complexNumberMultiply();
        String num1 = "1+1i";
        String num2 = "1+-1i";
        System.out.println(c1.Multiply(num1, num2));
    }
    
    public String Multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        String[] temp = num1.split("\\+|i");
        // 使用 +或i 分割，使用`|`表示或，连接 + 和 i。
        // + 在正则表达式中有特殊含义，使用\\+来表示
        int x1 = Integer.valueOf(temp[0]);
        int y1 = Integer.valueOf(temp[1]);
        temp = num2.split("\\+|i");
        int x2 = Integer.valueOf(temp[0]);
        int y2 = Integer.valueOf(temp[1]);
        res.append((x1 * x2 - y1 * y2) + "+" + (x1 * y2 + x2 * y1) + "i");
        return res.toString();
    }
}