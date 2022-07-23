package done;public class canWinNim {
    public static void main(String[] args) {
        System.out.println(canWinNim1(16));
    }
    
    public static boolean canWinNim1(int n) {
        int i = n % 4;
        if(i==0)
            return false;
        else
            return true;
    }
}
