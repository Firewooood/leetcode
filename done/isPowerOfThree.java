package done;public class isPowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree1(2147483647));
    }

    public static boolean isPowerOfThree1(int n) {
        if (n <= 0)
            return false;
        while (n % 3 == 0)
            n /= 3;
        return n == 1;

    }
    //也可直接求得int 范围内的最大3次幂，约为3^19=1162261467
    //则如果n为3的幂的话，必然满足n*3^k = 1162261467,即1162261467是n的倍数
    //直接return n > 0 && 1162261467 % n == 0；即可
}
