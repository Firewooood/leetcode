package done;
public class maxPower {
    public int maxPower1(String s) {
        int max = 1, start = 0, end = 1;
        //使用双指针找出最大值
        while (end < s.length()) {
            if(s.charAt(start)==s.charAt(end))
            {
                end++;
                max = Math.max(max, end - start);
            }
            else {
                start = end;
                end++;
            } 
        }
        return max;

    }
    
    public static void main(String[] args) {
        maxPower p1 = new maxPower();
        System.out.println(p1.maxPower1("leetcode"));
    }
}
