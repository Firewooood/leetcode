package done;
public class numWaterBottles {
    public static void main(String[] args) {
        numWaterBottles n1 = new numWaterBottles();
        int numBottles = 15, numExchange = 4;
        System.out.println(n1.n1(numBottles, numExchange));
    }
    
    /**
     * 小区便利店正在促销，
     * 用 numExchange 个空酒瓶可以兑换一瓶新酒。
     * 你购入了 numBottles 瓶酒。
     * 
     * @param numBottles
     * @param numExchange
     * @return  最多喝到的酒
     */

    public int n1(int numBottles, int numExchange) {
        int res = 0;
        int quotient = 0, remainder = 0;
        while (numBottles >= numExchange) {
            quotient = numBottles / numExchange;
            remainder = numBottles % numExchange;
            res += numBottles - remainder;
            numBottles = remainder + quotient;
        }
        res += numBottles;
        return res;
    }
}