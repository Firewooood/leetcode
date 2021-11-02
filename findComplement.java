public class findComplement {
    public static void main(String[] args) {
        findComplement f1 = new findComplement();
        System.out.println(f1.f(226));
    }
    
    public int f(int num) {
        int n = num;
        num |= num>>>1;
        num |= num>>>2;
        num |= num>>>4;
        num |= num>>>8;
        num |= num>>>16;
        return num - n;
    }
}
