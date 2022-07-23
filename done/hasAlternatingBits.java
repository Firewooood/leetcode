package done;
class hasAlternatingBits {
    public static void main(String[] args) {
        hasAlternatingBits h1 = new hasAlternatingBits();
        System.out.println(h1.h1(178956970));
    }
    
    public boolean h1(int n) {
        int n1 = n << 1;
        n1 += n % 2 == 0 ? 1 : 0;
        int res = n1 ^ n;
        double tmp = Math.log(res + 1) / Math.log(2);
        return Math.abs(tmp - Math.round(tmp)) < Double.MIN_VALUE;
        // if (tmp == (int) tmp)
        //     return true;
        // return false;
    }
}