package Greed;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    five++;
                    break;
                case 10:
                    five--;
                    ten++;
                    break;
                default:
                    if (ten > 0) {
                        ten--;
                        five--;
                    } else {
                        five -= 3;
                    }
            }
            if (five < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = { 5, 5, 10, 10, 20 };
        LemonadeChange l1 = new LemonadeChange();
        System.out.println(l1.lemonadeChange(bills));
    }
}
