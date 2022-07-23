package done;

public class convertToBase7 {
    public static void main(String[] args) {
        convertToBase7 c1 = new convertToBase7();
        System.out.println(c1.convert(100));
    }
    
    public String convert(int num) {
        boolean flag = true;
        String res = "";
        int mod;
        if (num < 0)
            flag = false;
        if (num == 0) {
            
        }
        num = num > 0 ? num : -1 * num;
        while (num > 0) {
            mod = num % 7;
            res = Integer.toString(mod) + res;
            num /= 7;
        } 
        return flag ? res : "-" + res;
    }
}
